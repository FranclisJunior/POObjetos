package com.jeco.ui.validaFormulario;

import java.awt.event.KeyEvent;

public class CampoData extends  Campo  {
	
	String formato;
	public CampoData() {
		super(new ValidadorData());
		addKeyListener(this);
		super.addFocusListener(this);
	}
	//verifica se os dados digitados são apenas numeros
	public void keyTyped(KeyEvent e) {
		String format ="0123456789";			
		if(this.getText().length()>9)
			e.consume();
		if(format.contains(e.getKeyChar()+"")){				
			if(this.getText().length()==2 ){
				formato=this.getText()+"/";					
				super.setText(formato);
			}
			if(this.getText().length()==5){
				formato=this.getText()+"/";
				super.setText(formato);
			}				
		}else {
			e.consume();
		}
	}
		
	
		

}
