package com.patitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patitas.model.Adoptante;

public interface AdoptanteRepository extends JpaRepository<Adoptante, Long> {
	List<Adoptante> findByNombres(String nombres);

}
