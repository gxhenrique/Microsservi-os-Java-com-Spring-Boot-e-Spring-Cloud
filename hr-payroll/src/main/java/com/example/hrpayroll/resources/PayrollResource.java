package com.example.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrpayroll.entity.Payment;
import com.example.hrpayroll.service.PayrollService;

@RestController
@RequestMapping(value = "/payment")
public class PayrollResource {
	
	@Autowired
	private PayrollService service;
	
	@GetMapping(value = "/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days){
		Payment payment = service.getPayment(id, days);
		
		return ResponseEntity.ok(payment);
	}
}
