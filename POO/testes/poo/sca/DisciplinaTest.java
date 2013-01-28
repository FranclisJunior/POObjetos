package poo.sca;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

public class DisciplinaTest {
	SCAFacade testes = new SCAFacade();
	Disciplina POO, POO2;
	
	@Before
	public void setUp() throws Exception {
		POO = new Disciplina();	
		POO2 = new Disciplina();	
	}
	
	
	
	@Test
	public void testeCriarDisciplina(){
		try {
			//Teste 1 - Criar e Recuperar uma Disciplina
			POO = testes.criarDisciplina(001,"POO");
			Iterator<Disciplina> itD = testes.getDisciplinasIterator();
			Disciplina d = null;
			while(itD.hasNext()){
				Disciplina disc = itD.next();
				if(disc.getCodigo()==001 && disc.getNome().equals("POO")){
					d= disc;
				}
			}
			assertEquals(d.getCodigo(),001);
			assertEquals(d.getNome(),"POO");
			
			//Teste 2 - Tentar criar uma disciplina com o mesmo codigo
			POO2 = testes.criarDisciplina(001,"POO2");			
		} catch (SCARuntimeException e) {			
			assertEquals(e.getMessage(),"Ja existe disciplina com esse codigo");
		} catch (SCAException e) {			
			assertEquals(e.getMessage(),"Erro no arquivo");
		}
	}
	
	
	@Test
	public void testeCodigo(){
		try {
			testes.criarDisciplina(002,"poo");		
		} catch (SCARuntimeException e) {		
			assertEquals("Ja existe disciplina com esse codigo",e.getMessage());			
		} catch (SCAException e) {
			assertEquals("Erro no arquivo",e.getMessage());			
		} catch(NumberFormatException e){
			assertEquals("Codigo Invalido",e.getMessage());
		}
		
	}
}
