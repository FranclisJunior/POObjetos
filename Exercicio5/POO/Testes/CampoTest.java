package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Validador.ValidadorNome;

import Formulario.Campo;

public class CampoTest {

	@Test
	public void testValidadorTexto() {
		Campo c = new Campo("nome","Nome completo:", new ValidadorNome());
		
		c.setValor(null);
		assertFalse(c.validar());

		c.setValor("");
		assertFalse(c.validar());

		c.setValor("abcde");
		assertTrue(c.validar());

		c.setValor("abcdeshhhhhhhhhhhhhhhhhhhhhASSSSssssssssssssssssssssssssssssssssssssssasasa");
		assertFalse(c.validar());
	}
}
