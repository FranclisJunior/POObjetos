package com.jeco;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class JECOFacadeOcorrenciaTest {
	JECOFacade facade =new JECOFacade();

	@Test
	public void testeOcorrencia(){
		try {
			Ocorrencia oc = facade.criarOcorrencia();
			oc.setCodigoOvino("1234");
			oc.setCusto(187);
			oc.setDescricao("abc");
			oc.setData("01/05/2012");
			facade.salvarOcorrencia(oc);
			
			List<Ocorrencia> lOC = facade.buscarOcorrencias();
			assertNotNull(lOC);
			for(Ocorrencia o : lOC){
				if(o.getCodigoOvino().equals("1234")){
					facade.apagarOcorrencia(o);
					break;
				}
			}			
		} catch (JECOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testeOcorrenciaTipo(){
		try {
			OcorrenciaTipo ocT = new OcorrenciaTipo();
			ocT.setNome("TIRO");		
			facade.salvarOcorrenciaTipo(ocT);
			
			List<OcorrenciaTipo> lOCT = facade.buscarOcorrenciasTipo();
			assertNotNull(lOCT);
			
			for(OcorrenciaTipo oct : lOCT){
				if(oct.getNome().equals("TIRO")){
					facade.apagarOcorrenciaTipo(oct);
					break;
				}
			}
		} catch (JECOException e) {
			fail(e.getMessage());
		}
	}

}
