package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : Cabeza
//@@ Author : Hugo0133


/**
 * Clase que contiene el primer elemento de la serpiente, el unico visible directamente para el resto de clases.
 * @author Hugo0133
 */
public class Cabeza extends Cola implements ICabeza{
	/**
	 * Crea una cabeza en la posicion que se le pase como parametro.
	 * @param fila Fila en la que situar la cabeza.
	 * @param columna Columna en la que situar la cabeza.
	 */
	public Cabeza(int fila, int columna) {
		super(fila, columna);
	}

	/**
	 * Devuelve true la cabeza se ha comido su propia cola.
	 * @return True la posicion de la cabeza coincide con alguna de la cola.
	 */
	public boolean comprobarComeCola(){
		if(this.obtenerSiguiente()!=null) return this.obtenerSiguiente().comprobarPosicionOcupada(getFila(), getColumna());
		else return false;
	}
}
