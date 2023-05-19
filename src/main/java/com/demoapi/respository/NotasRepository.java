package com.demoapi.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.demoapi.model.Notas;

public interface NotasRepository extends JpaRepository<Notas, Long>{

	List<Notas> findById(@Param("id") int id);
}