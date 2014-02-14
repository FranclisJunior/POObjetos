package com.jeco.ui.validaFormulario;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ovino;

public class ValidadorCodigoExistente implements ValidadorCampo{
	JECOFacade facade = new JECOFacade();
	
	@Override
	public boolean validar(CampoValidar campo) {
		try {
			Ovino ovino = facade.buscaOvino(campo.getValueString().toUpperCase());
			if(campo.getValueString().length()< 4 | campo.getValueString().length()>10 | campo.getValueString().length()==0){
					return false;
			}		
			if (ovino== null){				
				return false;
			}
			if(ovino.getStatus().equals("0")){
				return false;
			}
			return true;
		} catch (JECOException e) {			
			return false;
		}		
	}

	@Override
	public String getValueString() {		
		return "Validador Codigo ja existente";
	}
}
