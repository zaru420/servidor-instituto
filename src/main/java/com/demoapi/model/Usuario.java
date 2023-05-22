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
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "nombre") 
	private String nombre;
	
	@Column(name = "apellidos") 
	private String apellidos;
	
	@Column(name = "usuario") 
	private String usuario;
	
	@Column(name = "contrasena") 
	private String contrasena;
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "direccion") 
	private String direccion;
	
	@Column(name = "telefono") 
	private String telefono;
	
	@Column(name = "tipo_usuario")
	private Integer tipoUsuario;
	
	@Column(name = "activo")
	private Short activo;

	/**
	 * @param id
	 * @param DNI
	 * @param nombre
	 * @param apellidos
	 * @param usuario
	 * @param contrasena
	 * @param foto
	 * @param direccion
	 * @param telefono
	 * @param tipo_usuario
	 * @param activo
	 */
	public Usuario(Long id, String dni, String nombre, String apellidos, String usuario, String contrasena, String foto,
			String direccion, String telefono, Integer tipoUsuario, Short activo) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.foto = foto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		this.activo = activo;
	}
	
	public Usuario() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Short getActivo() {
		return activo;
	}

	public void setActivo(int  activo) {
		this.activo = (short) activo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", DNI=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario="
				+ usuario + ", contraseña=" + contrasena + ", foto=" + foto + ", direccion=" + direccion + ", telefono="
				+ telefono + ", tipoUsuario=" + tipoUsuario + ", activo=" + activo + "]";
	}

	
}


