package com.center.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.center.model.Movie;
import com.center.repo.MovieRepo;
import com.center.response.MovieResponse;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepo moviesRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	

	@Override
	public Movie saveMovie(Movie movie) {
		
		Movie savedMovie = moviesRepository.save(movie);
		
		return savedMovie;
	}
	
	
	@Override
	public MovieResponse getMovieById(int movieId) {
	
		
		//MovieResponse movieResponse = new MovieResponse();
		
	   Movie movie = moviesRepository.findById(movieId).get();
	   
	   
	   
//	   movieResponse.setMovieId(movie.getMovieId());
//	   movieResponse.setMovieName(movie.getMovieName());
//	   movieResponse.setGenre(movie.getGenre());
//	   movieResponse.setLanguage(movie.getLanguage());
//	   movieResponse.setOverview(movie.getOverview());
//	   movieResponse.setHero(movie.getHero());
//	   movieResponse.setHeroine(movie.getHeroine());
//	   movieResponse.setPosterPath(movie.getPosterPath());
//	   movieResponse.setReleaseDate(movie.getReleaseDate());
	   
	   MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);
		
		return movieResponse;
	}


	@Override
	public List<MovieResponse> findByMovie(String name) {
		

		   List<Movie> movies = moviesRepository.findByMovieName(name);
		   
		   List<MovieResponse> movieResponse =  movies
					  .stream()
					  .map(movie -> modelMapper.map(movie, MovieResponse.class))
					  .collect(Collectors.toList());
			
			return movieResponse;
	}


	@Override
	public List<Movie> getAll() {
		
		return moviesRepository.findAll();
	}


	@Override
	public List<MovieResponse> findByMovieGenreOrLanguage(String name) {
		

		  List<Movie> movies = moviesRepository.findByMovieGenreOrLanguage(name);
		   
		  List<MovieResponse> movieResponse = movies
				  .stream()
				  .map(movie -> modelMapper.map(movie, MovieResponse.class))
				  .collect(Collectors.toList());
			
			return movieResponse;
	
	}
	

}
