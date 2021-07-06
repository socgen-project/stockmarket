package com.project.stockmarketcharting.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SectorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "sname")
	private String sectorName;

	@Column(length = 1000)
	private String description;

	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CompanyEntity> companies;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CompanyEntity> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyEntity> companies) {
		this.companies = companies;
	}

	public SectorEntity() {
		super();

	}

}
