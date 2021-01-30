package com.braincustom.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.braincustom.hroauth.entities.User;

@Component //componente gerenciado pelo Spring
@FeignClient(name = "hr-user", path= "/users")//nome do ms que ele vai se comunicar...hr-user
public interface UserFeignClient {

	//por email...busca no BD e retorna o objeto
			@GetMapping(value= "/search")
			ResponseEntity<User> finByEmail(@RequestParam String email);
}
