package com.braincustom.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braincustom.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//busca por email
	User findByEmail(String email);
}
