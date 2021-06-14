package com.patitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adoptantes")
public class Adoptante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "identificacion")
	private String identificacion;
	
	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "telefono1")
	private String telefono1;
	
	@Column(name = "telefono2")
	private String telefono2;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "correo")
	private String correo;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public String toString() {
		return "Adoptante [id=" + id + ", identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", celular=" + celular
				+ ", correo=" + correo + ", callePrincipal=" + callePrincipal + ", calle_secundaria=" + calle_secundaria
				+ ", numero=" + numero + ", ciudad=" + ciudad + ", referencia=" + referencia + "]";
	}

	
	public Adoptante() {
		
	}
	
	public Adoptante( String identificacion, String nombres, String apellidos, String telefono1,
			String telefono2, String celular, String correo, String callePrincipal, String calle_secundaria,
			String numero, String ciudad, String referencia) {
		super();
 
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.celular = celular;
		this.correo = correo;
		this.callePrincipal = callePrincipal;
		this.calle_secundaria = calle_secundaria;
		this.numero = numero;
		this.ciudad = ciudad;
		this.referencia = referencia;
	}
	
	

}
