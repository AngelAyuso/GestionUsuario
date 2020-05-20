package com.gestion.usuarios.config;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gestion.usuarios.generics.ServResultadoOUT;
import com.gestion.usuarios.utils.Constantes;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ServResultadoOUT handleEntityNotFound(EntityNotFoundException ex){
		
		ServResultadoOUT serResult = new ServResultadoOUT();
		serResult.setResultado(Constantes.CONS_RESULTADO_KO);
		serResult.setCodError(HttpStatus.NOT_FOUND.toString());
		
		return serResult;
	}
	
}
