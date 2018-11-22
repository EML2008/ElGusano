package pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gusano {
	private int cantidadDeEnlaces;
	private int cantidadDeComputadoras;
	private Map<Integer, List<Arista>> listaDeAdyacencia;
	private List<HoraInfeccion> horaDeInfeccion;
	private MatrizDeCostos matrizDeCostos;

	public Gusano(int cantidadDeEnlaces) {
		this.cantidadDeEnlaces = cantidadDeEnlaces;
		this.horaDeInfeccion = new ArrayList<HoraInfeccion>();
		this.listaDeAdyacencia = new HashMap<Integer, List<Arista>>();
	}

	public ArrayList<Integer> resolver() {
		this.cantidadDeComputadoras = this.listaDeAdyacencia.size();
		this.matrizDeCostos = new MatrizDeCostos(cantidadDeComputadoras);
		int costoIaJ = 0;
		int costoIaK = 0;
		int costoKaJ = 0;
		for (int i = 0; i < this.cantidadDeComputadoras; i++) {
			for (Arista a : this.listaDeAdyacencia.get(i)) {
				this.matrizDeCostos.set(i, a.getDestino().getNumero(), a.getCosto());
			}
		}

		for (int k = 0; k < this.cantidadDeComputadoras; k++) {
			for (int i = 0; i < this.cantidadDeComputadoras; i++) {
				for (int j = 0; j < this.cantidadDeComputadoras; j++) {
					if (k != i && k != j && j != i) {
						costoIaJ = this.matrizDeCostos.get(i, j);
						costoIaK = this.matrizDeCostos.get(i, k);
						costoKaJ = this.matrizDeCostos.get(k, j);
						if (costoIaJ > (costoIaK + costoKaJ)) {
							this.matrizDeCostos.set(i, j, costoIaK + costoKaJ);
						}
					}
				}
			}
		}

		int[] candidatos = new int[this.cantidadDeComputadoras];

		for (HoraInfeccion horaInfeccion : horaDeInfeccion) {
			int computadoraActual = horaInfeccion.getComputadoraInfectada().getNumero();
			for (int i = 0; i < this.cantidadDeComputadoras; i++) {
				if (this.matrizDeCostos.get(computadoraActual, i) != matrizDeCostos.INFINITO
						&& horaInfeccion.getTiempoDeInfeccion() == this.matrizDeCostos.get(computadoraActual, i)) {
					candidatos[i]++;
				}
			}
		}

		ArrayList<Integer> resultados = new ArrayList<Integer>();
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] == horaDeInfeccion.size()) {
				resultados.add(i+1);
			}
		}
		return resultados;
	}

	public void setListaDeAdyacencia(int o, int costo, int d) {
		Arista a = new Arista(new Nodo(o), new Nodo(d), costo);
		if (!this.listaDeAdyacencia.containsKey(a.getOrigen().getNumero())) {
			this.listaDeAdyacencia.put(a.getOrigen().getNumero(), new ArrayList<Arista>());
		}
		this.listaDeAdyacencia.get(a.getOrigen().getNumero()).add(a);

		if (!this.listaDeAdyacencia.containsKey(a.getDestino().getNumero())) {
			this.listaDeAdyacencia.put(a.getDestino().getNumero(), new ArrayList<Arista>());
		}
		this.listaDeAdyacencia.get(a.getDestino().getNumero()).add(
				new Arista(new Nodo(a.getDestino().getNumero()), new Nodo(a.getOrigen().getNumero()), a.getCosto()));
	}

	public void setHoraDeInfeccion(List<HoraInfeccion> horaDeInfeccion) {
		this.horaDeInfeccion = horaDeInfeccion;
	}
}
