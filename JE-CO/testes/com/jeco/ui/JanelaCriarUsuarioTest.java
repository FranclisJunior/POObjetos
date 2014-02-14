package com.jeco.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jeco.ui.validaFormulario.CampoNome;
import com.jeco.ui.view.JanelaCriarUsuario;

public class JanelaCriarUsuarioTest {
	private JanelaCriarUsuario jcu;
	private CampoNome ctNome;
	

	@Test
	public void test() {
		try{
			jcu = new JanelaCriarUsuario();
			jcu.setVisible(false);		
			assertNotNull(jcu);
		}catch(Exception ex){
			fail("Erro por que as janelas sao instanciadas");
		}
	}
	
	@Test
	public void testeNomeUsuario(){
		ctNome = new CampoNome();
		
		assertEquals("", ctNome.getText());
		
		ctNome.setText(null);
		assertFalse(ctNome.validar());
		
		ctNome.setText("Junior");
		assertTrue(ctNome.validar());	
	}

}
