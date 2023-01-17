package com.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.center.response.TheatreResponse;
import com.center.service.TheatreService;

@CrossOrigin(origins = "*")
@RestController
public class TheatreController {
	
	
	@Autowired
	TheatreService theatreService;
	
	
	  @GetMapping("theatre/{movieId}") 
	  public List<TheatreResponse> getTheatreByMovieId(@PathVariable("movieId") int movieId) {
	  
	  return theatreService.findTheatreByMovieId(movieId);
	  
	  }
	  
	 
}
