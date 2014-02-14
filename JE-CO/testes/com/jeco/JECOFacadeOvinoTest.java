package com.jeco;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JECOFacadeOvinoTest {
	JECOFacade fac = new JECOFacade();

	@Test
	public void criarOvino() {
		try {
			Ovino ovino = fac.criarOvino();			
			ovino.setCodigo("1234");
			ovino.setData("02/03/2013");
			ovino.setCodGenitora("Desconhecido");
			ovino.setRaca("MERINO");
			ovino.setSexo("FEMEA");
			ovino.setPreco(1500.0);		
			ovino.setStatus("1");				
			assertTrue(fac.salvarOvino(ovino));
			
			
			Ovino ov = fac.buscaOvino("1234");			
			assertEquals(ov.getCodGenitora(),"Desconhecido");
			assertEquals(ov.getRaca(),"MERINO");
			assertEquals(ov.getSexo(),"FEMEA");
			assertEquals(ov.getStatus(),"1");
			assertEquals(String.valueOf(ov.getPreco()),"1500.0");
			fac.apagarOvino(ov);
		} catch (JECOException e) {
			assertEquals(e.getMessage(),"Não é posivel cadastrar ovino ");
		}
	}
		

	
	@Test
	public void editarOvino(){
		try {
			//cria o ovino,
			Ovino ovino = fac.criarOvino();			
			ovino.setCodigo("1234");
			ovino.setData("02/03/2013");
			ovino.setCodGenitora("Desconhecido");
			ovino.setRaca("MERINO");
			ovino.setSexo("FEMEA");
			ovino.setPreco(1500.0);		
			ovino.setStatus("1");				
			assertTrue(fac.salvarOvino(ovino));
			
			//Edita o ovino
			Ovino o = fac.buscaOvino("1234");			
			o.setData("15/11/2015");			
			o.setRaca("SANTA INES");
			o.setSexo("MACHO");
			o.setPreco(1505.0);		
			o.setStatus("0");				
			fac.updateOvino(o);
			
			//recupera o ovino editado
			Ovino ov = fac.buscaOvino("1234");		
			assertEquals(ov.getRaca(),"SANTA INES");
			assertEquals(ov.getData(),"15/11/2015");
			assertEquals(ov.getSexo(),"MACHO");
			assertEquals(ov.getStatus(),"0");
			assertEquals(String.valueOf(ov.getPreco()),"1505.0");	
			fac.apagarOvino(ov);
		} catch (JECOException e) {
			assertEquals(e.getMessage(),"Não é posivel atualizar ovino ");
		}		
	}
	
	
	@Test
	public void apagarOvino(){
		try {
			Ovino ov = fac.criarOvino();	
			ov.setCodigo("4321");
			ov.setCodGenitora("Desconhecido");			
			fac.salvarOvino(ov);
			
			Ovino ov2 = fac.buscaOvino("4321");			
			fac.apagarOvino(ov2);		
		} catch (JECOException e) {
			assertEquals(e.getMessage(),"erro apagar ovino: null");
		}
	}
}
