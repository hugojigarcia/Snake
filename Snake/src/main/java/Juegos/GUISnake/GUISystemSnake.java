package Juegos.GUISnake;

import Juegos.Snake.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUISystemSnake extends JFrame{
	private JuegoSnake juegoSnake;
	private PanelAjustes panelAjustes;
	private PanelCuadricula panelCuadricula;
	private PanelInformacionPartida panelInformacionPartida;
	
	public GUISystemSnake() {
		this.juegoSnake = null;
		this.configurarVentana();
		this.configurarPanelAjustes();
		this.configurarPanelInformacionPartida();
		this.configurarPanelCuadricula(20, 30); //BORRAR
	}
	
	
	private void configurarVentana() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SNAKE");
		//this.getContentPane().setBackground(new Color(119,172,241));
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setBounds(0,0,1000,640);
        this.setLocationRelativeTo(null);
        // this.setIconImage(new ImageIcon(getClass().getResource("images/logoSnapUPM.png")).getImage() );
        this.setVisible(false);
	}
	
	private void configurarPanelInformacionPartida() {
		this.panelInformacionPartida = new PanelInformacionPartida(this);
		panelInformacionPartida.setBounds(610,17,300,226);
		getContentPane().add(panelInformacionPartida);
	}
	
	private void configurarPanelAjustes() {
		this.panelAjustes = new PanelAjustes(this);
		panelAjustes.setBounds(610,253,300,334);
		getContentPane().add(panelAjustes);
	}
	
	private void configurarPanelCuadricula(int ancho, int alto) {
		this.panelCuadricula = new PanelCuadricula(ancho, alto, this);
		panelCuadricula.setBounds(20,17,570,570);
		panelCuadricula.setVisible(true);
		getContentPane().add(panelCuadricula);
	}
	
	//METODOS PARA OBTENER SUS PANELES
	public PanelAjustes getPanelAjustes() { return panelAjustes; }
	public PanelCuadricula getPanelCuadricula() { return panelCuadricula; }
	public PanelInformacionPartida getPanelInformacionPartida() { return panelInformacionPartida; }
	

}
