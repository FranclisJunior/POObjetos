package com.jeco.ui.validaFormulario;

import com.jeco.JECOFacade;

public class ValidadorNome implements ValidadorCampo{
	private JECOFacade facade;

	@Override
	public boolean validar(CampoValidar campo) {	
		if(campo.getValueString().length()==0){
			return false;
		}
		return true;
//		try {			
//			List<Usuario> users = facade.buscarUsuarios();
//			if(!(users.isEmpty())){
//				for(Usuario user : users){
//					if(user.getNome().equals(campo.getValueString())){
//						return false;
//					}
//				}
//			}		
//			
//		return true;
//		} catch (JECOException e) {
//			return false;
//		}
	
	}

	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return "Validador Nome";
	}

}
