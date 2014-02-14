package com.jeco.ui.validaFormulario;

public class ValidadorPreco implements ValidadorCampo {


	@Override
	public boolean validar(CampoValidar campo) {
		try{
			float preco = Float.parseFloat(campo.getValueString().replace(",",""));
			
			if(campo.getValueString().length()>12){
				return false;
			}						
			return true;
		}catch(NumberFormatException e){
			return false;
		}
		
	}

	@Override
	public String getValueString() {		
		return null;
	}


}
