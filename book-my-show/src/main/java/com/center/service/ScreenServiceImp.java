package com.center.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.dto.ScreenDetails;
import com.center.model.Screen;
import com.center.repo.ScreenRepo;
import com.center.response.MovieResponse;
import com.center.response.ScreenResponse;

@Service
public class ScreenServiceImp implements ScreenService{
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ScreenResponse getScreen(String screenName) {
		
		ScreenResponse screenResponse = new ScreenResponse();
		
	    ScreenDetails screen = screenRepo.getScreenByScreenName(screenName);
		
		
	   screenResponse =  modelMapper.map(screen, ScreenResponse.class);
		
		return screenResponse; 
	    
	}	

}
