package com.demoapi.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tipo_usuario")
@EntityListeners(AuditingEntityListener.class)
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre") //Dudo si esto lo necesito
	private String nombre;
	
	@Column(name = "funciones") //Dudo si esto lo necesito
	private String funciones;
	
	public TipoUsuario(Long id, String nombre, String funciones) {
		this.id=id;
		this.nombre=nombre;
		this.funciones=funciones;
			
	}
	
	public TipoUsuario() {
		
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones= funciones;
	}

	@Override
	public String toString() {
		return "TipoUsuario [id=" + id + ", nombre=" + nombre + ", funciones=" + funciones + "]";
	}
	
	
}
