package Juegos.Snake;

public class Cabeza extends Cola implements ICabeza{
	
	public Cabeza(int posX, int posY) {
		super(posX, posY, null);
	}

	
	public boolean comprobarComeCola(){
		if(this.obtenerSiguiente()!=null) return this.obtenerSiguiente().comprobarPosicionOcupada(getPosX(), getPosY());
		else return false;
	}
}
