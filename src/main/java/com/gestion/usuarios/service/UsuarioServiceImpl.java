package com.gestion.usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.usuarios.models.entity.Usuario;
import com.gestion.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmail(String email) {
		return usuarioRep.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByDni(String dni) {
		return usuarioRep.findByDni(dni);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Integer id) {
		return usuarioRep.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRep.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		usuarioRep.deleteById(id);
	}
}