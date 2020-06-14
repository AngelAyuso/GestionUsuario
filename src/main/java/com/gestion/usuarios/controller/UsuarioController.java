package com.gestion.usuarios.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.commons.utils.ConstantesErrores;
import com.gestion.usuarios.models.ResultadoBean;
import com.gestion.usuarios.models.entity.Usuario;
import com.gestion.usuarios.service.IUsuarioService;
import com.gestion.usuarios.utils.Constantes;
import com.gestion.usuarios.utils.Matcher;
import com.gestion.usuarios.utils.Utils;


/**
 * Controller de Gestion de Usuario
 * http://localhost:8081/login
 * @author Angel Ayuso
 *
 */
@RefreshScope
@RestController
public class UsuarioController {
	
	private static final Logger logger = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	IUsuarioService usuarioService;
		
	/**
	 * Devuelve un Usuario por el Id
	 * @param id
	 * @return ServResultadoOUT
	 */
	@GetMapping("/getUsuarioById/{id}")
	public ResultadoBean getUsuarioById(@PathVariable("id") Integer id) {

		logger.info("/getUsuarioById ");
		logger.info("  Parametro de entrada: ");
		logger.info("    id: " + id);
		
		ResultadoBean resultadoBean= new ResultadoBean();
		Usuario usuario = usuarioService.findById(id);
		
		if(usuario != null) {
			resultadoBean.setResultado(Constantes.CONS_RESULTADO_OK);
			resultadoBean.setUsuario(usuario);
		} else {
			resultadoBean.setResultado(Constantes.CONS_RESULTADO_KO);
			resultadoBean.setCodError(ConstantesErrores.COD_ERROR_105);
		}
		
		return resultadoBean;
	}
	
	/**
	 * Devuelve un Usuario por el DNI
	 * @param id
	 * @return ServResultadoOUT
	 */
	@GetMapping("/getUsuarioByDni/{dni}")
	public ResultadoBean getUsuarioByDni(@PathVariable("dni") String dni) {
		
		logger.info("/getUsuarioByDni ");
		logger.info("  Parametro de entrada: ");
		logger.info("    dni: " + dni);
		
		ResultadoBean servResult= new ResultadoBean();
		Usuario usuario = usuarioService.findByDni(dni);
		
		if(usuario != null) {
			servResult.setResultado(Constantes.CONS_RESULTADO_OK);
			servResult.setUsuario(usuario);
		} else {
			servResult.setResultado(Constantes.CONS_RESULTADO_KO);
			servResult.setCodError(ConstantesErrores.COD_ERROR_105);
		}
		
		return servResult;
	}
	
	/**
	 * Devuelve un Usuario por el Email
	 * @param id
	 * @return ServResultadoOUT
	 */
	@GetMapping("/getUsuarioByEmail/{email}")
	public ResultadoBean getUsuarioByEmail(@PathVariable("email") String email) {
		
		logger.info("/getUsuarioByEmail ");
		logger.info("  Parametro de entrada: ");
		logger.info("    email: " + email);
		
		ResultadoBean resultadoBean= new ResultadoBean();
		Usuario usuario = usuarioService.findByEmail(email);
		
		if(usuario != null) {
			resultadoBean.setResultado(Constantes.CONS_RESULTADO_OK);
			resultadoBean.setUsuario(usuario);
		} else {
			resultadoBean.setResultado(Constantes.CONS_RESULTADO_KO);
			resultadoBean.setCodError(ConstantesErrores.COD_ERROR_105);
		}
		
		return resultadoBean;
	}
	
	/**
	 * Crea un nuevo Usuario
	 * @param usuario
	 * @return ServResultadoOUT
	 * 		   HttpStatus - 201
	 */
	@PostMapping("/crearUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoBean crearUsuario(@RequestBody Usuario usuario) {
		
		logger.info("/crearUsuario ");
		logger.info("  Parametro de entrada: ");
		logger.info("    usuario: " + usuario.toString());
		
		ResultadoBean resultadoBean= new ResultadoBean();
		usuario.setFechaAlta(Utils.getFechaActual());
		usuarioService.save(usuario);
		resultadoBean.setResultado(Constantes.CONS_RESULTADO_OK);
		resultadoBean.setUsuario(usuario);
		
		return resultadoBean;
	}
	
	/**
	 * Modifica un usuario
	 *   Busca el usuario a modificar por Id
	 *   Realiza un merge de Usuario con los datos de entrada a modificar
	 *   Se modifica el usuario
	 * @param usuario
	 * @param id
	 * @return ServResultadoOUT
	 * 		   HttpStatus - 201
	 */
	@PutMapping("/modificarUsuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoBean modificarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {

		logger.info("/modificarUsuario ");
		logger.info("  Parametro de entrada: ");
		logger.info("    id: " + id);
		logger.info("    usuario: " + usuario.toString());
		
		ResultadoBean resultadoBean= new ResultadoBean();
		Usuario usuarioBD = usuarioService.findById(id);
		if(usuarioBD != null) {
			Matcher.matchUsuarioMatch(usuario, usuarioBD);
			usuario.setFechaModificacion(Utils.getFechaActual());
			usuarioService.save(usuario);
			resultadoBean.setResultado(Constantes.CONS_RESULTADO_OK);
			resultadoBean.setUsuario(usuario);
		} else {
			resultadoBean.setResultado(Constantes.CONS_RESULTADO_KO);
			resultadoBean.setCodError(ConstantesErrores.COD_ERROR_105);
		}
		return resultadoBean;
	}
	
	/**
	 * Metodo que elimina un Usuario por Id
	 * @param id
	 * 		   HttpStatus - 204
	 */
	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarUsuario(@PathVariable Integer id) {
		
		logger.info("/eliminarUsuario ");
		logger.info("  Parametro de entrada: ");
		logger.info("    id: " + id);
		
		usuarioService.deleteById(id);
	}
}