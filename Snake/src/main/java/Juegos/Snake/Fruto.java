package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : Fruto
//@@ Author :  Hugo0133


/**
 * Clase que contiene el elemento fruto del juego, objetivo que la serpiente tiene que comerse para aumentar la puntuacion.
 * @author Hugo0133
 */
public class Fruto {
	private int fila, columna;
	
	/**
	 * Crea un fruto en la primera fila y columna.
	 */
	public Fruto () {
		this(0,0);
	}
	/**
	 * Crea un fruto en la fila y columna indicada como parametro.
	 * @param fila Fila en la que situar el fruto.
	 * @param columna Columna en la que situar el fruto.
	 */
	public Fruto (int fila, int columna) {
		this.setFila(fila);
		this.setColumna(columna);
	}

	/**
	 * Obtiene la fila en la que esta situado el fruto.
	 * @return Fila en la que esta situado el fruto.
	 */
	public int getFila() { return fila; }
	/**
	 * Establece la fila en la que se situa el fruto.
	 * @param fila Fila en la que situar el fruto.
	 */
	public void setFila(int fila) { this.fila = fila; }
	/**
	 * Obtiene la columna en la que esta situado el fruto.
	 * @return Columna en la que esta situado el fruto.
	 */
	public int getColumna() { return columna; }
	/**
	 * Establece la columna en la que se situa el fruto.
	 * @param columna Columna en la que situar el fruto.
	 */
	public void setColumna(int columna) { this.columna = columna; }
}
