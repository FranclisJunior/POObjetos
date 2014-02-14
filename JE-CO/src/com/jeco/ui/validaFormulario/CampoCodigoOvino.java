package com.jeco.ui.validaFormulario;

public class CampoCodigoOvino extends Campo {

	public CampoCodigoOvino() {		
		super(new ValidadorCodigoOvelha());
		super.addFocusListener(this);
	}
}
