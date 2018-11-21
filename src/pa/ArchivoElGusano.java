package pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchivoElGusano {
	public static Gusano leerArchivo(String path) throws FileNotFoundException {
		File archivo = new File(path);
		Scanner entrada = new Scanner(archivo);
		int cantidadDeComputadoras = entrada.nextInt();
		for (int i = 0; i < cantidadDeComputadoras; i++) {
			
		}
		return null;
	}

}
