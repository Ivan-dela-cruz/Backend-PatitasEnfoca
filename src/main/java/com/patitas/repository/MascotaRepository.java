package com.patitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patitas.model.Mascotas;

public interface MascotaRepository extends JpaRepository<Mascotas, Long> {
	List<Mascotas> findByNombre(String nombre);
}
