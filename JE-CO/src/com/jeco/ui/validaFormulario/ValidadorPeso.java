package com.jeco.ui.validaFormulario;

public class ValidadorPeso implements ValidadorCampo {

	@Override
	public boolean validar(CampoValidar campo) {
	
			if(campo.getValueString().equals("0,00") |campo.getValueString().length() ==0 ){
				return false;
			}
			
			return true;
		
	}

	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return null;
	}

}
