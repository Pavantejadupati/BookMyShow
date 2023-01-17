package com.center.response;

import java.util.Date;

import com.center.model.Genre;
import com.center.model.Language;

import lombok.Data;

@Data
public class MovieResponse {
	
	private int movieId;
	
	private String movieName;
	
	private Genre genre;
	
	private Language language;
	
	private String overview;
	
	private String hero;
	
	private String heroine;
	
	private String posterPath;
	
	private Date releaseDate;
	
	
}
