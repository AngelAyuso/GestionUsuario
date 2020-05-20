package com.gestion.usuarios.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.gestion.usuarios.entidades.Usuario;

@Component
public interface UsuarioRepository  extends CrudRepository<Usuario, Long> {
	
	public Usuario findByEmail(@Param("email") String email);
	
	public Usuario findByDni(@Param("dni") String dni);
	
}
