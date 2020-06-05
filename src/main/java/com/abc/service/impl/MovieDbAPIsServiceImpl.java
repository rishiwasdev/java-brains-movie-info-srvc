package com.abc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.config.ObjectMapperConfig;
import com.abc.dto.ClientResponse;
import com.abc.dto.moviedb.MovieDto;
import com.abc.service.MovieDbAPIsService;

@Service
public class MovieDbAPIsServiceImpl implements MovieDbAPIsService {
	private static final Logger log = LoggerFactory.getLogger(MovieDbAPIsServiceImpl.class);
	@Autowired
	private ObjectMapperConfig mapper;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${themoviedb.url}")
	private String theMovieDbUrl;
	@Value("${themoviedb.api.key}")
	private String apiKey;

	@Override
	public ClientResponse getMovieFromMovieDb(String movieId) {
		log.debug("# Movie Id: {}", movieId);
		String uri = theMovieDbUrl + movieId + "?api_key=" + apiKey;
		log.info("# TheMovieDbURI: {}", uri);
		MovieDto movie = restTemplate.getForObject(uri, MovieDto.class);
		// .orElseThrow(() -> new IllegalArgumentException("No movie found for Movie Id: " + movieId));
		log.info("# MovieDto: {}", mapper.toJson(movie));
		return createClientResponse(movie);
	}

	private ClientResponse createClientResponse(Object obj) {
		ClientResponse res = new ClientResponse();
		res.setData(obj);
		return res;
	}
}
