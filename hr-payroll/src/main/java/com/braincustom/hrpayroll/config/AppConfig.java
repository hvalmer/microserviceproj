package com.braincustom.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	//criando um componente a partir de uma chamada de método
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

/*
 * Foi implementado o padrão de projeto Singleton,
 * que é instância única, para se ter à disposição
 * um objeto RestTemplate e injetar em outros serviços
 * 
 * */
