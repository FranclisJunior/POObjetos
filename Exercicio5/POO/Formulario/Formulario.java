
package Formulario;

import Validador.Validador;
import java.util.HashMap;
import java.util.Map;

public class Formulario {
    private Map<String,Campo> campos;
    
    public Formulario(){
      campos = new  HashMap<String,Campo>();
    }
    
    public void addCampo(Campo campo){
        campos.put(campo.getId(),campo);
    }
    
    public boolean setValor(Campo campo){
    	return campo.validar();   	
    }
}
