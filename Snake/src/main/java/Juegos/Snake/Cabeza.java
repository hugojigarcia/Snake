package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : Cabeza
//@@ Author :  Hugo


public class Cabeza extends Cola implements ICabeza{
	public Cabeza(int fila, int columna) {
		super(fila, columna);
	}

	public boolean comprobarComeCola(){
		if(this.obtenerSiguiente()!=null) return this.obtenerSiguiente().comprobarPosicionOcupada(getFila(), getColumna());
		else return false;
	}
}
