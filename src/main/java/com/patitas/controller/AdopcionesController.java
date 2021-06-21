package com.patitas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patitas.model.Adopcion;
import com.patitas.model.EGenero;
import com.patitas.model.Mascotas;
import com.patitas.model.User;
import com.patitas.payload.resquest.AdoptantesRequest;
import com.patitas.payload.resquest.SignupRequest;
import com.patitas.repository.AdopcionRepository;
import com.patitas.repository.MascotaRepository;
import com.patitas.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/adopcion")
public class AdopcionesController {
	
	@Autowired
	MascotaRepository mascotaRepository;
	
	@Autowired
	AdopcionRepository adopcionRepository;
	
	@Autowired
	AuthController authController; 
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/registrarAdoccion")
	public String guardarRegistroAdopcion(@RequestBody AdoptantesRequest adoptante	) throws ParseException {	
	  System.out.println("Llega aqui"+adoptante.getFechaAdopcion());
	  System.out.println("Llega aqui"+adoptante.getUsuario().toString());
	  Adopcion adopcion= new Adopcion();	
	  try {
	  adopcion.setFechaAdopcion(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) adoptante.getFechaAdopcion()));
	  } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw  e;
	  }
	  User user=new User();
	  if(adoptante.getUsuario().getId().isEmpty()){
		  SignupRequest registrodeUsuario= new SignupRequest();
		  registrodeUsuario.setEmail(adoptante.getUsuario().getEmail());
		  registrodeUsuario.setPassword(adoptante.getUsuario().getIdentificacion());
		  Set<String> rolesPorDefault= new HashSet<>();
		  rolesPorDefault.add("user");
		  registrodeUsuario.setRole(rolesPorDefault);
		  registrodeUsuario.setUsername(adoptante.getUsuario().getUsername());
		  user= authController.registerUser2(registrodeUsuario);
		  user.setNombres(adoptante.getUsuario().getNombre());
		  user.setApellidos(adoptante.getUsuario().getApellido());
		  user.setGenero(EGenero.valueOf(adoptante.getUsuario().getGenero()));
		  user.setIdentificacion(adoptante.getUsuario().getIdentificacion());
		  userRepository.save(user);
	  }else{
		  Optional<User> optional= userRepository.findById(Long.parseLong(adoptante.getUsuario().getId()));
		  user= optional.get();
	  }
	  adopcion.setUsuario(user);  
	  adopcionRepository.save(adopcion);
	  List<Mascotas> listaMascota= new ArrayList<>();
	  adoptante.getListaMascotas().forEach(mascota->{
	  Mascotas nuevaMascota= new Mascotas();
	     nuevaMascota.setAdoptante(adopcion);
	     nuevaMascota.setNombre(mascota.getNombre());
	     nuevaMascota.setEdadPerro(mascota.getEdadPerro());
	     mascotaRepository.save(nuevaMascota);
	  });
	  return "guardado correctamente";
	}
	
	@GetMapping("/registrarMascota")
	public String guardarRegistroMascota() {
		
		return "Public Content.";
	}
}
