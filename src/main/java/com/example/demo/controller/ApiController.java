package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Catalogue;
import com.example.demo.model.Movie;

@RestController
public class ApiController {
	@Autowired
	private RestTemplate restTemplate;
	private String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";
	
	@GetMapping("/movies")
	public List<Movie> getMovies(){
		Catalogue moviesCata = restTemplate.getForObject(url, Catalogue.class);
		return moviesCata.getData();
	}
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}