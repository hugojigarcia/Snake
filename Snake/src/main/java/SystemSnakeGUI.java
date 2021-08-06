

import java.util.Random;

import Juegos.GUISnake.GUISystemSnake;
import Juegos.Snake.*;

public class SystemSnakeGUI {
	public static void main(String[] args) {
		JuegoSnake juegoSnake = new JuegoSnake(200,20,20);
		/*Random random = new Random();
		TipoDireccion direccionAzar = TipoDireccion.DERECHA;
		while(juegoSnake.pasarTurno(direccionAzar)) {
			System.out.println("\nTURNO: "+juegoSnake.getTurno() + " / PUNTUACIÓN: "+juegoSnake.getPuntuacion());
			System.out.println("X snake: "+juegoSnake.obtenerCabeza().getPosX() + " / Y snake: "+
					juegoSnake.obtenerCabeza().getPosY());
			System.out.println("X fruto: "+juegoSnake.obtenerTablero().obtenerFruto().getPosX() + " / Y fruto: "+
					juegoSnake.obtenerTablero().obtenerFruto().getPosY() );
			
			
			switch(Math.abs(random.nextInt())%4) {
				case 0:direccionAzar=TipoDireccion.ARRIBA; break;
				case 1:direccionAzar=TipoDireccion.DERECHA; break;
				case 2:direccionAzar=TipoDireccion.ABAJO; break;
				case 3:direccionAzar=TipoDireccion.IZQUIERDA; break;
			}
		}*/
		System.out.println("INICIO DE PROGRAMA");
		GUISystemSnake gui = new GUISystemSnake();
		gui.setVisible(true);
		
	}
}
