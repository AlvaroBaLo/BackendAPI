package com.gestion.users.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.users.model.Rol;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable>{

}
