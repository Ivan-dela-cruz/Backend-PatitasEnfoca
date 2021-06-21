package com.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patitas.repository.AdopcionRepository;
import com.patitas.repository.MascotaRepository;
import com.patitas.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/indicador")
public class IndicadoresController {
	
	@Autowired
	MascotaRepository mascotaRepository;
	
	@Autowired
	AdopcionRepository adopcionRepository;
	
	@Autowired
	AuthController authController; 
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/usuariosCantidad")
	public Long usuariosCantidad() {
		return userRepository.count();
	}
	
	@GetMapping("/mascotasCantidad")
	public Long mascotasCantidad() {
		return mascotaRepository.count();
	}
	
	@GetMapping("/adopcionesCantidad")
	public Long adopcionesCantidad() {
		return adopcionRepository.count();
	}
	
}
