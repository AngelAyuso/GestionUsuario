package com.gestion.usuarios.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.commons.utils.Data;

public class Utils {
	
	public static String compare(String strEntrada, String strBBDD) {
		String strResult = null;
		if (Data.isValid(strEntrada)) {
			strResult = strEntrada;
		} else if (Data.isValid(strBBDD)) {
			strResult = strBBDD;
		}
		return strResult;
	}
	
	public static Number compare(Number numEntrada, Number numBBDD) {
		Number numResult = null;
		if (Data.isValid(numEntrada)) {
			numResult = numEntrada;
		} else if (Data.isValid(numBBDD)) {
			numResult = numBBDD;
		}
		return numResult;
	}
	
	public static Date compare(Date dateEntrada, Date dateBBDD) {
		Date dateResult = null;
		if (Data.isValid(dateEntrada)) {
			dateResult = dateEntrada;
		} else if (Data.isValid(dateBBDD)) {
			dateResult = dateBBDD;
		}
		return dateResult;
	}
	
	public static String getFechaActual() {
		Date date = new Date();
		//Caso 2: obtener la fecha y salida por pantalla con formato:
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}
}
