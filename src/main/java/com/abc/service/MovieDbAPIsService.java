package com.abc.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.abc.dto.ClientResponse;

@Service
public interface MovieDbAPIsService {
	// ----------------------------- Outer-world APIs -
	ClientResponse getMovieFromMovieDb(@Valid String movieId);
}
