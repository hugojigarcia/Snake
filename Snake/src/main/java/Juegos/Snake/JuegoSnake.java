package Juegos.Snake;

public class JuegoSnake {
	//ATRIBUTOS
	private int puntuacion, movimientosRestantes, turno, aumentoPuntuacion, aumentoMovimientos;
	
	//ATRIBUTOS RELACIONES
	private Tablero tablero;
	private Cabeza snake;
	
	public JuegoSnake(int movimientosRestantes, int ancho, int alto) {
		this.movimientosRestantes=movimientosRestantes>0?movimientosRestantes:0;
		puntuacion=0;
		turno=0;
		snake = new Cabeza(ancho/4, alto/2);
		tablero = new Tablero (ancho,alto, snake);
		aumentoPuntuacion=1;
		aumentoMovimientos=100;
	}
	
	public int getPuntuacion() { return puntuacion; }
	public int getMovimientosRestantes() { return movimientosRestantes; }
	public int getTurno() { return turno; }
	public int getAumentoPuntuacion() { return aumentoPuntuacion; }
	public void setAumentoPuntuacion(int aumentoPuntuacion) {if(aumentoPuntuacion>0) this.aumentoPuntuacion=aumentoPuntuacion;}
	public int getAumentoMovimientos() { return aumentoMovimientos; }
	public void setAumentoMovimientos(int aumentoMovimientos) { 
		if(aumentoMovimientos>0) this.aumentoMovimientos=aumentoMovimientos;
	}
	
	public boolean pasarTurno(TipoDireccion direccion) {
		turno++;
		movimientosRestantes--;
		snake.mover(direccion);
		if(tablero.comprobarChoquePared(snake.getPosX(), snake.getPosY()) ||
				snake.comprobarComeCola() || movimientosRestantes==0)
			return false;
		else {
			if( tablero.comprobarComeFruto(snake.getPosX(), snake.getPosY()) ){
				puntuacion+=aumentoPuntuacion;
				tablero.generarFruto();
				movimientosRestantes+=aumentoMovimientos;
				snake.aniadirCola();
			}
			return true;
		}
	}
	
	
	//RELACION JUEGOSNAKE-TABLERO
	public Tablero obtenerTablero() { return tablero; }
	public void setTablero(Tablero tablero) { if(tablero!=null) this.tablero=tablero; }
	//RELACION JUEGOSNAKE-CABEZA
	public Cabeza obtenerCabeza() { return snake; }
	public void setCabeza(Cabeza snake) { if(snake!=null) this.snake=snake; }

}
