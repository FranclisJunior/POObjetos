
package Validador;


public class ValidadorNome implements Validador{  
   
    public boolean validador(String valor) {
        if(valor==null || valor=="" || valor.length()>=40){
            return false;
        }
        return true;
    }
    
}
