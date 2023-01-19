package com.bookmyshow.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookmyshow.exception.MovieNotFoundException;
import com.bookmyshow.exception.ScreenNotFoundException;
import com.bookmyshow.exception.TheatreNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<String> handleMovieNotFound(MovieNotFoundException ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TheatreNotFoundException.class)
	public ResponseEntity<String> handleTheatreNotFound(TheatreNotFoundException ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	
	
	@ExceptionHandler(ScreenNotFoundException.class)
	public ResponseEntity<String> handleScreenNotFound(ScreenNotFoundException ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
