
public class PingPongThread implements Runnable{
	private Impressora ipm;
    private String msg; 

    public PingPongThread(Impressora i, String m){
        ipm = i;
        msg = m;       
    }

    
    public void run(){
        while(true){
            synchronized (ipm){//sicroniza a impressora para permitir uma thread por vez            	
                try{
                	ipm.imprimeMensagem(msg); //imprime a mensagem da thread atual              
                	ipm.notify(); //notifica a impressora que a thread terminou sua exercuçao
                    ipm.wait(); //deixa a impressora em espera para a proxima thread                    
                }catch (InterruptedException e){               
                    break;
                }
            }
        }
    }
}


