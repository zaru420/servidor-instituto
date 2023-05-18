package com.demoapi.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoapi.model.Asignaturas;

@Repository
public interface AsignaturasRepository extends JpaRepository<Asignaturas, Long>{

	List<Asignaturas> findByNombre(@Param("nombre") String nombre);
}

