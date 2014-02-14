package com.jeco.ui.validaFormulario;

import java.util.List;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.OcorrenciaTipo;

public class ValidadorOcorrenciaTipo implements ValidadorCampo {
	private JECOFacade facade = new JECOFacade();
	
	
	@Override
	public boolean validar(CampoValidar campo) {
		try {
			if(campo.getValueString().length()==0){
				return false;
			}
			
			char[] c = campo.getValueString().toCharArray();		  
			for ( int i = 0; i < c.length; i++ ){  
			    // verifica se o char é um numero  
			    if (Character.isDigit( c[ i ] ) ) {			    	 
			        return false ;			         
			    }  
			}
			
			List<OcorrenciaTipo> ocT = facade.buscarOcorrenciasTipo();			
			if(!ocT.isEmpty()){
				for(OcorrenciaTipo oc : ocT){
					if(oc.getNome().equals(campo.getValueString().toUpperCase())){
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
		// TODO Auto-generated method stub
		return "Validador Ocorrencia";
	}

}
