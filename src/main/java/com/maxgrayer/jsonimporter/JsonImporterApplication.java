package com.maxgrayer.jsonimporter;

import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxgrayer.jsonimporter.models.Album;
import com.maxgrayer.jsonimporter.models.Artist;
import com.maxgrayer.jsonimporter.models.CsvSong;
import com.maxgrayer.jsonimporter.models.Genre;
import com.maxgrayer.jsonimporter.models.Song;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		try {
			final ObjectMapper objectMapper = new ObjectMapper()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			final Album[] albums = objectMapper.readValue(albumsFile.getFile(), Album[].class);
			LOG.info("albums count: " + albums.length);
			final Artist[] artists = objectMapper.readValue(artistsFile.getFile(), Artist[].class);
			LOG.info("artists count: " + artists.length);
			final Genre[] genres = objectMapper.readValue(genresFile.getFile(), Genre[].class);
			LOG.info("genres count: " + genres.length);
			final Song[] songs = objectMapper.readValue(songsFile.getFile(), Song[].class);
			LOG.info("songs count: " + songs.length);
			final Reader csvReader = Files.newBufferedReader(csvSongsFile.getFile().toPath());
			final List<CsvSong> csvSongs = readAll(csvReader);
			LOG.info("CSV songs count: " + csvSongs.size());
		} catch (final Exception ex) {
			LOG.error("Error during file reads", ex);
		}
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
