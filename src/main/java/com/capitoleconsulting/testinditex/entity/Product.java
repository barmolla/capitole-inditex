package com.capitoleconsulting.testinditex.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id
	private Long id;

	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	private Brand brand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}
}
