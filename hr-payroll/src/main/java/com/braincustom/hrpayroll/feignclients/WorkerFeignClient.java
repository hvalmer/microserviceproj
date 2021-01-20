package com.braincustom.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.braincustom.hrpayroll.entities.Worker;

@Component //gerenciado pelo Spring...injetado em outras classes
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(value= "/{id}")
	ResponseEntity<Worker> finById(@PathVariable Long id);
}
