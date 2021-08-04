package Juegos.GUISnake;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelCuadricula extends JPanel{
	private GUISystemSnake guiGeneral;
	private int ancho, alto;
	private JPanel[][] cuadrados;
	
	
	public PanelCuadricula(int ancho, int alto, GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarPanel();
		configurarCuadricula(ancho, alto);
	}
	
	private void configurarPanel() {
		//this.setBackground(Color.black); //BORRAR
		//this.setBorder(BorderFactory.createLineBorder(Color.black),15); //BORRAR

	}
	
	private void configurarCuadricula(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
		cuadrados = new JPanel[ancho][alto];
		this.setLayout(new GridLayout(ancho,alto));
		
		for(int i=0;i<ancho;i++) {
			for(int j=0;j<ancho;j++) {
				cuadrados[i][j] = new JPanel();
				cuadrados[i][j].setBackground(new Color(100,200,40));
				cuadrados[i][j].setBorder(BorderFactory.createLineBorder(Color.black)); //BORRAR
				this.add(cuadrados[i][j] );

			}
		}
	}
	
	public void limpiarCuadricula() {
		for(int i=0; i<ancho;i++) {
			for(int j=0; j<alto;j++) {
				cuadrados[i][j].setBackground(new Color(100,200,40));
			}
		}
	}
	
	public void marcarFruto(int x, int y) {
		cuadrados[x][y].setBackground(Color.red);
	}
	public void marcarCabeza(int x, int y) {
		cuadrados[x][y].setBackground(new Color(0,50,255));
	}
	public void marcarCola(int x, int y) {
		cuadrados[x][y].setBackground(new Color(20,40,140));
	}
	


}
