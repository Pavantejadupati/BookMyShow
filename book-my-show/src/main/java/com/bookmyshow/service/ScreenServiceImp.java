package com.bookmyshow.service;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.controller.ScreenController;
import com.bookmyshow.exception.ScreenNotFoundException;
import com.bookmyshow.model.Screen;
import com.bookmyshow.repo.ScreenRepo;
import com.bookmyshow.response.ScreenResponse;

import ch.qos.logback.classic.Logger;

@Service
public class ScreenServiceImp implements ScreenService {

	@Autowired
	ScreenRepo screenRepo;

	@Autowired
	ModelMapper modelMapper;
	
	Logger logger = (Logger) LoggerFactory.getLogger(ScreenController.class);


	@Override
	public ScreenResponse getScreen(String screenName, String theatreName){

		ScreenResponse screenResponse = new ScreenResponse();

		Screen screen = screenRepo.getScreenByScreenName(screenName, theatreName);

		if (screen == null) {
			throw new ScreenNotFoundException(screenName + " with " + theatreName + " theatre dosen't exist");
		}

		screenResponse = modelMapper.map(screen, ScreenResponse.class);
		
		logger.info("------  "+screenName +" is fetched with  "+ theatreName +" theatre -------");

		return screenResponse;

	}

}
