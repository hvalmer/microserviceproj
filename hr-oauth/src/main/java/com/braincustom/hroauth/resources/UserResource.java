package com.braincustom.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.hroauth.entities.User;
import com.braincustom.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//buscando usuário de email
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		//tratando uma exceção
		try {
			User user = service.findByEmail(email);
			return ResponseEntity.ok(user);
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
}
