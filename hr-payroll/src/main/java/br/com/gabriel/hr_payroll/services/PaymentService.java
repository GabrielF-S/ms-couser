package br.com.gabriel.hr_payroll.services;

import org.springframework.stereotype.Service;

import br.com.gabriel.hr_payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long wokerId, int days) {

		return  new Payment("Bob", 200.0, days);
	}

}
