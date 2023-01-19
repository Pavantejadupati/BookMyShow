package com.bookmyshow.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookmyshow.controller.MovieController;
import com.bookmyshow.exception.MovieNotFoundException;
import com.bookmyshow.model.Movie;
import com.bookmyshow.repo.MovieRepo;
import com.bookmyshow.response.MovieResponse;

import ch.qos.logback.classic.Logger;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepo moviesRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	

	Logger logger = (Logger) LoggerFactory.getLogger(MovieController.class);

	@Override
	public Movie saveMovie(Movie movie) {
		
		Movie savedMovie = moviesRepository.save(movie);
		
		return savedMovie;
	}
	
	
	@Override
	public MovieResponse getMovieById(int movieId) {
	
	   Movie movie = moviesRepository.findById(movieId).get();
	   
	   MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);
		
		return movieResponse;
	}


	@Override
	public List<MovieResponse> findMovie(String name){
		

		   List<Movie> movies = moviesRepository.findMovie(name);
		   
		   
		   if(movies.size()==0) {
			   throw new MovieNotFoundException("Movie with "+ name +" dosen't exist");
		   }
		   
		   List<MovieResponse>   movieResponse =  movies
					  .stream()
					  .map(movie -> modelMapper.map(movie, MovieResponse.class))
					  .collect(Collectors.toList());
			   
		   logger.info("------  movie is fetched with  "+ name +" -------");
			   
		   return movieResponse;
		  
	}


	@Override
	public List<MovieResponse> getAll(){
		
		List<Movie> movies = moviesRepository.findAll();
		  
		  if(movies.size()==0) {
			   throw new MovieNotFoundException("Movies dosen't exist");
		   }
		  
		   
		  List<MovieResponse> movieResponse = movies
				  .stream()
				  .map(movie -> modelMapper.map(movie, MovieResponse.class))
				  .collect(Collectors.toList());
			
			return movieResponse;
	
	}


	@Override
	public List<MovieResponse> findMovieByMovieGenreOrLanguage(String name){
		

		  List<Movie> movies = moviesRepository.findMovieByMovieGenreOrLanguage(name);
		  
		  if(movies.size()==0) {
			   throw new MovieNotFoundException("Movie with "+ name +" dosen't exist");
		   }
		  
		   
		  List<MovieResponse> movieResponse = movies
				  .stream()
				  .map(movie -> modelMapper.map(movie, MovieResponse.class))
				  .collect(Collectors.toList());
		  
		  logger.info("------  movie is fetched with  "+ name +" -------");

			return movieResponse;
	
	}
	

}
