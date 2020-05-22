package com.abc.test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abc.config.Constants;
import com.abc.dto.MovieDto;
import com.abc.util.ReadFile;
import com.abc.util.Util;
import com.abc.util.Util_Elementary;

public class DummyData {
	private static final Logger log = LoggerFactory.getLogger(DummyData.class);

	public static MovieDto randomMovie() {
		return randomMovie(randomMovieId());
	}

	public static MovieDto randomMovie(String movieId) {
		MovieDto dto = new MovieDto();
		dto.setMovieId(movieId);
		dto.setName(Util.randomName(Util_Elementary.randomNumInRange(1, 4)));
		dto.setDescription(Util.randomName(Util_Elementary.randomNumInRange(3, 10)));
		return dto;
	}

	public static String randomMovieId() {
		return Util_Elementary.randomNumInRange(1950, 2020) + "-" + Util_Elementary.randomNumInRange(1, 99);
	}

	public static HashSet<MovieDto> addRandomItems(List<MovieDto> savedMovies) {
		List<String> movieProps = ReadFile.getLinesAsList("Movies.properties");
		int totalSaved = savedMovies.size();

		int canBeAdded = Constants.MAX_ITEMS_TO_SAVE < 0 ? movieProps.size() : Constants.MAX_ITEMS_TO_SAVE - totalSaved;
		if (Constants.MAX_ITEMS_TO_SAVE > -1 && canBeAdded <= 0) {
			log.error("Enough sample movies({}) stored.", totalSaved);
			return null;
		}

		List<String> savedIds = savedMovies.stream().map(r -> r.getMovieId()).collect(Collectors.toList());
		movieProps.removeAll(savedIds); // OR duplicate
		// -----------------------------------
		HashSet<MovieDto> movies = new HashSet<>();
		while (movieProps.size() > 0 && canBeAdded-- > 0) {
			String movieId = movieProps.remove(Util_Elementary.randomNum(movieProps.size() - 1));
			if (Util.nullOrEmpty(movieId))
				movieId = DummyData.randomMovieId();
			if (!movies.add(DummyData.randomMovie(movieId))) // if not added
				++canBeAdded;
		}
		return movies;
	}
}