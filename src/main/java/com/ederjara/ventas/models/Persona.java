package com.ederjara.ventas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	@Column(name="apellidos", length = 80, nullable = false)
	private String apellidos;
	@Column(name="nombres", length = 80, nullable = false)
	private String nombres;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellidos=" + apellidos + ", nombres=" + nombres + "]";
	}	
	
}
