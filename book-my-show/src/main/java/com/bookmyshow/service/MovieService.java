package com.bookmyshow.service;

import java.util.List;

import com.bookmyshow.model.Movie;
import com.bookmyshow.response.MovieResponse;

public interface MovieService {
	
	
	public Movie saveMovie(Movie movie);

	public MovieResponse getMovieById(int movieId);

	public List<MovieResponse> findMovie(String name);

	public List<MovieResponse> getAll();

	public List<MovieResponse> findMovieByMovieGenreOrLanguage(String name);


}
