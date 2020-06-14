package com.gestion.usuarios.service;

import com.gestion.usuarios.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByEmail(String email);
	public Usuario findByDni(String dni);
	public Usuario findById(Integer id);
	
	//Operaciones CRUD
	public Usuario save(Usuario usuario);
	public void deleteById(Integer id);
}
