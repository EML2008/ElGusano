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

	public Gusano(int cantidadDeEnlaces) {
		this.cantidadDeEnlaces = cantidadDeEnlaces;
		this.horaDeInfeccion = new ArrayList<HoraInfeccion>();
		this.listaDeAdyacencia = new HashMap<Integer, List<Arista>>();
	}

	public void resolver() {
		
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
