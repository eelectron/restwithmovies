package com.example.demo.restApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private Integer year;
	
	
	@JsonProperty("imdbID")
	private String imdbID;
	
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
