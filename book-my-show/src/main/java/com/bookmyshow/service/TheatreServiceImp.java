package com.bookmyshow.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.dto.TheatreDetails;
import com.bookmyshow.exception.TheatreNotFoundException;
import com.bookmyshow.repo.TheatreRepo;
import com.bookmyshow.response.TheatreResponse;

@Service
public class TheatreServiceImp implements TheatreService{

	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	

	
	  @Override public List<TheatreResponse> findTheatreByMovieId(int movieId) {
		  
		  List<TheatreDetails> theatreDetails =  theatreRepo.findTheatreByMovieId(movieId);
		  
		  if(theatreDetails.size()==0) {
			   throw new TheatreNotFoundException("Theatres with movie id "+ movieId +" dosen't exist");
		   }
		  
		  List<TheatreResponse> theatreResponse =  theatreDetails
				  .stream()
				  .map(theatreDetail -> modelMapper.map(theatreDetail, TheatreResponse.class))
				  .collect(Collectors.toList());
		
		  
		  return theatreResponse;
	  
	  }

}
