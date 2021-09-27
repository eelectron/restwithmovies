package com.example.demo.restApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Catalogue {
	private List<Movie> data;

	public List<Movie> getData() {
		return data;
	}

	public void setData(List<Movie> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Catalogue [data=" + data + "]";
	}
}
