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
@Table(name = "cursos")
@EntityListeners(AuditingEntityListener.class)

public class Cursos {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "id_a1") 
	private String idA1;
	
	@Column(name = "id_a2") 
	private String idA2;
	
	@Column(name = "id_a3") 
	private String idA3;
	
	@Column(name = "id_a4") 
	private String idA4;
	
	@Column(name = "id_a5") 
	private String idA5;
	
	@Column(name = "id_a6") 
	private String idA6;
	
	@Column(name = "id_a7") 
	private String idA7;
	
	@Column(name = "id_a8") 
	private String idA8;
	
	@Column(name = "id_a9") 
	private String idA9;
	
	@Column(name = "id_a10") 
	private String idA10;
	
	@Column(name = "nombre") 
	private String nombre;

	public Cursos(Long id, String idA1, String idA2, String idA3, String idA4, String idA5, String idA6, String idA7,
			String idA8, String idA9, String idA10, String nombre) {
		super();
		this.id = id;
		this.idA1 = idA1;
		this.idA2 = idA2;
		this.idA3 = idA3;
		this.idA4 = idA4;
		this.idA5 = idA5;
		this.idA6 = idA6;
		this.idA7 = idA7;
		this.idA8 = idA8;
		this.idA9 = idA9;
		this.idA10 = idA10;
		this.nombre = nombre;
	}
	
	public Cursos() {}
	
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
	 * @return the idA1
	 */
	public String getIdA1() {
		return idA1;
	}

	/**
	 * @param idA1 the idA1 to set
	 */
	public void setIdA1(String idA1) {
		this.idA1 = idA1;
	}

	/**
	 * @return the idA2
	 */
	public String getIdA2() {
		return idA2;
	}

	/**
	 * @param idA2 the idA2 to set
	 */
	public void setIdA2(String idA2) {
		this.idA2 = idA2;
	}

	/**
	 * @return the idA3
	 */
	public String getIdA3() {
		return idA3;
	}

	/**
	 * @param idA3 the idA3 to set
	 */
	public void setIdA3(String idA3) {
		this.idA3 = idA3;
	}

	/**
	 * @return the idA4
	 */
	public String getIdA4() {
		return idA4;
	}

	/**
	 * @param idA4 the idA4 to set
	 */
	public void setIdA4(String idA4) {
		this.idA4 = idA4;
	}

	/**
	 * @return the idA5
	 */
	public String getIdA5() {
		return idA5;
	}

	/**
	 * @param idA5 the idA5 to set
	 */
	public void setIdA5(String idA5) {
		this.idA5 = idA5;
	}

	/**
	 * @return the idA6
	 */
	public String getIdA6() {
		return idA6;
	}

	/**
	 * @param idA6 the idA6 to set
	 */
	public void setIdA6(String idA6) {
		this.idA6 = idA6;
	}

	/**
	 * @return the idA7
	 */
	public String getIdA7() {
		return idA7;
	}

	/**
	 * @param idA7 the idA7 to set
	 */
	public void setIdA7(String idA7) {
		this.idA7 = idA7;
	}

	/**
	 * @return the idA8
	 */
	public String getIdA8() {
		return idA8;
	}

	/**
	 * @param idA8 the idA8 to set
	 */
	public void setIdA8(String idA8) {
		this.idA8 = idA8;
	}

	/**
	 * @return the idA9
	 */
	public String getIdA9() {
		return idA9;
	}

	/**
	 * @param idA9 the idA9 to set
	 */
	public void setIdA9(String idA9) {
		this.idA9 = idA9;
	}

	/**
	 * @return the idA10
	 */
	public String getIdA10() {
		return idA10;
	}

	/**
	 * @param idA10 the idA10 to set
	 */
	public void setIdA10(String idA10) {
		this.idA10 = idA10;
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

	@Override
	public String toString() {
		return "Cursos [id=" + id + ", idA1=" + idA1 + ", idA2=" + idA2 + ", idA3=" + idA3 + ", idA4=" + idA4
				+ ", idA5=" + idA5 + ", idA6=" + idA6 + ", idA7=" + idA7 + ", idA8=" + idA8 + ", idA9=" + idA9
				+ ", idA10=" + idA10 + ", nombre=" + nombre + "]";
	}

	
	
}
