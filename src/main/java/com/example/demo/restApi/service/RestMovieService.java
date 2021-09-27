package com.example.demo.restApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.restApi.model.Catalogue;
import com.example.demo.restApi.model.Movie;

@Service
public class RestMovieService implements MovieServiceInf{
	@Autowired
	private RestTemplate restTemplate;
	private String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
	
	public List<Movie> getMovies(String movieName){
		Catalogue moviesCata = restTemplate.getForObject(url + movieName, Catalogue.class);
		return moviesCata.getData();
	}
}