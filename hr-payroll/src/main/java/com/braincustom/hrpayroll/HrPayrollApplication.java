package com.braincustom.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name= "hr-worker")
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}

/*Feign...primeiro componente do Spring Cloud
 *É uma forma alternativa de comunicar um 
 *projeto com o outro e ele já é integrado 
 *com as outras ferramentas do Spring Cloud
 */
 