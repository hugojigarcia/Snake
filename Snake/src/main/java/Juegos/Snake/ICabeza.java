package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : ICabeza
//@@ Author :  Hugo0133


/**
 * Interfaz de la clase Cabeza para su utilizacion por parte de la clase Tablero.
 * @author Hugo0133
 */
public interface ICabeza{
	/**
	 * Devuelve true si hay algun elemento de la serpiente en la posicion pasada como parametro.
	 * @param fila Fila en la que realizar la comprobacion.
	 * @param columna Columna en la que realizar la comprobacion.
	 * @return True si hay algun elemento de la serpiente en la posicion pasada como parametro.
	 */
	public boolean comprobarPosicionOcupada(int fila, int columna);
}
