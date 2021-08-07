package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : Cola
//@@ Author : Hugo0133


/**
 * Clase que contiene los elementos de la serpiente que van despues de la cabeza.
 * @author Hugo0133
 */
public class Cola extends Fruto{
	private Cola siguiente;
	private TipoDireccion movimiento;
	
	/**
	 * Crea una cola en la posicion que se le pase como parametro.
	 * @param fila Fila en la que situar la cola.
	 * @param columna Columna en la que situar la cabeza.
	 */
	public Cola(int fila, int columna) {
		super(fila, columna);
		siguiente = null;
		movimiento=TipoDireccion.DERECHA;
	}
	
	/**
	 * Devuelve la direccion en que se ha movido este elemento de la serpiente en el turno anterior.
	 * @return Direccion en que se ha movido este elemento de la serpiente en el turno anterior
	 */
	public TipoDireccion getMovimiento() { return movimiento; }

	
	//------------------------------------MÉTODOS------------------------------------
	/**
	 * Devuelve true si hay algun elemento de la serpiente en la posicion pasada como parametro.
	 * @param fila Fila en la que realizar la comprobacion.
	 * @param columna Columna en la que realizar la comprobacion.
	 * @return True si hay algun elemento de la serpiente en la posicion pasada como parametro.
	 */
	public boolean comprobarPosicionOcupada(int fila, int columna) {
		boolean resultado = this.getFila()==fila && this.getColumna()==columna;
		if(!resultado && siguiente!=null) resultado=siguiente.comprobarPosicionOcupada(fila, columna);
		return resultado;
	}
	
	/**
	 * Aniade un elemento a la serpiente al final de esta.
	 */
	public void aniadirCola () {
		if(siguiente!=null) siguiente.aniadirCola();
		else {
			switch(movimiento) {
				case ARRIBA: siguiente = new Cola( this.getFila()+1, this.getColumna()); break;
				case DERECHA: siguiente = new Cola( this.getFila(), this.getColumna()-1); break;
				case ABAJO: siguiente = new Cola( this.getFila()-1, this.getColumna()); break;
				case IZQUIERDA: siguiente = new Cola( this.getFila(), this.getColumna()+1); break;
			}
		}
	}
	
	/**
	 * Mueve este elemento de la serpiente en la direccion indicada.
	 * @param direccion Direccion hacia la que moverse.
	 */
	public void mover(TipoDireccion direccion) {
		cambiarPosicion(direccion);
		TipoDireccion aux = movimiento;
		this.movimiento=direccion;
		if(siguiente!=null) this.obtenerSiguiente().mover(aux);
	}
	private void cambiarPosicion(TipoDireccion direccion) {
		switch(direccion) {
			case ARRIBA: setFila(getFila()-1); break;
			case DERECHA: setColumna(getColumna()+1); break;
			case ABAJO: setFila(getFila()+1); break;
			case IZQUIERDA: setColumna(getColumna()-1); break;
		}
	}
	
	//RELACION COLA-COLA(siguiente)
	/**
	 * Obtiene el siguiente elemento de la serpiente.
	 * @return Siguiente elemento de la serpiente.
	 */
	public Cola obtenerSiguiente() { return siguiente; }
}
