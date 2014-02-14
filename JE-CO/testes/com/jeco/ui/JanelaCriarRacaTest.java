package com.jeco.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jeco.ui.validaFormulario.CampoRacaOvino;
import com.jeco.ui.view.JanelaCriarRaca;

public class JanelaCriarRacaTest {
	private JanelaCriarRaca jcr;
	private CampoRacaOvino ctRaca;
	

	@Test
	public void test() {
		try{
			jcr = new JanelaCriarRaca();
			jcr.setVisible(false);		
			assertNotNull(jcr);
		}catch(Exception ex){
			fail("Erro por que as janelas sao instanciadas");
		}
	}
	
	@Test
	public void testeNomeRaca(){
		ctRaca = new CampoRacaOvino();
		
		assertEquals("", ctRaca.getText());
		
		ctRaca.setText("14dsM");
		assertFalse(ctRaca.validar());
		
		ctRaca.setText(null);
		assertFalse(ctRaca.validar());
		
		ctRaca.setText("Santa Iness");
		assertTrue(ctRaca.validar());
	}

}
