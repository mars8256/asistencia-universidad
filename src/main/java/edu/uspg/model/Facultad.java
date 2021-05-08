package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facultad")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idFacultad;
	
	@Column(name="nombre", nullable  = false, length = 50)
	String nombre;

	public Integer getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(Integer idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
