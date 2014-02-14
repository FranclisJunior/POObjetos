public class Impressora{ //Sera a classe sicronizada
    int qtd; //quantidade de mensagem que a impressora ira imprimir
    int contador; 


    public Impressora(int q){   
        qtd = q;
        contador = 0;
    }
    
    void imprimeMensagem(String msg){
        if (contador < qtd){
            System.out.println(msg);            
            ++contador;
        } 
        else
        	System.exit(0);
    }
}
