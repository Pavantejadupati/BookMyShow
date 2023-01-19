package com.bookmyshow.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TheatreResponse {
	
	private String theatreName;
	private LocalDateTime showDateTime;
	private String city;
	private String screenName;

}
