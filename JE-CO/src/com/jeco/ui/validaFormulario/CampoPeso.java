package com.jeco.ui.validaFormulario;


public class CampoPeso extends Campo{
	
	String formato;
	public CampoPeso(){
		super(new ValidadorPeso());
		super.addFocusListener(this);
		this.setDocument(new MonetarioDocument());
	}
	
	
	
}
