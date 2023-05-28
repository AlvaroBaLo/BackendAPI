package com.gestion.empleados.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//package com.gestion.empleados.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//	 @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        // ...
//	        http.cors(); 
//	        return http.build();
//	    }
//	  public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("http://localhost:8080/api/v1/users") // ajusta la URL que necesitas
//	            .allowedOrigins("*") // ajusta el origen permitido
//	            .allowedMethods("*") // ajusta los métodos HTTP permitidos
//	            .allowedHeaders("*"); // ajusta los encabezados permitidos
//	    }
//   
//}

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
}