package poo.sca;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {
	
	SCAFacade testes = new SCAFacade();
	Professor prof1,prof2;
	
	@Before
	public void setUp() throws Exception{
		prof1 = new Professor();
		prof2 = new Professor();
	}
	
	@Test
	public void testeMatricula() {
		try {
			prof1 = testes.criarProfessor(1000, "Rodrigo R");
			
			Iterator<Professor> itP = testes.getProfessoresIterator();
			Professor p = null;
			while(itP.hasNext()){
				Professor professor = itP.next();
				if(professor.getMatricula()==1000 && professor.getNome().equals("Rodrigo R")){
					p=professor;
				}
			}
			assertEquals(p.getMatricula(),1000);
			assertEquals(p.getNome(),"Rodrigo R");
		} catch (SCARuntimeException e) {
			assertEquals("Ja existe professor com essa matricula",e.getMessage());
		} catch (SCAException e) {
			assertEquals(e.getMessage(),"Erro no arquivo");
		}
		
	}

}
