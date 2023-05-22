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

import com.demoapi.model.Notas;
import com.demoapi.respository.NotasRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NotasController {

	@Autowired
	private NotasRepository repository;
	
	@GetMapping("/notas/{id}")
	public List<Notas> findByNombre(@PathVariable("id") int id) {
		return repository.findById(id);
	}
	
	/**
	 * Obtener todos
	 * @return
	 */
	@GetMapping("/notas")
	public List<Notas> allNotas(){
		return repository.findAll();
	}

	
	/**
	 * Crear
	 * @param tipoNotas
	 * @return
	 */
	@PostMapping("/notas")
	public Notas createNotas(@RequestBody Notas notas) {
		return repository.save(notas);
	}
	
	/**
	 * Actualizar por id
	 * @param id
	 * @param notas
	 * @return
	 */
	@PutMapping("/notas/{id}")
	public Notas updateById(@PathVariable("id") Long id, @RequestBody Notas notas) {
	    Notas existingNotas = repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Notas not found with id: " + id));

	    existingNotas.setIdAlumno(notas.getIdAlumno());
	    existingNotas.setIdAsignatura(notas.getIdAsignatura());
	    existingNotas.setIdCurso(notas.getIdCurso());
	    existingNotas.setNota(notas.getNota());

	    return repository.save(existingNotas);
	}

	
	/**
	 * Eliminar por id
	 * @param id
	 */
	@DeleteMapping("/notas/{id}")
	public void deleteNotas(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
	
	
}
