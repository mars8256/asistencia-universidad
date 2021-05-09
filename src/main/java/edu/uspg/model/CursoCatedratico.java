package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso_catedratico")
public class CursoCatedratico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idCursoCatedratico;
	@ManyToOne
	@JoinColumn(name="id_curso",nullable = false, foreignKey = @ForeignKey(name = "curso_catedratico_curso"))
	Curso curso;
	@ManyToOne
	@JoinColumn(name="id_catedratico",nullable = false, foreignKey = @ForeignKey(name = "curso_catedratico_catedratico"))
	Catedratico catedratico;
	@Column(name = "hora_inicio", nullable = false, length = 5)
	String horaInicio;
	@Column(name = "hora_fin", nullable = false, length = 5)
	String horaFin;
	@Column(name = "dia_semana", nullable = false)
	Integer diaSemana;
	@Column(name = "anio", nullable = false)
	Integer anio;
	@Column(name = "semestre", nullable = false)
	Integer semestre;
	
	
	public Integer getIdCursoCatedratico() {
		return idCursoCatedratico;
	}
	public void setIdCursoCatedratico(Integer idCursoCatedratico) {
		this.idCursoCatedratico = idCursoCatedratico;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Catedratico getCatedratico() {
		return catedratico;
	}
	public void setCatedratico(Catedratico catedratico) {
		this.catedratico = catedratico;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
}
