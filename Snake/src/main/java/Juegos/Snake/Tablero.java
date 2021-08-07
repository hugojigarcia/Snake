package Juegos.Snake;

import java.util.Random;

//@@ Project : Snake
//@@ File Name : Tablero
//@@ Author :  Hugo0133


/**
 * Clase que contiene el espacio de juego, con un ancho y alto establecido, asi como el fruto, objetivo a comer de la serpiente.
 * @author Hugo0133
 */
public class Tablero {
	private int ancho, alto;
	private Fruto fruto;
	private ICabeza snake;
	private Random random;
	
	/**
	 * Crea un tablero de las dimensiones indicadas con la serpiente pasada como parametro.
	 * @param ancho Ancho del tablero.
	 * @param alto Alto del tablero.
	 * @param snake Serpiente con la que se va jugar.
	 */
	public Tablero(int ancho, int alto, ICabeza snake) {
		this.ancho = ancho>0?ancho:5;
		this.alto = alto>0?alto:5;
		this.snake = snake;
		fruto=new Fruto();
		random = new Random();
		this.generarFruto();
	}

	/**
	 * Devuelve el ancho del tablero.
	 * @return Ancho del tablero.
	 */
	public int getAncho() { return ancho; }
	/**
	 * Devuelve el alto del tablero.
	 * @return Alto del tablero.
	 */
	public int getAlto() { return alto; }
	
	
	//------------------------------------MÉTODOS------------------------------------
	/**
	 * Comprueba si las coordenadas que se pasan como parametro corrresponden con un choque con alguna pared del tablero.
	 * @param fila Fila a comprobar.
	 * @param columna Columna a comprobar.
	 * @return True si se ha chocado, false en caso contrario.
	 */
	public boolean comprobarChoquePared(int fila, int columna) {
		return fila<0 || fila>=ancho || columna<0 || columna>=alto;
	}
	
	/**
	 * Comprueba si las coordenadas que se pasan como parametro corresponden con las del fruto, es decir, si la serpiente
	 * se ha comido el fruto.
	 * @param fila Fila a comprobar.
	 * @param columna Columna a comprobar.
	 * @return True si ha comido el fruto, false en caso contrario.
	 */
	public boolean comprobarComeFruto(int fila, int columna) {
		return fila==fruto.getFila() && columna==fruto.getColumna();
	}

	/**
	 * Establece un posicion para el fruto en un sitio que no este ocupado por la serpiente.
	 */
	public void generarFruto() {
		int fila, columna;
		do {
			fila = Math.abs(random.nextInt()) % ancho;
			columna = Math.abs(random.nextInt()) % alto;
		} while (snake.comprobarPosicionOcupada(fila, columna));
		fruto.setFila(fila);
		fruto.setColumna(columna);
	}
	
	
	//RELACION TABLERO-FRUTO
	/**
	 * Devuelve el fruto con el que se esta jugando.
	 * @return Fruto con el que se esta jugando.
	 */
	public Fruto obtenerFruto() { return fruto; }
	
}
