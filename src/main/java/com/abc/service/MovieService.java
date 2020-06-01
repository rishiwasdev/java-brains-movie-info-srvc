package com.abc.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.abc.dto.ClientResponse;
import com.abc.dto.MovieDto;

@Service
public interface MovieService {
	ClientResponse getAllMovies();

	ClientResponse getMovie(String movieId);

	ClientResponse getmovieAsClientResponse( String movieId);

	ClientResponse addMovie(MovieDto dto);

	ClientResponse addMovies(HashSet<MovieDto> movies);

}
