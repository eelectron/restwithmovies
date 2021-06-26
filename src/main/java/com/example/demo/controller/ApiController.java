package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

import com.example.demo.model.Catalogue;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class ApiController {
	@Autowired
	private MovieService movieService;
	
	/*
	 * Get all movies
	 * */
	@GetMapping("/moviesFromHackerrank")
	public List<Movie> getMoviesFromHackerrank(){
		//Catalogue moviesCata = restTemplate.getForObject(url, Catalogue.class);
		return this.movieService.getMoviesFromHackerrank();
	}
	
	/*
	 * Get all movies sorted in ascending or descending order
	 * based on request parameter
	 */
	 @GetMapping("/movies/sort")
	 public List<Movie> getMoviesInOrder(@RequestParam("sortOrder")String sortOrder){
		 List<Movie> movies = new ArrayList<>(this.movieService.getMoviesFromHackerrank());
		 System.out.print(sortOrder);
		 if(sortOrder.equals("ascending")) {
			 System.out.print(movies	);
			 Collections.sort(movies, (m1, m2) -> m1.getYear() - m2.getYear());
			 return movies;
		 }
		 else {
			 Collections.sort(movies, (m1, m2) -> m2.getYear() - m1.getYear());
			 return movies;
		 }
	 }
	
	 
	 @PostMapping("/movies")
	 public Movie createMovie(@RequestBody Movie movie) {
		 return this.movieService.createMovie(movie);
	 }
	 
	 @GetMapping("/movies")
	 public List<Movie> getMovies(){
		 return movieService.getMovies();
	 }
	 
	 @GetMapping("/movies/{id}")
	 public Movie getMovie(@PathVariable String id) {
		 long idAsLong = Long.parseLong(id);
		 System.out.println(idAsLong);
		 return movieService.getMovie(idAsLong);
	 }
	 
	 @PutMapping("/movies")
	 public Movie updateMovie(Movie movie) {
		 return movieService.updateMovie(movie);
	 }
	 
	 
	 @DeleteMapping("/movies/{id}")
	 public Movie deleteMovie(@PathVariable("id") long id) {
		 Movie movie = movieService.deleteMovie(id);
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