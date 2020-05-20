package com.gestion.usuarios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.usuarios.entidades.Usuario;
import com.gestion.usuarios.generics.ServResultadoOUT;
import com.gestion.usuarios.repository.UsuarioRepository;
import com.gestion.usuarios.utils.Constantes;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRep;
	/**
	 * Controller de Gestion de Usuario
	 * http://localhost:8081/login
	 */
	
	@GetMapping("/login/{id}/{pass}")
	public ServResultadoOUT login(@PathVariable("id") String id, @PathVariable("pass") String pass) {
		
		Usuario usuario = usuarioRep.findByEmail(id);
		ServResultadoOUT serResult= new ServResultadoOUT();
		String passUser = "";
		
		if(usuario == null) {
			usuario = usuarioRep.findByDni(id);
			if(usuario != null) {
				passUser = usuario.getPassword();
			}
		} else {
			passUser = usuario.getPassword();
		}
		
		if(pass.equals(passUser)) {
			serResult.setResultado(Constantes.CONS_RESULTADO_OK);
			serResult.setUsuario(usuario);
			return serResult;
		} else {
			serResult.setResultado(Constantes.CONS_RESULTADO_KO);
			return serResult;
		}
	}	
}