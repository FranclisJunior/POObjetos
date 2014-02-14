/**
 * 
 */
package com.jeco;

/**
 * @author Ezequiel Severiano
 *
 */
public class Factory {
		
	public static Ovino createOvino(){		
		return new Ovino();
	}
	
	public static Pesagem createPeso(){		
		return new Pesagem();
	}
	
	public static Ocorrencia createOcorrencia(){
		return new Ocorrencia();
	}

}
