package com.abc.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.abc.dto.ClientResponse;
import com.abc.dto.MovieInfoDto;

@Service
public interface MovieService {
	ClientResponse getAllMovies();

	ClientResponse getMovie(String movieId);

	ClientResponse getmovieAsClientResponse(String movieId);

	ClientResponse addMovie(MovieInfoDto dto);

	ClientResponse addMovies(HashSet<MovieInfoDto> movies);

}
