package com.bookmyshow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "screen")
public class Screen {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "screen_id")
	private int screenId;
	
	@Column(name = "screen_name")
	private String screenName;
	
	@Column(name = "row_number")
	private int rowNumber;
	
	@Column(name = "column_number")
	private int columnNumber;
	
	@Column(name = "total_seats")
	private int totalSeats;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "scr_id",referencedColumnName = "screen_id")
	private List<Show> shows;
	
		
}
