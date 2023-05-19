package com.demoapi.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demoapi.model.Cursos;


@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long>{

	List<Cursos> findByNombre(@Param("nombre") String nombre);
}
