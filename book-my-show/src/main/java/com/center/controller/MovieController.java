package com.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.center.model.Movie;
import com.center.response.MovieResponse;
import com.center.service.MovieService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	
	@PostMapping("/save")
	public Movie createMovie(@RequestBody Movie movie) {
	
	 Movie savedMovie = movieService.saveMovie(movie);
		
		return savedMovie;
		
	}
	
	
	@GetMapping("/allMovies")
	public List<Movie> getAllMvoies() {
		
		return movieService.getAll();
	}
	
	
	@GetMapping("/movieId/{movieId}")
	public MovieResponse getMovieDetails(@PathVariable("movieId") int movieId) {
		
		return movieService.getMovieById(movieId);
	}
	
	
	@GetMapping("/searchMovie/{name}")
	public List<MovieResponse> findMovieBYName(@PathVariable("name") String name) {
		
		return movieService.findByMovie(name);
	}
	
	
	@GetMapping("/filterBy/{name}")
	public List<MovieResponse> findMovie(@PathVariable("name") String name) {
		
		return movieService.findByMovieGenreOrLanguage(name);
	}
	
}

