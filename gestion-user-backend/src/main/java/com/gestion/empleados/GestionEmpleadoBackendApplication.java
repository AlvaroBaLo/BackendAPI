package com.gestion.empleados;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.gestion.empleados.modelo.Post;
import com.gestion.empleados.repositorio.PostRespository;
@ComponentScan
@SpringBootApplication
public class GestionEmpleadoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEmpleadoBackendApplication.class, args);	
	}
	

//	@Bean
//	CommandLineRunner commandLineRuner(PostRespository posts) {
//		return args->{
//			posts.save(new Post("Hola Mundo","Hola Mundo","Admin","Admin"));
//		};
//	}
//	
}
