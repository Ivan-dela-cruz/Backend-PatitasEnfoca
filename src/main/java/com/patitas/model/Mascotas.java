package com.patitas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mascotas")
public class Mascotas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.TIME)
	private Date fechaNacimiento;
	
	@Column(name = "edad_perro")
    private Double edadPerro;
	
	
	 @ManyToOne
	 private Adopcion adoptante;

	public Mascotas() {
		super();
	}

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Double getEdadPerro() {
		return edadPerro;
	}

	public Adopcion getAdoptante() {
		return adoptante;
	}

	public void setAdoptante(Adopcion adoptante) {
		this.adoptante = adoptante;
	}

	public void setEdadPerro(Double edadPerro) {
		this.edadPerro = edadPerro;
	}
	
}
