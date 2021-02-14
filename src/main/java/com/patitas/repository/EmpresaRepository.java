package com.patitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patitas.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	List<Empresa> findByNombre(String nombre);
}
