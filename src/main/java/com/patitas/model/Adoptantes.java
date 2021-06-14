package com.patitas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "adoptantes")
public class Adoptantes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "fecha_adopcion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAdopcion;											
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	private User  usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="adoptante")
	private List<Mascotas>  listaMascotas= new ArrayList<Mascotas>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaAdopcion() {
		return fechaAdopcion;
	}

	public void setFechaAdopcion(Date fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public List<Mascotas> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascotas> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
}
