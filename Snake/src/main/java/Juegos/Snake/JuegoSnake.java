package Juegos.Snake;

public class JuegoSnake {
	//ATRIBUTOS
	private int puntuacion, movimientosRestantes, turno, aumentoMovimientos;
	
	//ATRIBUTOS RELACIONES
	private Tablero tablero;
	private Cabeza snake;
	
	public JuegoSnake(int ancho, int alto) {
		puntuacion=0;
		turno=0;
		snake = new Cabeza(ancho/2-1, alto/4-1);
		tablero = new Tablero (ancho,alto, snake);
		movimientosRestantes=this.calcularMovimientos(ancho, alto);
		aumentoMovimientos=this.calcularAumentoMovimientos(ancho, alto);
	}
	
	public int getPuntuacion() { return puntuacion; }
	public int getMovimientosRestantes() { return movimientosRestantes; }
	public int getTurno() { return turno; }
	public int getAumentoMovimientos() { return aumentoMovimientos; }
	
	private int calcularMovimientos(int ancho, int alto) {
		//TODO
		return 100;
	}
	private int calcularAumentoMovimientos(int ancho, int alto) {
		//TODO
		return 100;
	}
	
	public boolean pasarTurno(TipoDireccion direccion) {
		turno++;
		movimientosRestantes--;
		snake.mover(direccion);
		if(tablero.comprobarChoquePared(snake.getFila(), snake.getColumna()) ||
				snake.comprobarComeCola() || movimientosRestantes==0)
			return false;
		else {
			if( tablero.comprobarComeFruto(snake.getFila(), snake.getColumna()) ){
				puntuacion++;
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
