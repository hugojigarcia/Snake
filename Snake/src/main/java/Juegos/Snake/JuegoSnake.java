package Juegos.Snake;

public class JuegoSnake {
	//ATRIBUTOS
	private double velocidad;
	private int puntuacion;
	private int movimientosRestantes;
	private int turno;
	//ATRIBUTOS RELACIONES
	private Tablero tablero;
	private Cabeza snake;
	
	public JuegoSnake(double velocidad, int movimientosRestantes, int ancho, int alto) {
		this.setVelocidad(velocidad);
		this.setMovimientosRestantes(movimientosRestantes);
		puntuacion=0;
		turno=0;
		snake = new Cabeza(ancho/2, alto/4);
		tablero = new Tablero (ancho,alto, snake);
	}
	
	public double getVelocidad() { return velocidad; }
	public void setVelocidad(double velocidad) { this.velocidad=velocidad>0?velocidad:0; }
	public int getMovimientosRestantes() { return movimientosRestantes; }
	public void setMovimientosRestantes(int movimientosRestantes) { 
		this.movimientosRestantes=movimientosRestantes>0?movimientosRestantes:0;
	}
	public int getPuntuacion() { return puntuacion; }
	public int getTurno() { return turno; }
	
	public boolean pasarTurno(TipoDireccion direccion) {
		turno++;
		snake.mover(direccion);
		if( tablero.comprobarComeFruto(snake.getPosX(), snake.getPosY()) ){
			puntuacion++;
			tablero.generarFruto();
		}
		return !(tablero.comprobarChoquePared(snake.getPosX(), snake.getPosY()) ||
				snake.comprobarComeCola());
	}
	
	
	//RELACION JUEGOSNAKE-TABLERO
	public Tablero obtenerTablero() { return tablero; }
	public void setTablero(Tablero tablero) { if(tablero!=null) this.tablero=tablero; }
	//RELACION JUEGOSNAKE-CABEZA
	public Cabeza obtenerCabeza() { return snake; }
	public void setCabeza(Cabeza snake) { if(snake!=null) this.snake=snake; }

}
