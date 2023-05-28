package com.example;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entitys.Book;
import com.example.repository.BookRepository;
import com.example.repository.LaptopRepository;
import com.example.entitys.Laptop;

@SpringBootApplication
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.entitys")
@ComponentScan("com.example")
public class ObSpringJpaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ObSpringJpaApplication.class, args);
		ApplicationContext context = SpringApplication.run(ObSpringJpaApplication.class, args);
		BookRepository repository =context.getBean(BookRepository.class);
		LaptopRepository repository1=context.getBean(LaptopRepository.class);
		// CRUD
		// crear libro
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 12, 1), true);
		// almacenar un libro
		System.out.println("Num libros en base de datos: " + repository.findAll().size());
		Laptop laptop = new Laptop(null,"Toshiba","Ac234");
		Laptop laptop1 = new Laptop(null,"ASUS","As12345");
		repository.save(book1);
		repository.save(book2);
		repository1.save(laptop);
		repository1.save(laptop1);

		// recuperar todos los libros
		System.out.println("Num libros en base de datos: " + repository.findAll().size());

		// borrar un libro
		// repository.deleteById(1L);

		System.out.println("Num libros en base de datos: " + repository.findAll().size());
	}

}