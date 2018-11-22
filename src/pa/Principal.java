package pa;

import java.io.FileNotFoundException;

public class Principal {

	public static void main(String args[]) throws FileNotFoundException {
		Gusano gusano = ArchivoElGusano.leerArchivo("archivos/consigna.in");
		ArchivoElGusano.escribir("archivos/consigna.out", gusano.resolver());
	}
}
