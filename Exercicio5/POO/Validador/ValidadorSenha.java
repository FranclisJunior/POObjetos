
package Validador;

public class ValidadorSenha implements Validador{
    
    public boolean validador(String valor) {
      try{
           int senha = Integer.parseInt(valor);
           return true;
       }catch(NumberFormatException e){
           return false;
       }
    }

   
    
}
