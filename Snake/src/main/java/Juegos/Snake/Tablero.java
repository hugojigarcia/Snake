package Juegos.Snake;

import java.util.Random;

public class Tablero {
	private int ancho, alto;
	private Fruto fruto;
	private ICabeza snake;
	private Random random;
	
	public Tablero(int ancho, int alto, ICabeza snake) {
		this.ancho = ancho>0?ancho:5;
		this.alto = alto>0?alto:5;
		this.snake = snake;
		fruto=new Fruto();
		random = new Random();
		this.generarFruto();
	}

	public int getAncho() { return ancho; }
	public int getAlto() { return alto; }
	
	public boolean comprobarChoquePared(int fila, int columna) {
		return fila<0 || fila>=ancho || columna<0 || columna>=alto;
	}
	
	public boolean comprobarComeFruto(int fila, int columna) {
		return fila==fruto.getFila() && columna==fruto.getColumna();
	}

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
	public Fruto obtenerFruto() { return fruto; }
	
}
