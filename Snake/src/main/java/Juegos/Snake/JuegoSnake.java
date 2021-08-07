package Juegos.Snake;

//@@ Project : Snake
//@@ File Name : JuegoSnake
//@@ Author :  Hugo0133


/**
 * Clase que se encarga de gestionar el juego, es decir, realizar todas las acciones necesarias en un turno.
 * @author Hugo0133
 */
public class JuegoSnake {
	//------------------------------------ATRIBUTOS------------------------------------
	private int puntuacion, movimientosRestantes, turno, aumentoMovimientos;
	//------------------------------------ATRIBUTOS RELACIONES-------------------------
	private Tablero tablero;
	private Cabeza snake;
	
	/**
	 * Crea el juego con un tablero del tamanio indicado como parametro.
	 * @param ancho Ancho del tablero.
	 * @param alto Alto del tablero.
	 */
	public JuegoSnake(int ancho, int alto) {
		puntuacion=0;
		turno=0;
		snake = new Cabeza(Math.abs(ancho/2-1), Math.abs(alto/4-1));
		tablero = new Tablero (ancho,alto, snake);
		movimientosRestantes=this.calcularMovimientos(ancho, alto);
		aumentoMovimientos=movimientosRestantes/2;
	}
	
	/**
	 * Devuelve la puntuacion actual.
	 * @return Puntuacion actual.
	 */
	public int getPuntuacion() { return puntuacion; }
	/**
	 * Devuelve el numero de movimientos restantes.
	 * @return Numero de movimientos restantes.
	 */
	public int getMovimientosRestantes() { return movimientosRestantes; }
	/**
	 * Devuelve actual del juego.
	 * @return Turno actual.
	 */
	public int getTurno() { return turno; }
	/**
	 * Devuelve cuantos movimientos se aniaden al comerse un fruto.
	 * @return Numero de movimientos que se aniaden al comerse un fruto.
	 */
	public int getAumentoMovimientos() { return aumentoMovimientos; }
	
	
	//------------------------------------MÉTODOS------------------------------------
	private int calcularMovimientos(int ancho, int alto) {
		return (int) (ancho*alto/6.5);
	}
	
	/**
	 * Realiza todas las acciones de un turno del juego, es decir, comprobar que no se ha perdido y aumentar la puntuacion
	 * se se ha comido un fruto.
	 * @param direccion Direccion en la que moverse este turno.
	 * @return True si no se ha perdido, false en caso contrario.
	 */
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
	/**
	 * Obtiene el tablero de juego.
	 * @return Tablero de juego.
	 */
	public Tablero obtenerTablero() { return tablero; }
	/**
	 * Establece el tablero de juego.
	 * @param tablero Tablero a establecer.
	 */
	public void setTablero(Tablero tablero) { if(tablero!=null) this.tablero=tablero; }
	//RELACION JUEGOSNAKE-CABEZA
	/**
	 * Obtiene la cabeza de la serpiente.
	 * @return Cabeza de la serpiente.
	 */
	public Cabeza obtenerCabeza() { return snake; }
	/**
	 * Esblece la cabeza de la serpiente, y por lo tanto tambien el resto de esta que tiene enlazado.
	 * @param snake Cabeza de la serpiente.
	 */
	public void setCabeza(Cabeza snake) { if(snake!=null) this.snake=snake; }

}
