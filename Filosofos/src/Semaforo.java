public class Semaforo {

	private int contador = 0;

	public Semaforo() {
		this.contador = 1;
	}

	public synchronized void P() {
		if (contador <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		contador--;
	}

	public synchronized void V() {
		contador++;
		notify();
	}
}