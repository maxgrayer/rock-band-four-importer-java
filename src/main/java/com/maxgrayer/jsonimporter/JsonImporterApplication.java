package com.maxgrayer.jsonimporter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxgrayer.jsonimporter.models.PersistedSong;
import com.maxgrayer.jsonimporter.models.RockBandScoreData;
import com.maxgrayer.jsonimporter.models.RockBandScoreResponse;
import com.maxgrayer.jsonimporter.models.RockBandSong;
import com.maxgrayer.jsonimporter.models.RockBandSongResponse;
import com.maxgrayer.jsonimporter.repositories.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class JsonImporterApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(JsonImporterApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(JsonImporterApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Value("classpath:data/song-list.json")
	Resource songListFile;
	@Value("classpath:data/song-scores.json")
	Resource songScoreFile;

	/* Parsed File holders */
	private RockBandSongResponse songResponse;
	private RockBandScoreResponse scoreResponse;

	@Autowired
	private SongRepository repository;

	private boolean shouldSave = false;

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		int newSongCount = 0;

		try {
			final Set<PersistedSong> persistedSongs = new HashSet<PersistedSong>();
			persistedSongs.addAll((Collection<? extends PersistedSong>) repository.findAll());

			final ObjectMapper objectMapper = new ObjectMapper()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			// Process "official" RB data
			songResponse = objectMapper.readValue(songListFile.getFile(), RockBandSongResponse.class);
			LOG.info("Rock Band Data songs count: " + songResponse.getData().getCount());

			scoreResponse = objectMapper.readValue(songScoreFile.getFile(), RockBandScoreResponse.class);
			LOG.info("Rock Band Data score count: " + scoreResponse.getData().getScores().size());

			for (final RockBandSong rockBandSong : songResponse.getData().getSongs()) {
				final Optional<String> optionalKey = scoreResponse.getData().getScores().keySet().stream()
						.filter(item -> item.equalsIgnoreCase(rockBandSong.shortname())).findFirst();

				RockBandScoreData scoreData = null;
				if (!optionalKey.isEmpty()) {
					final String shortnameKey = optionalKey.get();
					scoreData = scoreResponse.getData().getScores().get(shortnameKey);
				}
				final PersistedSong newSong = getPersistedSongFromRockBandSongData(rockBandSong, scoreData);

				if (!persistedSongs.contains(newSong)) {
					persistedSongs.add(newSong);
					newSongCount++;
				}
			}

			LOG.info("persistedSongs count: " + persistedSongs.size());
			LOG.info("newSongCount: " + newSongCount);

			if (shouldSave) {
				repository.saveAll(persistedSongs);
				LOG.info("SAVED ALL SONGS!");
			}
		} catch (final Exception ex) {
			LOG.error("Error during file reads", ex);
		}
	}

	private PersistedSong getPersistedSongFromRockBandSongData(final RockBandSong song, final RockBandScoreData score) {
		boolean isOwned = false;
		boolean onWishlist = false;
		if (score != null) {
			isOwned = score.isOwned();
			onWishlist = score.isWishList();
		}

		return new PersistedSong(song.title(), song.artist(), song.year(), song.album(), song.trackNum(), song.genre(),
				song.duration(), song.shortname(), song.sortRankBass(), song.sortRankGuitar(), song.sortRankVocal(),
				song.sortRankDrum(), song.sortAlbum(), song.sortArtist(), song.sortTitle(), song.awsArtworkLink(),
				song.releaseDate(), song.xboxStoreLink(), song.bpm(), song.sortRankBand(), song.displayRankDrums(),
				song.displayRankVocal(), song.displayRankGuitar(), song.displayRankBass(), song.displayRankBand(),
				isOwned, onWishlist);
	}
}
