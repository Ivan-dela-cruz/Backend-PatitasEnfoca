package com.patitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "codigos")
public class Codigo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "nombre")
	private String nombre;


	@Column(name = "parametros")
	private String parametros;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maestro")
	private Maestro  maestro;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getParametros() {
		return parametros;
	}


	public void setParametros(String parametros) {
		this.parametros = parametros;
	}


	public Maestro getMaestro() {
		return maestro;
	}


	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}
}
