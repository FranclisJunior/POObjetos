package com.jeco;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class JECOFacadePesoTest {
	JECOFacade facade = new JECOFacade();
	

	@Test
	public void criarPeso() {
		try {
			Pesagem pesagem = new Pesagem();
			pesagem.setId(15);
			pesagem.setCodOvino("1234");
			pesagem.setData("01/02/2013");
			pesagem.setPeso(11);				
			assertTrue(facade.salvarPeso(pesagem));
			
			List<Pesagem> lPesos = facade.buscaTodosPeso();
			assertNotNull(lPesos);
			
			for(Pesagem p: lPesos){
				if(p.getCodOvino().equals("1234")){
					facade.apagarPeso(p);
					break;
				}
			}
			
		} catch (JECOException e) {
			fail(e.getMessage());
		}
		
		
	}

}
