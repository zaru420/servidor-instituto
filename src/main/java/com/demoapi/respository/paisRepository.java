package com.demoapi.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demoapi.model.Pais;

@Repository
public interface paisRepository extends JpaRepository<Pais, Long>{
	
	List<Pais> findByName(@Param("name") String name);
	
}


