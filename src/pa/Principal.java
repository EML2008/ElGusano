package pa;

import java.io.FileNotFoundException;

public class Principal {

	public static void main(String args[]) throws FileNotFoundException {
		Gusano gusano = ArchivoElGusano.leerArchivo("archivos/consigna.in");
		gusano.resolver();
	}
}
