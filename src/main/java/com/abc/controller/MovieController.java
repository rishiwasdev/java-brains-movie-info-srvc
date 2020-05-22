package com.abc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.config.Constants;
import com.abc.dto.ClientResponse;
import com.abc.dto.MovieDto;
import com.abc.service.MovieService;
import com.abc.test.DummyData;

@RestController
@RequestMapping("/movie-info")
public class MovieController {
	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;

	@GetMapping("")
	private ResponseEntity<ClientResponse> getMovies() {
		return createResponse(movieService.getAllMovies()); // TODO - Check for exceptions
	}

	@GetMapping("/{movieId}")
	private Object getMovie(@Valid @PathVariable("movieId") String movieId) {
		log.debug("# Movie ID: {}", movieId);
		return createResponse(movieService.getMovie(movieId)); // TODO - Check for exceptions
//		return movieService.getMovie(movieId).getData();
	}

	@PostMapping("/")
	private ResponseEntity<ClientResponse> addMovie(@Valid @RequestBody MovieDto dto) {
		int totalSaved = getSavedMovies().size();
		if (totalSaved >= Constants.MAX_ITEMS_TO_SAVE) {
			log.error("Enough sample movies(" + totalSaved + ") stored.");
			return createResponse(null);
		}
		log.debug("# MovieDto: {}", dto);
		dto = DummyData.randomMovie();
		log.debug("# DummyMovieDto: {}", dto);
		return createResponse(movieService.addMovie(dto)); // TODO - Check for exceptions
	}

	@PostMapping("/add-dummy-movies")
	private ResponseEntity<ClientResponse> addDummyMovies() {
		List<MovieDto> savedMovies = getSavedMovies();
		return createResponse(movieService.addMovies(DummyData.addRandomItems(savedMovies)));
	}

	// HELPER METHODS
	private ResponseEntity<ClientResponse> createResponse(ClientResponse res) {
		return (res == null) ? new ResponseEntity<>(res, HttpStatus.CONFLICT) : new ResponseEntity<>(res, HttpStatus.OK);
	}

	private List<MovieDto> getSavedMovies() {
		ResponseEntity<ClientResponse> entity = getMovies();
		List<MovieDto> savedMovies = (List<MovieDto>) entity.getBody().getData();
		return savedMovies;
	}
}
