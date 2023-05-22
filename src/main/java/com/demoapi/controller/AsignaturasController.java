package com.demoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapi.model.Asignaturas;
import com.demoapi.respository.AsignaturasRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AsignaturasController {

	@Autowired
	private AsignaturasRepository repository;
	
	@GetMapping("/asignaturas/{nombre}")
	public List<Asignaturas> findByNombre(@PathVariable("nombre") String nombre) {
		return repository.findByNombre(nombre);
	}
	
	/**
	 * Obtener todos
	 * @return
	 */
	@GetMapping("/asignaturas")
	public List<Asignaturas> allAsignaturas(){
		return repository.findAll();
	}

	
	/**
	 * Crear
	 * @param tipoAsignatura
	 * @return
	 */
	@PostMapping("/asignaturas")
	public Asignaturas createAsignaturas(@RequestBody Asignaturas asignaturas) {
		return repository.save(asignaturas);
	}
	
	/**
	 * Actualizar por id
	 * @param id
	 * @param asignatura
	 * @return
	 */
	@PutMapping("/asignaturas/{id}")
	public Asignaturas updateById(@PathVariable("id") Long id, @RequestBody Asignaturas asignaturas) {
	    Asignaturas existingAsignaturas = repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Asignatura not found with id: " + id));

	    existingAsignaturas.setIdProfesor1(asignaturas.getIdProfesor1());
	    existingAsignaturas.setIdProfesor2(asignaturas.getIdProfesor2());
	    existingAsignaturas.setNombre(asignaturas.getNombre());

	    return repository.save(existingAsignaturas);
	}

	
	/**
	 * Eliminar por id
	 * @param id
	 */
	@DeleteMapping("/asignaturas/{id}")
	public void deleteAsignaturas(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
	
	
	
	
}
