package com.demoapi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notas")
@EntityListeners(AuditingEntityListener.class)
public class Notas {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_alumno")
	private Integer idAlumno;
	
	@Column(name = "id_asignatura")
	private Integer idAsignatura;
	
	@Column(name = "id_curso")
	private String idCurso;
	
	@Column(name = "nota")
	private String nota;

	public Notas(Long id, Integer idAlumno, Integer idAsignatura, String idCurso, String nota) {
		super();
		this.id = id;
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.idCurso = idCurso;
		this.nota = nota;
	}
	public Notas() {}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the idAlumno
	 */
	public Integer getIdAlumno() {
		return idAlumno;
	}
	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	/**
	 * @return the idAsignatura
	 */
	public Integer getIdAsignatura() {
		return idAsignatura;
	}
	/**
	 * @param idAsignatura the idAsignatura to set
	 */
	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	/**
	 * @return the idCurso
	 */
	public String getIdCurso() {
		return idCurso;
	}
	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	/**
	 * @return the nota
	 */
	public String getNota() {
		return nota;
	}
	/**
	 * @param nota the nota to set
	 */
	public void setNota(String nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Notas [id=" + id + ", idAlumno=" + idAlumno + ", idAsignatura=" + idAsignatura + ", idCurso=" + idCurso
				+ ", nota=" + nota + "]";
	}
	
}
