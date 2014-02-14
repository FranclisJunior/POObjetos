/**
 * 
 */
package com.jeco;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Test;

public class JECOFacadeTest {
	JECOFacade fac = new JECOFacade();

	@Test
	public void criarOvino() {
		Ovino ov = fac.criarOvino();
		assertNotNull(ov);
	}
}
