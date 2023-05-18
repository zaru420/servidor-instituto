package com.demoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoapi.model.Usuario;
import com.demoapi.respository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/usuario/{nombre}")
	public List<Usuario> findByNombre(@PathVariable("nombre") String nombre) {
		return repository.findByNombre(nombre);
	}

	/**
	 * Obtener todos
	 * @return
	 */
	@GetMapping("/usuario")
	public List<Usuario> allUsuario(){
		return repository.findAll();
	}

	
	/**
	 * Crear
	 * @param Usuario
	 * @return
	 */
	@PostMapping("/usuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	/**
	 * Actualizar por id
	 * @param id
	 * @param tipoUsuario
	 * @return
	 */
	@PutMapping("/usuario/{id}")
	public Usuario updateById(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		Usuario existingUsuario = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("usuario not found with id: " + id));

		existingUsuario.setDni(usuario.getDni());
		existingUsuario.setNombre(usuario.getNombre());
		existingUsuario.setApellidos(usuario.getApellidos());
		existingUsuario.setUsuario(usuario.getUsuario());
		existingUsuario.setContraseña(usuario.getContraseña());
		existingUsuario.setFoto(usuario.getFoto());
		existingUsuario.setDireccion(usuario.getDireccion());
		existingUsuario.setTelefono(usuario.getTelefono());
		existingUsuario.setTipoUsuario(usuario.getTipoUsuario());
		existingUsuario.setActivo(usuario.getActivo());

		return repository.save(existingUsuario);
	}
	
	/**
	 * Eliminar por id
	 * @param id
	 */
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
