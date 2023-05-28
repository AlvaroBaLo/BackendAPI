package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Mensaje;
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
	List<Mensaje> findByOrderByFechaDesc();
}
