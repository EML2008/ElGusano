package pa;

public class Arista {
	private Nodo nodoOrigen;
	private Nodo nodoDestino;
	private int costo;

	public Arista(Nodo nodoOrigen, Nodo nodoDestino, int costo) {
		this.nodoOrigen = nodoOrigen;
		this.nodoDestino = nodoDestino;
		this.costo = costo;
	}

	public Nodo getOrigen() {
		return nodoOrigen;
	}

	public Nodo getDestino() {
		return nodoDestino;
	}

	public int getCosto() {
		return costo;
	}
}
