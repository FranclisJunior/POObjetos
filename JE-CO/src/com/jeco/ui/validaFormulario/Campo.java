package com.jeco.ui.validaFormulario;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public  class Campo extends JTextField implements CampoValidar ,KeyListener,FocusListener{
	
	private ValidadorCampo validador;	
	private static final long serialVersionUID = 1L;
	public boolean valido;
	
	public Campo() {
		
	}
	
	
	/**
	 * construtor 
	 */
	Campo(ValidadorCampo v){
		this.validador = v;	
	}
	 
	 
	@Override
	public boolean validar() {		 	
		valido = validador.validar(this);
		return valido;		
	}

	@Override
	public String getValueString() {			
		return this.getText();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {	
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {		
			
	}
	@Override
	public void keyPressed(KeyEvent e) {
			
	}	
	@Override
	public void focusGained(FocusEvent e) {
		this.setBorder(new JTextField().getBorder());			
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(!(this.validar()) ){
			this.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));				
			this.selectAll();				
		}else{
			this.setBorder(new JTextField().getBorder());
		}			
	}
}
