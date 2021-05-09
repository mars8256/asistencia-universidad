package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catedratico")
public class Catedratico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idCatedratico;
	@Column(name = "nombres", nullable = false, length = 30)
	String nombres;
	@Column(name = "apellidos", nullable = false, length = 30)
	String apellidos;
	@Column(name = "correo", nullable = false, length = 50)
	String correo;
	
	

	
	
	public Integer getIdCatedratico() {
		return idCatedratico;
	}
	public void setIdCatedratico(Integer idCatedratico) {
		this.idCatedratico = idCatedratico;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
}
