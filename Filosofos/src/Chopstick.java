public class Chopstick {

	enum Estado {
		EM_USO, NA_MESA;
	}

	private Estado estado;

	public Chopstick() {
		this.estado = Estado.NA_MESA;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
