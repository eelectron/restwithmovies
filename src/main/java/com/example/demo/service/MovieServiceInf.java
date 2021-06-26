package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Movie;

public interface MovieServiceInf{
	public List<Movie> getMovies();
	public Movie createMovie(Movie movie);
	public Movie getMovie(long id);
	public Movie deleteMovie(long id);
	public Movie updateMovie(Movie movie);
}