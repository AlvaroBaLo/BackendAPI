package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entitys.Laptop;
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

}
