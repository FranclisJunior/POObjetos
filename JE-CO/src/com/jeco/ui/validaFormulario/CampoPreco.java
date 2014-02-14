package com.jeco.ui.validaFormulario;

public class CampoPreco extends Campo {	
	public CampoPreco(){
		super(new ValidadorPreco());
		super.addFocusListener(this);
		this.setDocument(new MonetarioDocument());
	}

}
