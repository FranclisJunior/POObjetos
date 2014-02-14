package com.jeco.ui.validaFormulario;

import java.util.StringTokenizer;

public class ValidadorData implements ValidadorCampo {

	@Override
	public boolean validar(CampoValidar campo) {
		String data = campo.getValueString();
		
		if(data.length() < 10)
			return false;
		
		
		try{
			
			int dia;
			int mes;
			int ano;
			
			StringTokenizer tokens = new StringTokenizer(data,"/");
			dia = Integer.parseInt( tokens.nextToken());
			mes = Integer.parseInt( tokens.nextToken());
			ano = Integer.parseInt( tokens.nextToken());
			
			
			
			if(dia<1 || dia >31){
				return false;
			}
			if(mes<1 || mes>12){
				return false;
			}
			if(ano <2010  ){
				return false;				
			}
			return true;				
		}catch(NumberFormatException ex){	
			return false;
		}			
	}

	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
