package com.abc.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.config.ObjectMapperConfig;
import com.abc.dto.ClientResponse;
import com.abc.dto.MovieInfoDto;
import com.abc.entity.Movie;
import com.abc.repo.MovieRepo;
import com.abc.service.MovieService;
import com.abc.util.Util;

@Service
public class MovieServiceImpl implements MovieService {
	private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private ObjectMapperConfig mapper;
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public ClientResponse getAllMovies() {
		List<Movie> movies = movieRepo.findAll();
		List<MovieInfoDto> savedMovies = mapper.createList(mapper.toJson(movies), MovieInfoDto.class);
		return createClientResponse(savedMovies);
	}

	@Override
	public ClientResponse getMovie(String movieId) {
		log.debug("# movieId: {}", movieId);
		Movie movie = movieRepo.findByMovieId(movieId).orElse(null);
		// .orElseThrow(() -> new IllegalArgumentException("No movie found for Movie Id: " + movieId));
		log.info("# Movie: {}", movie);
		MovieInfoDto dto = mapper.convert(movie, MovieInfoDto.class);
		log.info("# MovieDto: {}", dto);
		return createClientResponse(dto);
	}

	@Override
	public ClientResponse getmovieAsClientResponse(String movieId) {
		Movie movie = movieRepo.findByMovieId(movieId).orElse(null);
		log.info("# Movie: {}", movie);
		return createClientResponse(movie);
	}

	@Transactional
	@Override
	public ClientResponse addMovie(MovieInfoDto dto) {
		log.debug("# MovieDto: {}", dto);
		Movie movie = mapper.convert(dto, Movie.class);
		log.info("# Movie: {}", movie);
		Movie savedMovie = movieRepo.save(movie);
		log.info("# savedMovie: {}", savedMovie);
		MovieInfoDto savedMovieDto = mapper.convert(savedMovie, MovieInfoDto.class);
		return createClientResponse(savedMovieDto);
	}

	@Transactional
	@Override
	public ClientResponse addMovies(HashSet<MovieInfoDto> movieDtos) {
		if (Util.nullOrEmpty(movieDtos)) {
			log.error("No movies provided to add.");
			return null;
		}
		log.debug("# Total movies to add = {}", movieDtos.size());
		Set<Movie> movies = mapper.createSet(mapper.toJson(movieDtos), Movie.class);
		List<Movie> savedMovies = movieRepo.saveAll(movies);
		log.debug("# Total movies added = {}", savedMovies.size());
		return createClientResponse(savedMovies.size());
	}

	private ClientResponse createClientResponse(Object obj) {
		ClientResponse res = new ClientResponse();
		res.setData(obj);
		return res;
	}
}
