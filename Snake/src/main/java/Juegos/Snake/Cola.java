package Juegos.Snake;

public class Cola extends Fruto{
	private Cola anterior, siguiente;
	private TipoDireccion movimiento;
	
	
	public Cola(int fila, int columna, Cola anterior) {
		super(fila, columna);
		this.anterior=anterior;
		siguiente = null;
		movimiento=TipoDireccion.DERECHA;
	}
	
	public TipoDireccion getMovimiento() { return movimiento; }

	
	public boolean comprobarPosicionOcupada(int fila, int columna) {
		boolean resultado = this.getFila()==fila && this.getColumna()==columna;
		if(!resultado && siguiente!=null) resultado=siguiente.comprobarPosicionOcupada(fila, columna);
		return resultado;
	}
	
	public void aniadirCola () {
		if(siguiente!=null) siguiente.aniadirCola();
		else {
			switch(movimiento) {
				case ARRIBA: siguiente = new Cola( this.getFila()+1, this.getColumna(), this);break;
				case DERECHA: siguiente = new Cola( this.getFila(), this.getColumna()-1, this); break;
				case ABAJO: siguiente = new Cola( this.getFila()-1, this.getColumna(), this); break;
				case IZQUIERDA: siguiente = new Cola( this.getFila(), this.getColumna()+1, this); break;
			}
		}
	}
	
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
	public Cola obtenerSiguiente() { return siguiente; }
	//RELACION COLA-COLA(anterior)
	public Cola obtenerAnterior() { return anterior; }
}
