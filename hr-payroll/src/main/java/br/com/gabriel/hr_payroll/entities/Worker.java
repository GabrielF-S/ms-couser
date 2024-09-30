package br.com.gabriel.hr_payroll.entities;

import java.io.Serializable;

public class Worker implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	private Double dailyincome;

	public Worker() {

	}

	public Worker(String name, Double dailyincome) {
		super();
		this.name = name;
		this.dailyincome = dailyincome;
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

	public Double getDailyincome() {
		return dailyincome;
	}

	public void setDailyincome(Double dailyincome) {
		this.dailyincome = dailyincome;
	}

}
