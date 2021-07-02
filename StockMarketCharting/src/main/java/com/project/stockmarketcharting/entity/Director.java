package com.project.stockmarketcharting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "director_id")
	private int id;

	private String directorName;

	@OneToOne
	private CompanyEntity company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Director(int id, String directorName) {
		super();
		this.id = id;
		this.directorName = directorName;
	}

	public Director() {
		super();
	}

}
