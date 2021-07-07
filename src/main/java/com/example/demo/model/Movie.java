package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private Long movieId;
	
	private String title;
	private Integer year;
	private String imdbID;
	
	public Movie() {
		super();
	}

	
	public Movie(Long movieId, String title, Integer year, String imdbID) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
	}


	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", imdbID=" + imdbID + "]";
	}
}