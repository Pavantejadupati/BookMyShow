package com.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.response.ScreenResponse;
import com.bookmyshow.service.ScreenService;

@CrossOrigin(origins = "*")
@RestController
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@GetMapping("/screen/{screenName}/{theatreName}")
	public ScreenResponse getScreen(@PathVariable("screenName") String screenName,@PathVariable("theatreName") String theatreName){
		
		return screenService.getScreen(screenName,theatreName);
		
	}

}
