package com.jeco.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jeco.ui.validaFormulario.CampoOcorrenciaTipo;
import com.jeco.ui.view.JanelaCriarOcorrenciaTipo;

public class JanelaCriarOcorrenciaTipoTest {
	private JanelaCriarOcorrenciaTipo jcot;
	private CampoOcorrenciaTipo ctOcorrencia;
	

	@Test
	public void test() {
		jcot = new JanelaCriarOcorrenciaTipo();
		jcot.setVisible(false);
		assertNotNull(jcot);
	}
	
	@Test
	public void testeNomeOcorrencia(){
		ctOcorrencia = new CampoOcorrenciaTipo();
		
		assertEquals("",ctOcorrencia.getText());
		
		ctOcorrencia.setText("4545");
		assertFalse(ctOcorrencia.validar());
		
		ctOcorrencia.setText(null);
		assertFalse(ctOcorrencia.validar());
		
		ctOcorrencia.setText("Doença");
		assertTrue(ctOcorrencia.validar());
		
	}
}
