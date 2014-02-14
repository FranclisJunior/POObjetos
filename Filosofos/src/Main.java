

public class Main {

	public static void main(String[] args) {

		Semaforo semaforo = new Semaforo();
		
		Filosofo filosofo1 = new Filosofo("Filósofo 1", semaforo);
		Filosofo filosofo2 = new Filosofo("Filósofo 2", semaforo);
		Filosofo filosofo3 = new Filosofo("Filósofo 3", semaforo);
		Filosofo filosofo4 = new Filosofo("Filósofo 4", semaforo);
		Filosofo filosofo5 = new Filosofo("Filósofo 5", semaforo);

		Chopstick chopstick1 = new Chopstick();
		Chopstick chopstick2 = new Chopstick();
		Chopstick chopstick3 = new Chopstick();
		Chopstick chopstick4 = new Chopstick();
		Chopstick chopstick5 = new Chopstick();

		filosofo1.setEsquerda(chopstick1);
		filosofo1.setDireita(chopstick2);
		filosofo2.setEsquerda(chopstick2);
		filosofo2.setDireita(chopstick3);
		filosofo3.setEsquerda(chopstick3);
		filosofo3.setDireita(chopstick4);
		filosofo4.setEsquerda(chopstick4);
		filosofo4.setDireita(chopstick5);
		filosofo5.setEsquerda(chopstick5);
		filosofo5.setDireita(chopstick1);
		
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
		filosofo5.start();
	}

}
