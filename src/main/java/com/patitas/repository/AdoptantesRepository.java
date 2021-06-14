package com.patitas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patitas.model.Adoptantes;

public interface AdoptantesRepository extends JpaRepository<Adoptantes, Long> {
	List<Adoptantes> findByFechaAdopcion(Date fecha);
}
