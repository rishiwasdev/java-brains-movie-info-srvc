package com.abc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.ClientResponse;
import com.abc.service.MovieDbAPIsService;

@RestController
@RequestMapping("/moviedb")
public class MovieController_01_FromAnotherService {
	private static final Logger log = LoggerFactory.getLogger(MovieController_01_FromAnotherService.class);
	@Autowired
	private MovieDbAPIsService movieService;

	@GetMapping("/info-from-another-service/{movieId}")
	private ClientResponse getInfoFromAnotherService(@Valid @PathVariable("movieId") String movieId) {
		return movieService.getMovieFromMovieDb(movieId);
	}
}
