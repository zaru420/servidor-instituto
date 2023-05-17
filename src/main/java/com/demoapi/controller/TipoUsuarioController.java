package com.demoapi.controller;

import java.util.List;
import java.util.Optional;

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


import com.demoapi.model.TipoUsuario;
import com.demoapi.respository.TipoUsuarioRepository;


@RestController
@RequestMapping("/api")
public class TipoUsuarioController {
	@Autowired
	private TipoUsuarioRepository repository;
	
	/**
	 * Obtener todos
	 * @return
	 */
	@GetMapping("/tipoUsuario")
	public List<TipoUsuario> allTipoUsuario(){
		return repository.findAll();
	}
	
	/**
	 * Buscar por coincidencia
	 * @param query
	 * @return
	 */
	@GetMapping("/tipoUsuario/buscar")
	public List<TipoUsuario> findByFields(@RequestParam("q") String query) {
	    return repository.findByCustomQuery(query);
	}


	
	/**
	 * Crear
	 * @param tipoUsuario
	 * @return
	 */
	@PostMapping("/tipoUsuario")
	public TipoUsuario createTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return repository.save(tipoUsuario);
	}
	
	/**
	 * Actualizar por id
	 * @param id
	 * @param tipoUsuario
	 * @return
	 */
	@PutMapping("/tipoUsuario/{id}")
	public TipoUsuario updateById(@PathVariable("id") Long id, @RequestBody TipoUsuario tipoUsuario) {
		TipoUsuario existingTipoUsuario = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("TipoUsuario not found with id: " + id));

		existingTipoUsuario.setNombre(tipoUsuario.getNombre());
		existingTipoUsuario.setFunciones(tipoUsuario.getFunciones());

		return repository.save(existingTipoUsuario);
	}
	
	/**
	 * Eliminar por id
	 * @param id
	 */
	@DeleteMapping("/tipoUsuario/{id}")
	public void deleteTipoUsuario(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
	
	
}
