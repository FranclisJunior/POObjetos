
package com.jeco.ui.validaFormulario;

import java.util.LinkedList;
import java.util.List;

public class CampoRacaOvino extends Campo {
	
	List<CampoValidar> campos = new LinkedList<CampoValidar>() ;
	
	Campo c = new Campo();
	
	
	public CampoRacaOvino() {
		super(new ValidadorRaca());
		super.addFocusListener(this);
	}
}
