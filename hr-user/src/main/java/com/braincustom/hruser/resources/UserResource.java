package com.braincustom.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.hruser.entities.User;
import com.braincustom.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

		@Autowired
		private UserRepository repository;
		
		//por id
		@GetMapping(value= "/{id}")
		public ResponseEntity<User> finById(@PathVariable Long id){
			User obj = repository.findById(id).get();
			return ResponseEntity.ok(obj);
	}
		
		//por email...busca no BD e retorna o objeto
		@GetMapping(value= "/search")
		public ResponseEntity<User> finByEmail(@RequestParam String email){
			User obj = repository.findByEmail(email);
			return ResponseEntity.ok(obj);
	}
}

