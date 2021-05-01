package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idAlumno;
	
	@Column(name = "nombres", nullable = false, length = 30)
	String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 30)
	String apellidos;
	
	@Column(name = "carnet", nullable = false, length = 15)
	String carnet;
	
	@Column(name = "correo", nullable = false, length = 30)
	String correo;
	
	@Column(name = "telefono", nullable = true, length = 10)
	String telefono;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
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

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
}
