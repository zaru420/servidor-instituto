package com.demoapi.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoapi.model.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

	@Query("SELECT tu FROM TipoUsuario tu WHERE tu.nombre LIKE %:query% OR tu.funciones LIKE %:query%")
    List<TipoUsuario> findByCustomQuery(@Param("query") String query);
	
}


