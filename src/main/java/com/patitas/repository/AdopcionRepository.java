package com.patitas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patitas.model.Adopcion;

public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {
	List<Adopcion> findByFechaAdopcion(Date fecha);
}
