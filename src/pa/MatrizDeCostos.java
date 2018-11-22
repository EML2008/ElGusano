package pa;

import java.util.Arrays;

public class MatrizDeCostos {
	private int[][] matriz;
	private int cantidadDeNodos;
	public static final int INFINITO = 9999999;
	
	public MatrizDeCostos(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
		this.matriz = new int[cantidadDeNodos][];
		for (int i = 0; i < cantidadDeNodos; i++) {
			matriz[i] = new int[i];
			Arrays.fill(matriz[i], MatrizDeCostos.INFINITO);
		}
	}

	public void set(int fila, int columna, int costo) {
		if (columna == fila) {
			this.matriz[columna][columna] = 0;
			return;
		}
		if (columna > fila) {
			this.matriz[columna][fila] = costo;
			return;
		}
		this.matriz[fila][columna] = costo;
	}

	public int get(int fila, int columna) {
		if (columna > fila)
			return this.matriz[columna][fila];
		return this.matriz[fila][columna];
	}

	public int getCantidadDeNodos() {
		return cantidadDeNodos;
	}
}
