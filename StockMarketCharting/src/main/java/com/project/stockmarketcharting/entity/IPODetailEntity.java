package com.project.stockmarketcharting.entity;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
@Table(name = "Ipo_details")
public class IPODetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	private CompanyEntity company;
	private long openingPrice;
	private String openingDate;
	private String openingTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public long getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(long openingPrice) {
		this.openingPrice = openingPrice;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public IPODetailEntity(long id, CompanyEntity company, long openingPrice, String openingDate, String openingTime) {
		super();
		this.id = id;
		this.company = company;
		this.openingPrice = openingPrice;
		this.openingDate = openingDate;
		this.openingTime = openingTime;
	}

}
