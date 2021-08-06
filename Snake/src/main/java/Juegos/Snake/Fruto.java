package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : Fruto
//@@ Author :  Hugo


public class Fruto {
	private int fila, columna;
	
	public Fruto () {
		this(0,0);
	}
	public Fruto (int fila, int columna) {
		this.setFila(fila);
		this.setColumna(columna);
	}

	public int getFila() { return fila; }
	public void setFila(int fila) { this.fila = fila; }
	public int getColumna() { return columna; }
	public void setColumna(int columna) { this.columna = columna; }
}
