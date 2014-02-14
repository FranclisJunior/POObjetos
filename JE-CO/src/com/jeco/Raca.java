/**
 * 
 */
package com.jeco;

/**
 * @author Ezequiel Severiano
 *
 */
public class Raca {
	
	private String racaCod;
	private String racaName;
	
	/**
	 * 
	 */
	public Raca(String racaCod, String racaName) {
		
		this.racaCod = racaCod;
		this.racaName = racaName;
		
	}
	
	public Raca(String racaName) {
		
		
		this.racaName = racaName;
		
	}
	
	public String getRacaCod() {
		return racaCod;
	}
	public void setRacaCod(String racaCod) {
		this.racaCod = racaCod;
	}
	public String getRacaName() {
		return racaName;
	}
	public void setRacaName(String racaName) {
		this.racaName = racaName;
	}
	
	
	

}
