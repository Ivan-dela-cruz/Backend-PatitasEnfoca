package com.patitas.payload.resquest;

public class MascotaRequest {

   
	private long id;
	private String nombre;
	private String fechaNacimiento;
	private Integer edadPerro;
	private Double meses;
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
	public Double getEdadPerro() {
		return meses/12;
	}
	public void setEdadPerro(Integer edadPerro) {
		this.edadPerro = edadPerro;
	}
	public Double getMeses() {
		return meses;
	}
	public void setMeses(Double meses) {
		this.meses = meses;
	}

}
