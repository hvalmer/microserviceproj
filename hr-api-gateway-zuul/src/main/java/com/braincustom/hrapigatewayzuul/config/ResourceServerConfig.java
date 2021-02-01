package com.braincustom.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer //Anotation que vai configurar para que o projeto seja um ResourceServer por meio da classe
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore tokenStore;
	
	//constantes
	//quais os caminhos que vão ser publicos - PUBLIC 
	//rota essa pra fazer a autenticação, tem que ser pública
	private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };
	
	//rota para autorização de operador - OPERATOR (**)qqr rota tá autorizado
	private static final String[] OPERATOR = { "/hr-worker/**" };
	
	//rota para o admin acessar - ADMIN 
	private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", 
			"/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };
	
	//o projeto consegue "ler" o token
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	//configura as autorizações
	@Override
	public void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}

	
}
