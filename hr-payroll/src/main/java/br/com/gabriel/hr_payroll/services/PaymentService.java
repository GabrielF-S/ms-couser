package br.com.gabriel.hr_payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.hr_payroll.entities.Payment;
import br.com.gabriel.hr_payroll.entities.Worker;
import br.com.gabriel.hr_payroll.feigclients.WorkerFeignClient;

@Service
public class PaymentService {
	@Autowired
	private WorkerFeignClient client;

	public Payment getPayment(Long wokerId, int days) {
		Worker worker = client.findById(wokerId).getBody();
		return new Payment(worker.getName(), worker.getDailyincome(), days);
	}

}
