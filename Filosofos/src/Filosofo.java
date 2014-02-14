
public class Filosofo extends Thread {

	enum Estado {
		PENSANDO, FAMINTO, COMENDO;
	}

	private String nome;
	private Estado estado;
	private Chopstick esquerda;
	private Chopstick direita;
	private Semaforo semaforo;

	public Filosofo(String nome, Semaforo semaforo) {
		super(nome);
		this.nome = nome;
		this.estado = Estado.PENSANDO;
		this.semaforo = semaforo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Chopstick getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Chopstick esquerda) {
		this.esquerda = esquerda;
	}

	public Chopstick getDireita() {
		return direita;
	}

	public void setDireita(Chopstick direita) {
		this.direita = direita;
	}

	public Semaforo getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaforo semaforo) {
		this.semaforo = semaforo;
	}

	private boolean testar() {
		if (esquerda.getEstado().equals(Chopstick.Estado.NA_MESA)
				&& direita.getEstado().equals(Chopstick.Estado.NA_MESA)) {
			return true;
		} else {
			return false;
		}
	}

	private void pegarChopsticks() {
		semaforo.P();
		if (testar()) {
			esquerda.setEstado(Chopstick.Estado.EM_USO);
			direita.setEstado(Chopstick.Estado.EM_USO);
			estado = Estado.COMENDO;
		}
		semaforo.V();
	}

	private void devolverChopsticks() {
		semaforo.P();
		esquerda.setEstado(Chopstick.Estado.NA_MESA);
		direita.setEstado(Chopstick.Estado.NA_MESA);
		semaforo.V();
	}

	private void comer() throws InterruptedException {
		if (estado.equals(Estado.COMENDO)) {
			System.out.println(nome + " está comendo.");
			Thread.sleep(2500);
			System.out.println(nome + " terminou de comer.");
		} else {
			estado = Estado.FAMINTO;
		}
	}

	private void pensar() throws InterruptedException {
		System.out.println(nome + " está pensando.");
		estado = Estado.PENSANDO;
		Thread.sleep(3000);
	}

	@Override
	public void run() {
		while (true) {
			try {
				pegarChopsticks();
				comer();
				if (estado.equals(Estado.COMENDO)) {
					devolverChopsticks();
				} else {
					System.out.println(nome + " está faminto.");
					while(estado.equals(Estado.FAMINTO)) {
						Thread.sleep(2000);
						pegarChopsticks();
						comer();
					}
					devolverChopsticks();
				}
				pensar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}