package com.example.demo.restApi.service;

import java.util.List;

import com.example.demo.restApi.model.Movie;

public interface MovieServiceInf {
	public List<Movie> getMovies(String movieName);
}