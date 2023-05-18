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
@Table(name = "asignaturas")
@EntityListeners(AuditingEntityListener.class)
public class Asignaturas {


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
	 * @return the idProfesor1
	 */
	public Integer getIdProfesor1() {
		return idProfesor1;
	}

	/**
	 * @param idProfesor1 the idProfesor1 to set
	 */
	public void setIdProfesor1(Integer idProfesor1) {
		this.idProfesor1 = idProfesor1;
	}

	/**
	 * @return the idProfesor2
	 */
	public Integer getIdProfesor2() {
		return idProfesor2;
	}

	/**
	 * @param idProfesor2 the idProfesor2 to set
	 */
	public void setIdProfesor2(Integer idProfesor2) {
		this.idProfesor2 = idProfesor2;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "idProfesor1")
	private Integer idProfesor1;
	
	@Column(name = "idProfesor2")
	private Integer idProfesor2;
	
	@Column(name = "nombre")
	private String nombre;

	public Asignaturas(Long id, Integer idProfesor1, Integer idProfesor2, String nombre) {
		super();
		this.id = id;
		this.idProfesor1 = idProfesor1;
		this.idProfesor2 = idProfesor2;
		this.nombre = nombre;
	}

	public Asignaturas() {}
	
	@Override
	public String toString() {
		return "Asignaturas [id=" + id + ", idProfesor1=" + idProfesor1 + ", idProfesor2=" + idProfesor2 + ", nombre="
				+ nombre + "]";
	}

}
