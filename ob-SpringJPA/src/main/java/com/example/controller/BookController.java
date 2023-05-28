package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.entitys.Book;
import com.example.repository.BookRepository;

@RestController
public class BookController {

	private final Logger log = LoggerFactory.getLogger(BookController.class);

	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	// CRUD sobre la entidad Book

	// Buscar todos los libros
	@GetMapping("/api/books")
	public List<Book> findAll() {

		return bookRepository.findAll();
	}

	// buscar solo un libro en la base de datos por ID
	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> findOneById(@PathVariable Long id) {
		Optional<Book> bookOpt = bookRepository.findById(id);
		if (bookOpt.isPresent()) {
			return ResponseEntity.ok(bookOpt.get());
		} else
			return ResponseEntity.notFound().build();

//		return bookOpt.orElse(null);
	}

	// crear nuevo libro
	@PostMapping("/api/books")
	public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
		System.out.println(headers.get("User-Agent"));
		if (book.getId() != null) {
			log.warn("trying to create a book with id");
			return ResponseEntity.badRequest().build();
		}
		Book result = bookRepository.save(book);
		return ResponseEntity.ok(result);

	}

	// actualizar un libro existente
	 @PutMapping("/api/books")
	 public ResponseEntity<Book> update(@RequestBody Book book) {
		 if (book.getId()==null) {
			 log.warn("trying to update a non existent book");
			 return ResponseEntity.badRequest().build();
			 }
		 if(bookRepository.existsById(book.getId())) {
			 log.warn("trying to update a non existent book");
			 return ResponseEntity.notFound().build();
		 }
			Book result = bookRepository.save(book);
			return ResponseEntity.ok(result);
	 }
	// borrar un libro
	 @DeleteMapping("api/books/{id}")
	 public ResponseEntity<Book> delete(@PathVariable Long id){
		 if(bookRepository.existsById(id)) {
			 log.warn("trying to update a non existent book");
			 return ResponseEntity.notFound().build();
		 }
		 bookRepository.deleteById(id);
		 return ResponseEntity.noContent().build();		 
	 }
}
