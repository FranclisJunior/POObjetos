package com.jeco.ui.validaFormulario;

import com.jeco.JECOException;
import com.jeco.JECOFacade;

public class ValidadorCodigoOvelha implements ValidadorCampo {
	JECOFacade facade = new JECOFacade();
	

	@Override
	public boolean validar(CampoValidar campo) {
		try {
			if(campo.getValueString().length()< 4 || campo.getValueString().length()>10){
					return false;
			}		
			if (!(facade.buscaOvino(campo.getValueString().toUpperCase())== null)){				
				return false;
			}
			return true;
		} catch (JECOException e) {			
			return false;
		}
		
	}

	@Override
	public String getValueString() {		
		return null;
	}


}
