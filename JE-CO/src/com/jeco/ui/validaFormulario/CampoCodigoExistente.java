package com.jeco.ui.validaFormulario;

public class CampoCodigoExistente extends Campo{
	
	public CampoCodigoExistente(){
		super(new ValidadorCodigoExistente());
		super.addFocusListener(this);
	}
}
