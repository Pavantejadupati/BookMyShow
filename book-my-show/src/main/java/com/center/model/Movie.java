package com.center.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int movieId;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre genre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "language")
	private Language language;
	
	@Column(name = "overview")
	private String overview;
	
	@Column(name = "hero")
	private String hero;
	
	
	@Column(name = "heroine")
	private String heroine;
	
	@Column(name = "poster_path")
	private String posterPath;
	
	@Column( name = "release_date", columnDefinition = "DATE")
	private Date releaseDate;
	
	
}
