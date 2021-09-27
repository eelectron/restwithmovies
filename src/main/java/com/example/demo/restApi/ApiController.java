package com.example.demo.restApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restApi.model.Movie;
import com.example.demo.restApi.service.RestMovieService;

/*
 * This controller interact with external rest api on Hackerrank
 * */
@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private RestMovieService movieService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
	
	@GetMapping("/movies/{movieName}")
	public List<Movie> getMovies(@PathVariable("movieName") String movieName){
		return this.movieService.getMovies(movieName);
	}
	
	@GetMapping("/movies/sort/{movieName}")
	public List<Movie> getMoviesInOrder(@PathVariable("movieName") String movieName, @RequestParam("sortOrder") String sortOrder ){
		List<Movie> movies = new ArrayList<>(this.movieService.getMovies(movieName));
		if(sortOrder.equals("ascending")) {
			Collections.sort(movies, (m1, m2) -> m1.getYear() - m2.getYear());
			return movies;
		}
		else {
			Collections.sort(movies, (m1, m2) -> m2.getYear() - m1.getYear());
			return movies;
		}
	}
	
}