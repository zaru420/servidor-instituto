package com.demoapi.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoapi.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    List<Usuario> findByNombre(@Param("nombre") String nombre);
    Optional<Usuario> findById(@Param("id") Long id);
    Optional<Usuario> findByUsuario(@Param("usuario") String usuario);
    Optional<Usuario> findByUsuarioAndContrasena(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
}

