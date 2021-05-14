package com.maxgrayer.jsonimporter;

import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxgrayer.jsonimporter.models.Album;
import com.maxgrayer.jsonimporter.models.Artist;
import com.maxgrayer.jsonimporter.models.CsvSong;
import com.maxgrayer.jsonimporter.models.Genre;
import com.maxgrayer.jsonimporter.models.PersistedSong;
import com.maxgrayer.jsonimporter.models.RbdbSong;
import com.maxgrayer.jsonimporter.repositories.SongRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

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
	@Value("classpath:data/wiki-rock-band-dlc.csv")
	Resource csvSongsFile;

	/* Parsed File holders */
	private Album[] albums;
	private Artist[] artists;
	private Genre[] genres;
	private RbdbSong[] songs;

	@Autowired
	private SongRepository repository;

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		int newSongCount = 0;

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
			final Reader csvReader = Files.newBufferedReader(csvSongsFile.getFile().toPath());
			final List<CsvSong> csvSongs = readAll(csvReader);
			LOG.info("CSV songs count: " + csvSongs.size());

			for (final RbdbSong rbdbSong : songs) {
				final PersistedSong newSong = getPersistedSongFromRbdbSong(rbdbSong);
				if (!persistedSongs.contains(newSong)) {
					persistedSongs.add(newSong);
					newSongCount++;
				}
			}

			for (final CsvSong csvSong : csvSongs) {
				final PersistedSong newSong = getPersistedSongFromCsvSong(csvSong);
				if (!persistedSongs.contains(newSong)) {
					persistedSongs.add(newSong);
					newSongCount++;
				}
			}

			LOG.info("persistedSongs count: " + persistedSongs.size());
			LOG.info("newSongCount: " + newSongCount);

			if (newSongCount > 0) {
				repository.saveAll(persistedSongs);
				LOG.info("SAVED ALL SONGS!");
			}
		} catch (final Exception ex) {
			LOG.error("Error during file reads", ex);
		}
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

	private PersistedSong getPersistedSongFromCsvSong(final CsvSong csvSong) {
		final PersistedSong newSong = new PersistedSong(csvSong.getTitle(), csvSong.getArtist(), csvSong.getGenre(),
				Integer.parseInt(csvSong.getYear()), -1, -1, -1, -1, -1, false, false);
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

	private List<CsvSong> readAll(final Reader reader) throws Exception {
		final CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		final List<CsvSong> list = new ArrayList<>();
		final List<String[]> lines = csvReader.readAll();
		for (String[] parts : lines) {
			list.add(getCsvSongFromParts(parts));
		}
		reader.close();
		csvReader.close();
		return list;
	}

	private CsvSong getCsvSongFromParts(final String[] parts) {
		return new CsvSong(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
	}

}
