package com.jeco.ui.validaFormulario;

public class CampoCodigoGenitora extends Campo {
	public CampoCodigoGenitora(){
		super(new ValidadorCodigoGenitora());
		super.addFocusListener(this);
	}
}
