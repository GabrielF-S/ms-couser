package br.com.gabriel.hr_payroll.entities;

import java.io.Serializable;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Double dailyIncome;
	private int days;
	public Payment() {
		
	}
	public Payment(String name, Double dailyIncome, int days) {
		super();
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Double getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	public Double getTotal() {
		return days * dailyIncome;
		
	}
}
