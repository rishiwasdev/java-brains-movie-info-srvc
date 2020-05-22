package com.abc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	Optional<Movie> findByMovieId(String userId);
}
