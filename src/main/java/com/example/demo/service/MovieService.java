package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService implements MovieServiceInf{
	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.save(movie);
		return movie;
	}

	@Override
	public Movie getMovie(Long id) {
		// TODO Auto-generated method stub
		return movieRepo.getById(id);
	}

	@Override
	public Movie deleteMovie(Long id) {
		// TODO Auto-generated method stub
		Movie movie = movieRepo.getById(id);
		movieRepo.delete(movie);
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