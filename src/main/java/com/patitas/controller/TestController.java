package com.patitas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patitas.model.Adoptantes;
import com.patitas.payload.resquest.AdoptantesRequest;
import com.patitas.repository.AdoptantesRepository;
import com.patitas.repository.MascotaRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	MascotaRepository mascotaRepository;
	
	@Autowired
	AdoptantesRepository adoptantesRepository;
	
	@Autowired
	AuthController authController; 

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/registrarAdoccion")
	public String guardarRegistroAdopcion(@RequestBody AdoptantesRequest adoptante	) throws ParseException {	
		
	 // Adoptantes adoptante= new Adoptantes();
	  
	 
//	  try {
//		adoptante.setFechaAdopcion(new SimpleDateFormat("dd/MM/yyyy").parse((String) input.get("fechaAdopcion")));
//	  } catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		throw  e;
//	  }
	  System.out.println("Llega aqui"+adoptante.getFechaAdopcion());
	  System.out.println("Llega aqui"+adoptante.getUsuario().toString());
//	  Adoptantes adoptanteNuevo= new Adoptantes();	
//	  adoptanteNuevo.setFechaAdopcion(adoptante.getFechaAdopcion());
//	  adoptanteNuevo.setListaMascotas(adoptante.getListaMascotas());
//	  SignupRequest registrodeUsuario= new SignupRequest();
//	  registrodeUsuario.setEmail(adoptante.getUsuario().getEmail());
//	  registrodeUsuario.setPassword(adoptante.getUsuario().getPassword());
//	  Set<String> rolesPorDefault= new HashSet<>();
//	  rolesPorDefault.add("user");
//	  registrodeUsuario.setRole(rolesPorDefault);
//	  registrodeUsuario.setUsername(adoptante.getUsuario().getUsername());
//	  User user= authController.registerUser2(registrodeUsuario);
//	  adoptanteNuevo.setUsuario(user);
//	  adoptantesRepository.save(adoptanteNuevo);
//	  List<Mascotas> listaMascota= new ArrayList<>();
//	  listaMascota=adoptante.getListaMascotas();
//	  listaMascota.forEach(mascota->{
//		  mascota.setAdoptante(adoptanteNuevo);
//		  mascotaRepository.save(mascota);
//	  });
	  return "Public Content.";
	}
	

	@GetMapping("/registrarMascota")
	public String guardarRegistroMascota() {
		
		return "Public Content.";
	}
}
