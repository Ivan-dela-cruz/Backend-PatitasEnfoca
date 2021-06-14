package com.patitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "nombre")
	private String nombre;

	
	@Column(name = "comercial")
	private String comercial;
	
	@Column(name = "telefono1")
	private String telefono1;
	
	@Column(name = "telefono2")
	private String telefono2;
	
	@Column(name = "calle_principal")
	private String callePrincipal;
	
	@Column(name = "calle_secundaria")
	private String calle_secundaria;
	
	@Column(name = "numero")
	private String numero;
	
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "referencia")
	private String referencia;
	
	
	

	public Empresa() {
		super();
	}


	public Empresa(String ruc, String nombre, String comercial, String telefono1, String telefono2,
			String callePrincipal, String calle_secundaria, String numero, String ciudad, String referencia) {
		super();
		this.ruc = ruc;
		this.nombre = nombre;
		this.comercial = comercial;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.callePrincipal = callePrincipal;
		this.calle_secundaria = calle_secundaria;
		this.numero = numero;
		this.ciudad = ciudad;
		this.referencia = referencia;
	}
	

	public Empresa( @JsonProperty("ruc") String ruc, @JsonProperty("nombre") String nombre, @JsonProperty("comercial") String comercial, @JsonProperty("ciudad") String ciudad) {
		super();
		this.ruc = ruc;
		this.nombre = nombre;
		this.comercial = comercial;
		this.ciudad = ciudad;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCallePrincipal() {
		return callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public String getCalle_secundaria() {
		return calle_secundaria;
	}

	public void setCalle_secundaria(String calle_secundaria) {
		this.calle_secundaria = calle_secundaria;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
