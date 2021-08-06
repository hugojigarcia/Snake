

import java.util.Random;

import Juegos.Snake.*;

public class SystemSnakeLogico {
	public static void main(String[] args) {
		JuegoSnake juegoSnake = new JuegoSnake(200,20,20);
		Random random = new Random();
		TipoDireccion direccionAzar = TipoDireccion.DERECHA;
		while(juegoSnake.pasarTurno(direccionAzar)) {
			System.out.println("\nTURNO: "+juegoSnake.getTurno() + " / PUNTUACIÓN: "+juegoSnake.getPuntuacion());
			System.out.println("X snake: "+juegoSnake.obtenerCabeza().getFila() + " / Y snake: "+
					juegoSnake.obtenerCabeza().getColumna());
			System.out.println("X fruto: "+juegoSnake.obtenerTablero().obtenerFruto().getFila() + " / Y fruto: "+
					juegoSnake.obtenerTablero().obtenerFruto().getColumna() );
			
			
			switch(Math.abs(random.nextInt())%4) {
				case 0:direccionAzar=TipoDireccion.ARRIBA; break;
				case 1:direccionAzar=TipoDireccion.DERECHA; break;
				case 2:direccionAzar=TipoDireccion.ABAJO; break;
				case 3:direccionAzar=TipoDireccion.IZQUIERDA; break;
			}
		}
		
	}
}
