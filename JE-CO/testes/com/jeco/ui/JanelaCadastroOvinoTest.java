package com.jeco.ui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jeco.JECOException;
import com.jeco.ui.validaFormulario.CampoCodigoGenitora;
import com.jeco.ui.validaFormulario.CampoCodigoOvino;
import com.jeco.ui.validaFormulario.CampoData;
import com.jeco.ui.validaFormulario.CampoPeso;
import com.jeco.ui.validaFormulario.CampoPreco;
import com.jeco.ui.view.JanelaCadastroOvino;

public class JanelaCadastroOvinoTest {
	private JanelaCadastroOvino jco;
	private CampoCodigoOvino ctCodigoOvino;
	private CampoCodigoGenitora ctCodigoGnt;
	private CampoData ctData;
	private CampoPeso ctPeso;
	private CampoPreco ctPreco;
	

	
	
	@Test
	public void test() {
		try{
			jco = new JanelaCadastroOvino();
			jco.setVisible(false);
			assertNotNull(jco);		
		}catch(Exception ex){
			fail("Erro por que as janelas sao instanciadas");
		}
	}
	
	@Test
	public void testeCampoCodigo(){		
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
	
	
	
	@Test	
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
	
	@Test
	public void testeCampoCodigoGnt(){	
		ctCodigoGnt = new CampoCodigoGenitora();
		
		//verifica se inicia o campo vazio
		assertEquals("",ctCodigoGnt.getText());
	
		//genitora pode ser null
		ctCodigoGnt.setText(null);
		assertTrue(ctCodigoGnt.validar());
		
		//o codigo genitora for diferente de null, tem que estar no banco de dados
		ctCodigoGnt.setText("11198");
		assertFalse(ctCodigoGnt.validar());		
		
	}
	
	@Test
	public void testeCampoPeso(){
		ctPeso = new CampoPeso();
		
		//verifica se inicia o campo vazio
		assertEquals("",ctPeso.getText());
		
		//Peso nao pode ser 0
		ctPeso.setText("0,00");
		assertFalse(ctPeso.validar());		
		
		ctPeso.setText("4,4s");
		assertFalse(ctPeso.validar());
		
		ctPeso.setText("1619");
		assertTrue(ctPeso.validar());
		
	}
	
	@Test
	public void testeCampoPreco(){
		ctPreco = new CampoPreco();
		
		assertEquals("",ctPreco.getText());
		
		ctPreco.setText("qqqq");
		assertFalse(ctPreco.validar());
		
		ctPreco.setText("445");
		assertTrue(ctPreco.validar());	
		
	}
	
}
	
	
	
	
	


