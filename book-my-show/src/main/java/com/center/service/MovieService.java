package com.center.service;

import java.util.List;

import com.center.model.Movie;
import com.center.response.MovieResponse;

public interface MovieService {
	
	
	public Movie saveMovie(Movie movie);

	public MovieResponse getMovieById(int movieId);

	public List<MovieResponse> findByMovie(String name);

	public List<Movie> getAll();

	public List<MovieResponse> findByMovieGenreOrLanguage(String name);


}
