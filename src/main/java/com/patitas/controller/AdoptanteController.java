package com.patitas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patitas.model.Adoptante;
import com.patitas.repository.AdoptanteRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AdoptanteController {
	@Autowired
	AdoptanteRepository adoptanteRepository;
	
	@GetMapping("/adoptantes")
	public ResponseEntity<List<Adoptante>> getAllAdoptante(@RequestParam(required = false) String title) {
		try {
			List<Adoptante> adoptantes = new ArrayList<Adoptante>();
			adoptanteRepository.findAll().forEach(adoptantes::add);
			if (adoptantes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adoptantes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/adoptantes/{id}")
	public ResponseEntity<Adoptante> getAdoptanteById(@PathVariable("id") long id) {
		Optional<Adoptante> adoptanteData = adoptanteRepository.findById(id);
		if (adoptanteData.isPresent()) {
			return new ResponseEntity<>(adoptanteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/adoptante")
	public ResponseEntity<Adoptante> createAdoptante(@RequestBody Adoptante adoptante) {
		try {
			Adoptante _adoptante = adoptanteRepository.save(new Adoptante(adoptante.getIdentificacion(), adoptante.getNombres(),
					adoptante.getApellidos(), adoptante.getTelefono1(), adoptante.getTelefono2(), adoptante.getCelular(), adoptante.getCorreo(), 
					adoptante.getCallePrincipal(),adoptante.getCalle_secundaria(), adoptante.getNumero(), adoptante.getCiudad(), adoptante.getReferencia()));
			return new ResponseEntity<>(_adoptante, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/adoptantes/{id}")
	public ResponseEntity<Adoptante> updateAdoptante(@PathVariable("id") long id, @RequestBody Adoptante adoptante) {
		Optional<Adoptante> adoptanteData = adoptanteRepository.findById(id);

		if (adoptanteData.isPresent()) {
			Adoptante _adoptante = adoptanteData.get();
			_adoptante.setNombres(adoptante.getNombres());
			_adoptante.setApellidos(adoptante.getApellidos());
			_adoptante.setIdentificacion(adoptante.getIdentificacion());
			_adoptante.setCalle_secundaria(adoptante.getCalle_secundaria());
			_adoptante.setCallePrincipal(adoptante.getCallePrincipal());
			_adoptante.setNumero(adoptante.getNumero());
			_adoptante.setCiudad(adoptante.getCiudad());
			_adoptante.setTelefono1(adoptante.getTelefono1());
			_adoptante.setTelefono2(adoptante.getTelefono2());
			
			_adoptante.setCelular(adoptante.getCelular());
			_adoptante.setCorreo(adoptante.getCorreo());
			
			_adoptante.setReferencia(adoptante.getReferencia());
			return new ResponseEntity<>(adoptanteRepository.save(_adoptante), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/adoptantes/{id}")
	public ResponseEntity<HttpStatus> deleteAdoptante(@PathVariable("id") long id) {
		try {
			adoptanteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	

}
