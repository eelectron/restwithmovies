package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	/*@Id
	private long id;
	*/
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private Integer year;
	
	private String imdbID;
	
	public Movie() {
		super();
	}

	
	public Movie(String title, Integer year, String imdbID) {
		super();
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
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
		return "Movie [title=" + title + ", year=" + year + ", imdbID=" + imdbID + "]";
	}
}