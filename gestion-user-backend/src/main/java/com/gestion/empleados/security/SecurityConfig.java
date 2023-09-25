package com.gestion.empleados.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	@Bean
	SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.ignoringRequestMatchers("http://localhost:8080/**","http://localhost:4200/","*"))
				.authorizeHttpRequests(auth->auth
						.requestMatchers("*").permitAll()
						.anyRequest().permitAll())
				
				.build();
						
	}
	
//	public WebMvcConfigurer corsConfigurer()
//	{
//	   String[] allowDomains = new String[2];
//	   allowDomains[0] = "http://localhost:4200";
//	   allowDomains[1] = "http://localhost:8080";
//
//	   System.out.println("CORS configuration....");
//	   return new WebMvcConfigurer() {
//	      @Override
//	      public void addCorsMappings(CorsRegistry registry) {
//	         registry.addMapping("/**").allowedOrigins(allowDomains).allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");;
//	      }
//	   };
//	}
	
}
