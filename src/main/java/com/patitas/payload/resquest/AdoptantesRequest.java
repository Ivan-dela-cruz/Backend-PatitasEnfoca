package com.patitas.payload.resquest;

import java.util.ArrayList;
import java.util.List;

import com.patitas.model.Mascotas;

public class AdoptantesRequest {

   
	private String fechaAdopcion;
	
	private UsuarioRequest usuario;
	
	private List<MascotaRequest>  listaMascotas= new ArrayList<MascotaRequest>();

	public String getFechaAdopcion() {
		return fechaAdopcion;
	}

	public void setFechaAdopcion(String fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}

	public UsuarioRequest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRequest usuario) {
		this.usuario = usuario;
	}

	public List<MascotaRequest> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<MascotaRequest> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	@Override
	public String toString() {
		return "AdoptantesRequest [fechaAdopcion=" + fechaAdopcion + ", usuario=" + usuario + ", getFechaAdopcion()="
				+ getFechaAdopcion() + ", getUsuario()=" + getUsuario() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}			
	
	
}
