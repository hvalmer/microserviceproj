package com.braincustom.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.hrpayroll.entities.Payment;
import com.braincustom.hrpayroll.entities.Worker;
import com.braincustom.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
				
		/*
		 * preenchimento dinâmico do
		 * trabalhador, e fazendo a requisição dinâmica do outro projeto do worker 
		 * 
		 */ 
		Worker worker = workerFeignClient.finById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
