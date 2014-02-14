package com.jeco.ui.validaFormulario;

public class CampoNome extends Campo{
	public CampoNome(){
		super(new ValidadorNome());
		super.addFocusListener(this);
	}
}
