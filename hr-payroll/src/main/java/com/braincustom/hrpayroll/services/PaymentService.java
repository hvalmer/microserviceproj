package com.braincustom.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.braincustom.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Valmer", 200.0, days);
	}
	
}
