package com.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.center.response.ScreenResponse;
import com.center.service.ScreenService;

@RestController
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@GetMapping("/screen/{screenName}")
	public ScreenResponse getScreen(@PathVariable("screenName") String screenName) {
		
		
		
		return screenService.getScreen(screenName);
		
	}

}
