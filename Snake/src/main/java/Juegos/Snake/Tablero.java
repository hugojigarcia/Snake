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
	
	public boolean comprobarChoquePared(int x, int y) {
		return x<0 || x>=ancho || y<0 || y>=alto;
	}
	
	public boolean comprobarComeFruto(int x, int y) {
		return x==fruto.getPosX() && y==fruto.getPosY();
	}

	public void generarFruto() {
		int posX, posY;
		do {
			posX = Math.abs(random.nextInt()) % ancho;
			posY = Math.abs(random.nextInt()) % alto;
		} while (snake.comprobarPosicionOcupada(posX, posY));
		fruto.setPosX(posX);
		fruto.setPosY(posY);
	}
	
	//RELACION TABLERO-FRUTO
	public Fruto obtenerFruto() { return fruto; }
	
}
