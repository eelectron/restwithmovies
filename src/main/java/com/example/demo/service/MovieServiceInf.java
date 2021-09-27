package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Movie;

public interface MovieServiceInf{
	public List<Movie> getMovies();
	public List<Movie> getMovies(String movieName);
	public Movie createMovie(Movie movie);
	public Optional<Movie> getMovie(Long id);
	public Optional<Movie> deleteMovie(Long id);
	public Optional<Movie> updateMovie(Long id, Movie movie);
}