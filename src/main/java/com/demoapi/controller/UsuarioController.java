package com.demoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoapi.model.Usuario;
import com.demoapi.respository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	/**
	 * buscar usuarios por nombre 
	 * @param nombre - String nombre de usuarios
	 * @return devuelve la lista de los usuarios con el nombre dado
	 */
	@GetMapping("/usuario/{nombre}")
	public List<Usuario> findByNombre(@PathVariable("nombre") String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error al buscar usuarios por nombre: " + e.getMessage(), e);
		}
	}	
		

	/**
	 * buscar un usuario por id
	 * @param id - number id del usuario
	 * @return devuelve el usuario con la id dada
	 */
	@GetMapping("/usuario/{id}")
	public Optional<Usuario> findById(@PathVariable("id") Long id) {
		try {
			return repository.findById(id);
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error al buscar usuarios por id: " + e.getMessage(), e);
		}
	}
	
	/**
	 * Obtener todos los usuarios
	 * @return
	 */
	@GetMapping("/usuario")
	public List<Usuario> allUsuario() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error al obtener todos los usuarios: " + e.getMessage(), e);
		}
	}
	
	/**
	 * Crear un usuario
	 * @param Usuario - Entity Usuario con los campos del usuario requeridos
	 * @return devuelve el usuario creado
	 */
	@PostMapping("/usuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		try {
			return repository.save(usuario);
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error al crear el usuario: " + e.getMessage(), e);
		}
	}

	
	/**
	 * Actualizar por id
	 * @param id - number id del Usuario 
	 * @param usuario - datos del usuario a actualizar, y la busca por la id 
	 * @return devuelve el usuario actualizado
	 */
	@PutMapping("/usuario/{id}")
	public Usuario updateById(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		try {
			Usuario existingUsuario = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("usuario not found with id: " + id));
	
			existingUsuario.setDni(usuario.getDni());
			existingUsuario.setNombre(usuario.getNombre());
			existingUsuario.setApellidos(usuario.getApellidos());
			existingUsuario.setUsuario(usuario.getUsuario());
			existingUsuario.setContrasena(usuario.getContrasena());
			existingUsuario.setFoto(usuario.getFoto());
			existingUsuario.setDireccion(usuario.getDireccion());
			existingUsuario.setTelefono(usuario.getTelefono());
			existingUsuario.setTipoUsuario(usuario.getTipoUsuario());
			existingUsuario.setActivo(usuario.getActivo());
	
			return repository.save(existingUsuario);
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error al actualizar el usuario: " + e.getMessage(), e);
		}
	}
	
	/**
	 * Eliminar por id el usuario
	 * @param id
	 */
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error al eliminar el usuario: " + e.getMessage(), e);
		}
	}
	/***************************** AUTENTICACIÓN *****************************/
	/**
	 * en el login busca al usuario registrado y trata de hacer el login
	 * @param usuario - Entity(entidad) con usuario y contrasena para hacer login
	 * @return devuelve el usuario que ha iniciado sesion, si no, devuelve un error con message 
	 */
	@PostMapping("/usuario/login")
	public Usuario login(@RequestBody Usuario usuario) {
	    try {
	    	// Busca al usuario con su contrasena 
	        Usuario usuarioExistente = repository.findByUsuarioAndContrasena(usuario.getUsuario(), usuario.getContrasena())
	        		// si no lo encuentra, devuelve un message de Error
	                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + usuario.getUsuario()));
	        // comprueba la contrasena 
	        if (!validarContrasena(usuario.getContrasena(), usuarioExistente.getContrasena())) {
	            throw new RuntimeException("Invalid password");
	        }
	        // el usuario al iniciar sesion, establece el estado como activo(1) y guarda los cambios
	        usuarioExistente.setActivo(1);
	        repository.save(usuarioExistente);

	        return usuarioExistente;
	    } catch (Exception e) {
	    	// cualquier otro error, muestra un message
	        throw new RuntimeException("Error logging in: " + e.getMessage(), e);
	    }
	}
	
	/**
	 * 	Validación de la contrasena
	 *	En un escenario real, querrías utilizar una biblioteca de hashing de contraseñas segura para hacer esto
	 * @param contrasenaRaw - la que me pasa el usuario
	 * @param contrasenaHashed - la que esta en la BBDD
	 * @return devuelve true si las contrasenas son iguales
	 */
	private boolean validarContrasena(String contrasenaRaw, String contrasenaHashed) {
		// Implementa la validación de la contraseña aquí
		return contrasenaHashed.equals(contrasenaRaw);
	}
	/**
	 * Es el logout(cierre de sesion) 
	 * @param usuario - trae al usuario de la BBDD, para cambiar el estado activo a (0)
	 */
	@PostMapping("/usuario/logout")
	public void logout(@RequestBody Usuario usuario) {
		try {
			System.out.println(usuario);
			// Obtener el usuario de la base de datos por el nombre de usuario
			Usuario usuarioExistente = repository.findByUsuario(usuario.getUsuario())
					// Si no lo encuentra, lanza un error de usuario no encontrado
					.orElseThrow(() -> new RuntimeException("Usuario not found with : " + usuario.getUsuario()));

			// Cambiar el valor de "activo" del usuario en la base de datos
			usuarioExistente.setActivo(0); // 1 para activo, 0 para inactivo
			repository.save(usuarioExistente);
			
			// Aquí, invalidarías cualquier token de sesión del usuario
			// Esto depende completamente de cómo estés manejando los tokens de sesión
		} catch (Exception e) {
			// Manejo de excepciones y devolución de información útil
			throw new RuntimeException("Error logging out: " + e.getMessage(), e);
		}
	}
}

