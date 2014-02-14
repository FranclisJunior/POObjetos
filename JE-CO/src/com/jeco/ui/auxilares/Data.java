/**
 * 
 */
package com.jeco.ui.auxilares;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.jeco.ui.validaFormulario.Campo;
import com.jeco.ui.validaFormulario.CampoValidar;

/**
 * @author Ezequiel Severiano
 *
 */
public class Data {
	

	
	
	
	public static String atual(){
		 Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
		// cria a string  
		return formatador.format(data); 
	}

}
