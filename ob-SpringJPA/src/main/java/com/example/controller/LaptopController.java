package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entitys.Book;
import com.example.entitys.Laptop;
import com.example.repository.LaptopRepository;

@RestController
public class LaptopController {
	private LaptopRepository laptopRespository;

	public LaptopController(LaptopRepository laptopRespoitory) {
		super();
		this.laptopRespository = laptopRespoitory;
	}
	@GetMapping("/api/laptops")
	public List<Laptop> findAll(){
		return laptopRespository.findAll();
	}
	@PostMapping("/api/laptops")
	public Laptop create(@RequestBody Laptop laptop) {
		return laptopRespository.save(laptop);
		
		
	}

}
