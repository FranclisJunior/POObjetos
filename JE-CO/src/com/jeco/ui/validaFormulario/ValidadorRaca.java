
package com.jeco.ui.validaFormulario;

import java.util.List;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Raca;

public class ValidadorRaca implements ValidadorCampo {
	private JECOFacade facade = new JECOFacade();
	
	@Override
	public boolean validar(CampoValidar v) {
		try {
			if(v.getValueString().length()==0){
				return false;
			}
			
			char[] c = v.getValueString().toCharArray();		  
			for ( int i = 0; i < c.length; i++ ){  
			    // verifica se o char é um numero  
			    if (Character.isDigit( c[ i ] ) ) {			    	 
			        return false ;			         
			    }  
			}
			
			List<Raca> rcs = facade.buscaRaca();
			if(!rcs.isEmpty()){
				for(Raca rc : rcs){
					if(rc.getRacaName().equals(v.getValueString().toUpperCase())){
						return false;
					}	
				}	
			}
			
			return true;
		} catch (JECOException e) {
			return false;
		}		
	}

	@Override
	public String getValueString() {		
		return "Raça inválida";
	}

}
