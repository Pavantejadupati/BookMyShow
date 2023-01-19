package com.bookmyshow.service;

import java.util.List;

import com.bookmyshow.response.TheatreResponse;

public interface TheatreService {

	
	public List<TheatreResponse> findTheatreByMovieId(int movieId);

}
