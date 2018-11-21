package pa;

public class MatrizDeCostos {
	private int[][] matriz;
	private int cantidadDeNodos;

	public MatrizDeCostos(int cantidadDeNodos) {
		this.matriz = new int[cantidadDeNodos][];
		for (int i = 0; i < cantidadDeNodos; i++) {
			matriz[i] = new int[i];
		}
	}
	
	public void set(int fila,int columna,int costo)
	{
		if(columna == fila)
		{
			this.matriz[columna][columna] = 0;
			return;
		}
		if(columna>fila)
		{
			this.matriz[columna][fila] = costo;
			return;
		}
		this.matriz[fila][columna] = costo;
	}
	
	public int get(int n1,int n2)
	{
		
	}
}
