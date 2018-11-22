package pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoElGusano {
	public static Gusano leerArchivo(String path) throws FileNotFoundException {
		File archivo = new File(path);
		Scanner entrada = new Scanner(archivo);
		int cantidadDeEnlaces = entrada.nextInt();
		Gusano gusano = new Gusano(cantidadDeEnlaces);
		List<HoraInfeccion> horaDeInfeccion = new ArrayList<>();
		for (int i = 0; i < cantidadDeEnlaces; i++) {
			gusano.setListaDeAdyacencia(entrada.nextInt() - 1, entrada.nextInt(), entrada.nextInt() - 1);
		}
		int cantidadDeComputadorasInfectadas = entrada.nextInt();
		for (int i = 0; i < cantidadDeComputadorasInfectadas; i++) {
			horaDeInfeccion.add(new HoraInfeccion(new Nodo(entrada.nextInt() - 1), entrada.nextInt()));
		}
		entrada.close();
		gusano.setHoraDeInfeccion(horaDeInfeccion);
		return gusano;
	}

}
