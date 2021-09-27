package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

/*
 * This controller interact with movie database .
 * */
@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	 
	 @PostMapping("/movies")
	 public Movie createMovie(@RequestBody Movie movie) {
		 return movieService.createMovie(movie);
	 }
	 
	 @GetMapping("/movies/{id}")
	 public Optional<Movie> getMovie(@PathVariable Long id) {
		 return movieService.getMovie(id);
	 }
	 
	 @GetMapping("/movies")
	 public List<Movie> getMovies(){
		 return movieService.getMovies();
	 }
	 
	
	 
	 @PutMapping("/movies/{id}")
	 public Optional<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		 Optional<Movie> updatedMovie = movieService.updateMovie(id, movie);
		 return updatedMovie;
	 }
	 
	 
	 @DeleteMapping("/movies/{id}")
	 public Optional<Movie> deleteMovie(@PathVariable("id") Long id) {
		 Optional<Movie> movie = movieService.deleteMovie(id);
		 return movie;
	 }
	/*
	 * Say hello */
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
	
	/*
	 * Say hello to user*/
	@GetMapping("/hello/{name}")
	public String helloUser(@PathVariable("name") String name) {
		return "Hello " + name + "!!"; 
	}
}