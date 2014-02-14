public class PingPongMain{
    public static void main(String args[]) {
    	
        Impressora ipm = new Impressora(10);
        
        Thread thread1 = new Thread(new PingPongThread(ipm, "Ping")); // cria uma thread passando um runnable
        Thread thread2 = new Thread(new PingPongThread(ipm, "Pong")); // ------------//------------       
        thread1.start(); //inicia a thread
        thread2.start(); //--------//---------
    }
}