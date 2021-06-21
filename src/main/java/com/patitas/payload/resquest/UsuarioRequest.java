package com.patitas.payload.resquest;

public class UsuarioRequest {

   
	private String id;
	
	private String nombre;
	
	private String username;
	
	private String apellido;

	private String identificacion;
	
	private String email;
	
	private String genero;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "UsuarioRequest [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", identificacion="
				+ identificacion + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getIdentificacion()=" + getIdentificacion() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
