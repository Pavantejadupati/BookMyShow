package com.bookmyshow.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.exception.MovieNotFoundException;
import com.bookmyshow.model.Movie;
import com.bookmyshow.response.MovieResponse;
import com.bookmyshow.service.MovieService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	Logger logger = (Logger) LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping("/save")
	public Movie createMovie(@RequestBody Movie movie) {
	
	 Movie savedMovie = movieService.saveMovie(movie);
	 
	 logger.info("------  movie is saved  -------");
		
		return savedMovie;
		
	}
	
	
	@GetMapping("/allMovies")
	public List<MovieResponse> getAllMovies(){
		logger.info("------ All movies fetched -------");
		return movieService.getAll();
	}
	
	
	@GetMapping("/movieId/{movieId}")
	public MovieResponse getMovieDetails(@PathVariable("movieId") int movieId){
		
		MovieResponse movieResponse = null;
		
		try {
			movieResponse = movieService.getMovieById(movieId);
			logger.info("------  movie is fetched with movie id "+ movieId+" -------");
		}
		catch(Exception e){
			throw new MovieNotFoundException("Movie with id " + movieId + " dosen't exist");
		}
		
		return movieResponse;
	}
	
	
	@GetMapping("/searchMovie/{name}")
	public List<MovieResponse> findMovieByName(@PathVariable("name") String name){
		
		return movieService.findMovie(name);
		
	}
	
	
	@GetMapping("/filterBy/{name}")
	public List<MovieResponse> findMovie(@PathVariable("name") String name){
		
		return movieService.findMovieByMovieGenreOrLanguage(name);
	}
	
}

