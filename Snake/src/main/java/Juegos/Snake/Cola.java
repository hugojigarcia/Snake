package Juegos.Snake;

public class Cola extends Fruto{
	private Cola anterior, siguiente;
	private TipoDireccion movimiento;
	
	
	public Cola(int posX, int posY, Cola anterior) {
		super(posX, posY);
		this.anterior=anterior;
		siguiente = null;
		movimiento=TipoDireccion.DERECHA;
	}
	
	public TipoDireccion getMovimiento() { return movimiento; }

	
	public boolean comprobarPosicionOcupada(int x, int y) {
		boolean resultado = this.getPosX()==x && this.getPosY()==y;
		if(!resultado && siguiente!=null) resultado=siguiente.comprobarPosicionOcupada(x, y);
		return resultado;
	}
	
	public void aniadirCola () {
		if(siguiente!=null) siguiente.aniadirCola();
		else {
			/*switch(movimiento) {
			case ARRIBA: siguiente = new Cola( this.getPosX()-1, this.getPosY(), this);break;
			case DERECHA: siguiente = new Cola( this.getPosX(), this.getPosY()+1, this); break;
			case ABAJO: siguiente = new Cola( this.getPosX()+1, this.getPosY(), this); break;
			case IZQUIERDA: siguiente = new Cola( this.getPosX(), this.getPosY()-1, this); break;
			}*/ //BORRAR
			switch(movimiento) {
			case ARRIBA: siguiente = new Cola( this.getPosX()+1, this.getPosY(), this);break;
			case DERECHA: siguiente = new Cola( this.getPosX(), this.getPosY()-1, this); break;
			case ABAJO: siguiente = new Cola( this.getPosX()-1, this.getPosY(), this); break;
			case IZQUIERDA: siguiente = new Cola( this.getPosX(), this.getPosY()+1, this); break;
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
			case ARRIBA: setPosX(getPosX()-1); break;
			case DERECHA: setPosY(getPosY()+1); break;
			case ABAJO: setPosX(getPosX()+1); break;
			case IZQUIERDA: setPosY(getPosY()-1); break;
		}
	}
	
	//RELACION COLA-COLA(siguiete)
	public Cola obtenerSiguiente() { return siguiente; }
	//RELACION COLA-COLA(anterior)
	public Cola obtenerAnterior() { return anterior; }
}
