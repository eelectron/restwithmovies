package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Catalogue;
import com.example.demo.model.Movie;

@RestController
public class ApiController {
	@Autowired
	private RestTemplate restTemplate;
	private String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";
	
	/*
	 * Get all movies
	 * */
	@GetMapping("/movies")
	public List<Movie> getMovies(){
		Catalogue moviesCata = restTemplate.getForObject(url, Catalogue.class);
		return moviesCata.getData();
	}
	
	/*
	 * Get all movies sorted in ascending or descending order
	 * based on request parameter
	 */
	 @GetMapping("/movies/sort")
	 public List<Movie> getMoviesInOrder(@RequestParam("sortOrder")String sortOrder){
		 Catalogue moviesCata = restTemplate.getForObject(url, Catalogue.class);
		 List<Movie> movies = new ArrayList<>(moviesCata.getData());
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