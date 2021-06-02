package com.maxgrayer.jsonimporter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxgrayer.jsonimporter.models.Album;
import com.maxgrayer.jsonimporter.models.Artist;
import com.maxgrayer.jsonimporter.models.Genre;
import com.maxgrayer.jsonimporter.models.PersistedSong;
import com.maxgrayer.jsonimporter.models.RbdbSong;
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

	@Value("classpath:data/albums.json")
	Resource albumsFile;
	@Value("classpath:data/artists.json")
	Resource artistsFile;
	@Value("classpath:data/genres.json")
	Resource genresFile;
	@Value("classpath:data/songs.json")
	Resource songsFile;
	@Value("classpath:data/song-list.json")
	Resource songListFile;
	@Value("classpath:data/song-scores.json")
	Resource songScoreFile;

	/* Parsed File holders */
	private Album[] albums;
	private Artist[] artists;
	private Genre[] genres;
	private RbdbSong[] songs;
	private RockBandSongResponse songResponse;
	private RockBandScoreResponse scoreResponse;

	@Autowired
	private SongRepository repository;

	private boolean shouldSave = false;

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		try {
			final Set<PersistedSong> persistedSongs = new HashSet<PersistedSong>();
			persistedSongs.addAll((Collection<? extends PersistedSong>) repository.findAll());

			final ObjectMapper objectMapper = new ObjectMapper()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			albums = objectMapper.readValue(albumsFile.getFile(), Album[].class);
			LOG.info("albums count: " + albums.length);
			artists = objectMapper.readValue(artistsFile.getFile(), Artist[].class);
			LOG.info("artists count: " + artists.length);
			genres = objectMapper.readValue(genresFile.getFile(), Genre[].class);
			LOG.info("genres count: " + genres.length);
			songs = objectMapper.readValue(songsFile.getFile(), RbdbSong[].class);
			LOG.info("songs count: " + songs.length);

			songResponse = objectMapper.readValue(songListFile.getFile(), RockBandSongResponse.class);
			LOG.info("Rock Band Data songs count: " + songResponse.getData().getCount());

			scoreResponse = objectMapper.readValue(songScoreFile.getFile(), RockBandScoreResponse.class);
			LOG.info("Rock Band Data score count: " + scoreResponse.getData().getScores().size());

			for (final RbdbSong rbdbSong : songs) {
				final PersistedSong newSong = getPersistedSongFromRbdbSong(rbdbSong);
				final Optional<RockBandSong> song = Arrays.stream(songResponse.getData().getSongs())
						.filter(item -> item.isSameSongAs(newSong)).findFirst();

				if (song.isEmpty() && !persistedSongs.contains(newSong)) {
					persistedSongs.add(newSong);
				}
			}

			for (final RockBandSong rockBandSong : songResponse.getData().getSongs()) {
				final Optional<String> optionalKey = scoreResponse.getData().getScores().keySet().stream()
						.filter(item -> item.equalsIgnoreCase(rockBandSong.shortname())).findFirst();

				if (!optionalKey.isEmpty()) {
					final String shortnameKey = optionalKey.get();
					final RockBandScoreData scoreData = scoreResponse.getData().getScores().get(shortnameKey);
					final PersistedSong newSong = getPersistedSongFromRockBandSongData(rockBandSong, scoreData);

					if (!persistedSongs.contains(newSong)) {
						persistedSongs.add(newSong);
					}
				}
			}

			LOG.info("persistedSongs count: " + persistedSongs.size());

			if (shouldSave) {
				repository.saveAll(persistedSongs);
				LOG.info("SAVED ALL SONGS!");
			}
		} catch (final Exception ex) {
			LOG.error("Error during file reads", ex);
		}
	}

	private PersistedSong getPersistedSongFromRockBandSongData(final RockBandSong song, final RockBandScoreData score) {
		return new PersistedSong(song.title(), song.artist(), song.genre(), song.year(), (int) song.duration(),
				song.displayRankGuitar(), song.displayRankDrums(), song.displayRankVocal(), song.displayRankBass(),
				score.isOwned(), score.isWishList());
	}

	private PersistedSong getPersistedSongFromRbdbSong(final RbdbSong song) {
		final String title = song.getArticle().concat(song.getName());
		final String artist = getArtistFromId(song.getArtist());
		final String genre = getGenreFromId(song.getGenre());
		final PersistedSong newSong = new PersistedSong(title, artist, genre, song.getYear(), (int) song.getDuration(),
				song.getTiers().getGuitar(), song.getTiers().getDrums(), song.getTiers().getVocals(),
				song.getTiers().getBass(), false, false);
		return newSong;
	}

	private String getArtistFromId(final int id) {
		return Arrays.stream(artists).filter(item -> item.getId() == id).findFirst().map((item) -> {
			return item.getArticle().concat(item.getName());
		}).orElseGet(() -> {
			return "";
		});
	}

	private String getGenreFromId(final int id) {
		return Arrays.stream(genres).filter(item -> item.id() == id).findFirst().map((item) -> {
			return item.name();
		}).orElseGet(() -> {
			return "";
		});
	}
}
