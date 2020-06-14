package com.gestion.usuarios.utils;

import com.gestion.usuarios.models.entity.Usuario;

public class Matcher {
	
	
	/**
	 * Metodo que realiza el match del usuario recibido del formulario con el devuelto por la BBDD
	 * @param usuarioMatchForm
	 * @param usuarioMatchBBDD
	 * @return
	 */
	public static void matchUsuarioMatch(Usuario usuarioForm, Usuario usuarioBBDD) {
		usuarioForm.setIdUsuario(usuarioForm.getIdUsuario());
		usuarioForm.setPassword(Utils.compare(usuarioForm.getPassword(), usuarioBBDD.getPassword()));
		usuarioForm.setDni(Utils.compare(usuarioForm.getDni(), usuarioBBDD.getDni()));
		usuarioForm.setEmail(Utils.compare(usuarioForm.getEmail(), usuarioBBDD.getEmail()));
		usuarioForm.setNombre(Utils.compare(usuarioForm.getNombre(), usuarioBBDD.getNombre()));
		usuarioForm.setPrimerApellido(Utils.compare(usuarioForm.getPrimerApellido(), usuarioBBDD.getPrimerApellido()));
		usuarioForm.setSegundoApellido(Utils.compare(usuarioForm.getSegundoApellido(), usuarioBBDD.getSegundoApellido()));
		usuarioForm.setTelefono(Utils.compare(usuarioForm.getTelefono(), usuarioBBDD.getTelefono()).intValue());
		usuarioForm.setEnabled(Utils.compare(usuarioForm.getEnabled(), usuarioBBDD.getEnabled()));
		usuarioForm.setFechaAlta(Utils.compare(usuarioForm.getFechaAlta(), usuarioBBDD.getFechaAlta()));
		usuarioForm.setFechaModificacion(Utils.compare(usuarioForm.getFechaModificacion(), usuarioBBDD.getFechaModificacion()));
	}
	
	
	
}
