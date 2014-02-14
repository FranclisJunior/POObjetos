package com.jeco.ui.validaFormulario;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ovino;

public class ValidadorCodigoGenitora implements ValidadorCampo {	
	JECOFacade facade = new JECOFacade();
	
	@Override
	public String getValueString() {		
		return "Validador Genitora";
	}

	@Override
	public boolean validar(CampoValidar campo) {
		try {
			
			Ovino genitora =  facade.buscaOvino(campo.getValueString().toUpperCase());
			if(campo.getValueString().equals("Desconhecido") || campo.getValueString().length()==0){
				return true;			
			}
			if (genitora==null || genitora.getSexo().equals("MACHO")){				
				return false;
			}
			return true;
		} catch (JECOException e){	
			return false;	
		}
	}
	
}
