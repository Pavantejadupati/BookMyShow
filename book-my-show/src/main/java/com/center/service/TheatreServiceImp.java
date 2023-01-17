package com.center.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.dto.TheatreDetails;
import com.center.repo.TheatreRepo;
import com.center.response.TheatreResponse;

@Service
public class TheatreServiceImp implements TheatreService{

	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	

	
	  @Override public List<TheatreResponse> findTheatreByMovieId(int movieId) {
		  
		  List<TheatreDetails> theatreDetails =  theatreRepo.findTheatreByMovieId(movieId);
		  
		  List<TheatreResponse> theatreResponse =  theatreDetails
				  .stream()
				  .map(theatreDetail -> modelMapper.map(theatreDetail, TheatreResponse.class))
				  .collect(Collectors.toList());
		
		  
		  return theatreResponse;
	  
	  }

}
