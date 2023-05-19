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
import org.springframework.web.bind.annotation.RestController;

import com.demoapi.model.Cursos;
import com.demoapi.respository.CursosRepository;

@RestController
@RequestMapping("/api")
public class CursosController {

	@Autowired
	private CursosRepository repository;
	
	@GetMapping("/cursos/{nombre}")
	public List<Cursos> findByNombre(@PathVariable("nombre") String nombre) {
		return repository.findByNombre(nombre);
	}

	/**
	 * Obtener todos
	 * @return
	 */
	@GetMapping("/cursos")
	public List<Cursos> allCursos(){
		return repository.findAll();
	}


	/**
	 * Crear
	 * @param Usuario
	 * @return
	 */
	@PostMapping("/cursos")
	public Cursos createCursos(@RequestBody Cursos cursos) {
		return repository.save(cursos);
	}
	
	/**
	 * Actualizar por id
	 * @param id
	 * @param tipoUsuario
	 * @return
	 */
	@PutMapping("/cursos/{id}")
	public Cursos updateById(@PathVariable("id") Long id, @RequestBody Cursos cursos) {
		Cursos existingCursos = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("cursos not found with id: " + id));

	    existingCursos.setNombre(cursos.getNombre());
	    existingCursos.setIdA1(cursos.getIdA1());
	    existingCursos.setIdA2(cursos.getIdA2());
	    existingCursos.setIdA3(cursos.getIdA3());
	    existingCursos.setIdA4(cursos.getIdA4());
	    existingCursos.setIdA5(cursos.getIdA5());
	    existingCursos.setIdA6(cursos.getIdA6());
	    existingCursos.setIdA7(cursos.getIdA7());
	    existingCursos.setIdA8(cursos.getIdA8());
	    existingCursos.setIdA9(cursos.getIdA9());
	    existingCursos.setIdA10(cursos.getIdA10());

	    


		return repository.save(existingCursos);
	}
	
	/**
	 * Eliminar por id
	 * @param id
	 */
	@DeleteMapping("/cursos/{id}")
	public void deleteCursos(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
