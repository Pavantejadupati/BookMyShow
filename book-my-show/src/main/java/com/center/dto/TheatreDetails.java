package com.center.dto;

import java.time.LocalDateTime;

public interface TheatreDetails {
	
	String getTheatreName();
	LocalDateTime getShowDateTime();
	String getCity();
	String getScreenName();
}
