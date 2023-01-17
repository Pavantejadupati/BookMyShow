package com.center.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "theatre_id")
	private int theatreId;
	
	@Column(name = "theatre_name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "th_id", referencedColumnName = "theatre_id")
	private List<Screen> screens;
	
	@OneToMany
	@JoinColumn(name = "th_id", referencedColumnName = "theatre_id")
	private List<Show> show;
}
