package com.jeco.ui.validaFormulario;

public class CampoOcorrenciaTipo extends Campo {
	public CampoOcorrenciaTipo(){
		super(new ValidadorOcorrenciaTipo());
		super.addFocusListener(this);
	}

}
