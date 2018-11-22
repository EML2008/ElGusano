package pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gusano {
	private static final int INFINITO = 9999999;
	private int cantidadDeEnlaces;
	private int cantidadDeComputadoras;
	private Map<Integer, List<Arista>> listaDeAdyacencia;
	private List<HoraInfeccion> horaDeInfeccion;
	private MatrizDeCostos matrizDeCostos;

	public Gusano(int cantidadDeEnlaces) {
		this.cantidadDeEnlaces = cantidadDeEnlaces;
		this.horaDeInfeccion = new ArrayList<>();
		this.listaDeAdyacencia = new HashMap<>();
	}

	public void resolver() {
		this.cantidadDeComputadoras = this.listaDeAdyacencia.size();
		this.matrizDeCostos = new MatrizDeCostos(cantidadDeComputadoras);
		for (int i = 0; i < this.cantidadDeComputadoras; i++)// CLAVE DEL MAPA
		{
			for (Arista a : this.listaDeAdyacencia.get(i)) {
				this.matrizDeCostos.set(i, a.getDestino().getNumero(), a.getCosto());
			}
		}
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
