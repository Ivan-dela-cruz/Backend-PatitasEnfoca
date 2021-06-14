package com.patitas.payload.resquest;

import java.util.Date;

public class MascotaRequest {

   
	private long id;
	private String nombre;
	private String fechaNacimiento;
	private Integer edadPerro;
	private Integer anosPerros;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Integer getEdadPerro() {
		return edadPerro;
	}
	public void setEdadPerro(Integer edadPerro) {
		this.edadPerro = edadPerro;
	}
	public Integer getAnosPerros() {
		return anosPerros;
	}
	public void setAnosPerros(Integer anosPerros) {
		this.anosPerros = anosPerros;
	}
	
	
	
}
