package com.center.service;

import java.util.List;

import com.center.response.TheatreResponse;

public interface TheatreService {

	
	public List<TheatreResponse> findTheatreByMovieId(int movieId);

}
