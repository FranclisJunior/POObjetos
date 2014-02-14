package com.jeco.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jeco.ui.validaFormulario.CampoCodigoOvino;
import com.jeco.ui.validaFormulario.CampoData;
import com.jeco.ui.view.JanelaAddOcorrencia;

public class JanelaAddOcorrenciaTest {
	private JanelaAddOcorrencia jado;
	private CampoCodigoOvino ctCodigoOvino;
	private CampoData ctData;
	

	@Test
	public void test() {
		try{
			jado = new JanelaAddOcorrencia();
			jado.setVisible(false);
			assertNotNull(jado);
		}catch(Exception ex){
			fail("Erro por que as janelas sao instanciadas");
		}
	}
	
	@Test
	public void testeCodigoOvino(){		
		ctCodigoOvino = new CampoCodigoOvino();	
		
		//verifica se inicia o campo vazio
		assertEquals(ctCodigoOvino.getText(),"");
		
		//codigo nullo nao é aceito
		ctCodigoOvino.setText(null);
		assertFalse(ctCodigoOvino.validar());
		
		//codigo invalido
		ctCodigoOvino.setText("111");
		assertFalse(ctCodigoOvino.validar());		
		
		//codigo valido 
		ctCodigoOvino.setText("1112");
		assertTrue(ctCodigoOvino.validar());
		
	}
	
	public void testeCampoData(){		
		ctData = new CampoData();	
		
		//verifica se inicia o campo vazio
		assertEquals("",ctData.getText());
		
		//data invalida
		ctData.setText("11/48/2013");
		assertFalse(ctData.validar());
		
		//data valida
		ctData.setText("11/12/2010");
		assertTrue(ctData.validar());
	}

}
