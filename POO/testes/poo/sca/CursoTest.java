package poo.sca;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class CursoTest {

	SCAFacade testes = new SCAFacade();
	Curso curso1,curso2;
	
	@Before
	public void setUp() throws Exception{		
		curso2 = new Curso();
	}
	
	@Test
	public void testeMatricula() {
		try {
			curso1 = testes.criarCurso(001,"SI");
			
			Iterator<Curso> itC = testes.getCursosIterator();
			Curso c = null;
			while(itC.hasNext()){
				Curso curso = itC.next();
				if(curso.getCodigo()==001 && curso.getNome().equals("SI")){
					c=curso;
				}
			}
			assertEquals(c.getCodigo(),001);
			assertEquals(c.getNome(),"SI");
		} catch (SCARuntimeException e) {
			assertEquals("Ja existe Curso com esse codigo",e.getMessage());
		} catch (SCAException e) {
			assertEquals(e.getMessage(),"Erro no arquivo");
		}
		
	}

}