package com.demoapi.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "city")
@EntityListeners(AuditingEntityListener.class)
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name") //Dudo si esto lo necesito
	private String name;
	
	@Column(name = "countrycode")
	private String countrycode;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "population")
	private Long population;
	
	public Pais(Long id, String name, String countrycode, String district, Long population) {
		this.id=id;
		this.name=name;
		this.countrycode=countrycode;
		this.district=district;
		this.population=population;
			
	}
	
	public Pais() {
		
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", name=" + name + ", CountryCode=" + countrycode + ", District=" + district + "]";
	}
	
}
