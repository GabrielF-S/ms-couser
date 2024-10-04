package br.com.gabriel.hr_payroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.gabriel.hr_payroll.entities.Payment;
import br.com.gabriel.hr_payroll.services.PaymentService;


@RestController
@RequestMapping("/payments")
public class PaymentResource {
	@Autowired
	PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymnetAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayments(@PathVariable Long workerId, @PathVariable int days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
		
	}
	
	
	public ResponseEntity<Payment> getPaymnetAlternative( Long workerId,  int days){
		Payment payment =  new Payment("John", 200.0, days);
		return ResponseEntity.ok(payment);
		
	}

}
