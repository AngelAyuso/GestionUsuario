package com.gestion.usuarios.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.gestion.usuarios.models.entity.Usuario;

@Component
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	
	public Usuario findByEmail(@Param("email") String email);
	
	public Usuario findByDni(@Param("dni") String dni);
}
