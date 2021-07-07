package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<Movie> getMovie(Long id) {
		// TODO Auto-generated method stub
		Optional<Movie> movie = movieRepo.findById(id);
		return movie;
	}

	@Override
	public Optional<Movie> deleteMovie(Long id) {
		// TODO Auto-generated method stub
		Optional<Movie> movie = movieRepo.findById(id);
		movieRepo.delete(movie.get());
		return movie;
	}

	@Override
	public Optional<Movie> updateMovie(Long id, Movie newMovie) {
		// TODO Auto-generated method stub
		Optional<Movie> movie = movieRepo.findById(id);
		movie.get().setImdbID(newMovie.getImdbID());
		movie.get().setMovieId(newMovie.getMovieId());
		movie.get().setTitle(newMovie.getTitle());
		movie.get().setYear(newMovie.getYear());
		movieRepo.save(movie.get());
		return movie;
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}
}