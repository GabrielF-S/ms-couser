package br.com.gabriel.hr_worker.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name = "daily_income")
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
