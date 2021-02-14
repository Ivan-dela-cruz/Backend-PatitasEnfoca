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

import com.patitas.model.Empresa;
import com.patitas.repository.EmpresaRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;

	@GetMapping("/empresas")
	public ResponseEntity<List<Empresa>> getAllEmpresa(@RequestParam(required = false) String title) {
		try {
			List<Empresa> empresas = new ArrayList<Empresa>();
			empresaRepository.findAll().forEach(empresas::add);
			if (empresas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(empresas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/empresas/{id}")
	public ResponseEntity<Empresa> getTutorialById(@PathVariable("id") long id) {
		Optional<Empresa> empresaData = empresaRepository.findById(id);
		if (empresaData.isPresent()) {
			return new ResponseEntity<>(empresaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/empresa")
	public ResponseEntity<Empresa> createTutorial(@RequestBody Empresa empresa) {
		try {
			Empresa _empresa = empresaRepository.save(new Empresa(empresa.getRuc(), empresa.getNombre(),
					empresa.getComercial(), empresa.getTelefono1(), empresa.getTelefono2(), empresa.getCallePrincipal(),
					empresa.getCalle_secundaria(), empresa.getNumero(), empresa.getCiudad(), empresa.getReferencia()));
			return new ResponseEntity<>(_empresa, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/empresas/{id}")
	public ResponseEntity<Empresa> updateTutorial(@PathVariable("id") long id, @RequestBody Empresa empresa) {
		Optional<Empresa> tutorialData = empresaRepository.findById(id);

		if (tutorialData.isPresent()) {
			Empresa _empresa = tutorialData.get();
			_empresa.setNombre(empresa.getNombre());
			_empresa.setRuc(empresa.getRuc());
			_empresa.setCalle_secundaria(empresa.getCalle_secundaria());
			_empresa.setCallePrincipal(empresa.getCallePrincipal());
			_empresa.setNumero(empresa.getNumero());
			_empresa.setCiudad(empresa.getCiudad());
			_empresa.setComercial(empresa.getComercial());
			_empresa.setTelefono1(empresa.getTelefono1());
			_empresa.setTelefono2(empresa.getTelefono2());
			_empresa.setReferencia(empresa.getReferencia());
			return new ResponseEntity<>(empresaRepository.save(_empresa), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/empresas/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			empresaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/empresas")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			empresaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
