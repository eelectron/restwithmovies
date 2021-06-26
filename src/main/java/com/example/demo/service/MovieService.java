package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Catalogue;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService implements MovieServiceInf{
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	private String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";
	
	public List<Movie> getMoviesFromHackerrank() {
		// TODO Auto-generated method stub
		Catalogue moviesCata = restTemplate.getForObject(url, Catalogue.class);
		return moviesCata.getData();
	}

	@Override
	public Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.save(movie);
		return movie;
	}

	@Override
	public Movie getMovie(long id) {
		// TODO Auto-generated method stub
		System.out.println("id = " + id);
		Movie movie = new Movie("none", -1, "none");
		System.out.println(movie);
		try {
			movie = movieRepo.getById(id);
			return movie;
		}catch(Exception exp) {
			System.out.println("Movie not found id = " + id);
			return movie;
		}
	}

	@Override
	public Movie deleteMovie(long id) {
		// TODO Auto-generated method stub
		Movie movie = new Movie("none", -1, "none"); 
		try {
			movie = movieRepo.getById(id);
			movieRepo.delete(movie);
		}catch(Exception exp){
			System.out.print("Movie not found id = " + id);
		}
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.save(movie);
		return movie;
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}
}