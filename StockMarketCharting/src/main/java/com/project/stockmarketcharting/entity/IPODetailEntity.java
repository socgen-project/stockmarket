package com.project.stockmarketcharting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ipo_details")
public class IPODetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

}
