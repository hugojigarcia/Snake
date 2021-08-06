package Juegos.Snake;

public class Cabeza extends Cola implements ICabeza{
	
	public Cabeza(int fila, int columna) {
		super(fila, columna, null);
	}

	
	public boolean comprobarComeCola(){
		if(this.obtenerSiguiente()!=null) return this.obtenerSiguiente().comprobarPosicionOcupada(getFila(), getColumna());
		else return false;
	}
}
