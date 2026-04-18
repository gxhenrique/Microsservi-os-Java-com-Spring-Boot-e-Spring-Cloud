package com.example.hrpayroll.entity;

import java.io.Serializable;
import java.util.Objects;


public class Worker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String name;
	private Double dailyIncome;
	
	
	public Worker() {
		
	}


	public Worker(Long id, String name, Double dalyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dalyIncome;
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


	public Double getDalyIncome() {
		return dailyIncome;
	}


	public void setDalyIncome(Double dalyIncome) {
		this.dailyIncome = dalyIncome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
