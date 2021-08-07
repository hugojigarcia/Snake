package Juegos.GUISnake;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

//@@ Project : Snake
//@@ File Name : PanelCuadricula
//@@ Author : Hugo0133

/**
 * Clase que contiene el panel de la GUI que contiene el tablero del juego.
 * @author Hugo0133
 */
public class PanelCuadricula extends JPanel{
	private GUISystemSnake guiGeneral;
	private int ancho, alto;
	private JPanel[][] cuadrados;
	
	/**
	 * Crea el panel.
	 * @param ancho Ancho del tablero de juego.
	 * @param alto Alto del tablero de juego.
	 * @param guiGeneral GUI general del juego.
	 */
	public PanelCuadricula(int ancho, int alto, GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarCuadricula(ancho, alto);
	}

	/**
	 * Crea la cuadricula de juego.
	 * @param ancho Ancho del tablero de juego.
	 * @param alto Alto del tablero de juego.
	 */
	private void configurarCuadricula(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
		cuadrados = new JPanel[ancho][alto];
		this.setLayout(new GridLayout(ancho,alto));
		
		for(int i=0;i<ancho;i++) {
			for(int j=0;j<alto;j++) {
				cuadrados[i][j] = new JPanel();
				cuadrados[i][j].setBackground(new Color(100,200,40));
				cuadrados[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				this.add(cuadrados[i][j] );

			}
		}
	}
	
	/**
	 * Elimina todos los elementos situados en el tablero.
	 */
	public void limpiarCuadricula() {
		for(int i=0; i<ancho;i++) {
			for(int j=0; j<alto;j++) {
				cuadrados[i][j].setBackground(new Color(100,200,40));
			}
		}
	}
	
	/**
	 * Coloca un fruto en las coordenadas indicadas.
	 * @param fila Fila en la que colocar el fruto.
	 * @param columna Columna en la que colocar el fruto.
	 */
	public void marcarFruto(int fila, int columna) {
		cuadrados[fila][columna].setBackground(Color.red);
	}
	/**
	 * Coloca la cabeza de la serpiente en las coordenadas indicadas.
	 * @param fila Fila en la que colocar la cabeza de la serpiente.
	 * @param columna Columna en la que colocar la cabeza de la serpiente.
	 */
	public void marcarCabeza(int fila, int columna) {
		cuadrados[fila][columna].setBackground(new Color(0,50,255));
	}
	/**
	 * Coloca una parte de la cola de la serpiente en las coordenadas indicadas.
	 * @param fila Fila en la que colocar la parte de la cola de la serpiente.
	 * @param columna Columna en la que colocar la parte de la cola de la serpiente.
	 */
	public void marcarCola(int fila, int columna) {
		cuadrados[fila][columna].setBackground(new Color(20,40,140));
	}
	


}
