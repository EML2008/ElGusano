package pa;

public class HoraInfeccion {
	private Nodo computadoraInfectada;
	private int tiempoDeInfeccion;

	public HoraInfeccion(Nodo computadoraInfectada, int tiempoDeInfeccion) {
		this.computadoraInfectada = computadoraInfectada;
		this.tiempoDeInfeccion = tiempoDeInfeccion;
	}

	public Nodo getComputadoraInfectada() {
		return computadoraInfectada;
	}

	public int getTiempoDeInfeccion() {
		return tiempoDeInfeccion;
	}

}
