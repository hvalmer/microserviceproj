package com.braincustom.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.hroauth.entities.User;
import com.braincustom.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	//injetando...
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.finByEmail(email).getBody(); //comunicar com o ms de usuários
		if(user == null) { //tratamento de erro caso não encontre o email
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found!");
		}
		logger.info("Email found: " + email);
		return user;
	}
}
