package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Mensaje;
import com.example.repository.MensajeRepository;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {
	private MensajeRepository mensajeRepository;

	public List<Mensaje> listarMensajes() {
		return mensajeRepository.findByOrderByFechaDesc();
	}

	
}
