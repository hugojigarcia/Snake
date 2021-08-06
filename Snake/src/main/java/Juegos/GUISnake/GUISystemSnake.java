package Juegos.GUISnake;

import Juegos.Snake.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUISystemSnake extends JFrame implements KeyListener, Runnable{
	private JuegoSnake juegoSnake;
	private PanelAjustes panelAjustes;
	private PanelCuadricula panelCuadricula;
	private PanelInformacionPartida panelInformacionPartida;
	private volatile TipoDireccion direccionElegida;
	
	public GUISystemSnake() {
		this.juegoSnake = null;
		this.configurarVentana();
		this.configurarPanelAjustes();
		this.configurarPanelInformacionPartida();
		this.configurarPanelCuadricula(1,1);
		direccionElegida = TipoDireccion.DERECHA;
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
        this.addKeyListener(this);
        this.setFocusable(true);
	}
	
	private void configurarPanelInformacionPartida() {
		this.panelInformacionPartida = new PanelInformacionPartida(this);
		panelInformacionPartida.setBounds(610,17,300,226);
		this.add(panelInformacionPartida);
	}
	
	private void configurarPanelAjustes() {
		this.panelAjustes = new PanelAjustes(this);
		panelAjustes.setBounds(610,253,300,334);
		this.add(panelAjustes);
	}
	
	private void configurarPanelCuadricula(int ancho, int alto) {
		this.panelCuadricula = new PanelCuadricula(ancho, alto, this);
		panelCuadricula.setBounds(20,17,570,570);
		this.add(panelCuadricula);
		panelCuadricula.setVisible(true);
	}
	
	//METODOS PARA OBTENER SUS PANELES
	public JuegoSnake getJuegoSnake() { return juegoSnake; }
	public PanelAjustes getPanelAjustes() { return panelAjustes; }
	public PanelCuadricula getPanelCuadricula() { return panelCuadricula; }
	public PanelInformacionPartida getPanelInformacionPartida() { return panelInformacionPartida; }
	
	//METODOS PARA JUGAR
	public void prepararJuego() {
		int ancho =20, alto=20;
		juegoSnake = new JuegoSnake(200, ancho, alto);
		configurarPanelCuadricula(ancho, alto);
	}
	
	@Override
	public void run() { //Iniciar juego
		int ancho =20, alto=20;
		juegoSnake = new JuegoSnake(200, ancho, alto);
		configurarPanelCuadricula(ancho, alto);
		direccionElegida=TipoDireccion.DERECHA;
		int velocidad = panelAjustes.getVelocidad();
	
		while(juegoSnake.pasarTurno(direccionElegida)) {
			panelInformacionPartida.actualizarValores();
			dibujar();
			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		panelAjustes.clickParar();
	}
	
	private void dibujar() {
		panelCuadricula.limpiarCuadricula();
		panelCuadricula.marcarFruto(juegoSnake.obtenerTablero().obtenerFruto().getFila(), 
				juegoSnake.obtenerTablero().obtenerFruto().getColumna());
		Cola elementoSerpiente = juegoSnake.obtenerCabeza();
		panelCuadricula.marcarCabeza(elementoSerpiente.getFila(), elementoSerpiente.getColumna());
		while(elementoSerpiente.obtenerSiguiente()!=null) {
			elementoSerpiente=elementoSerpiente.obtenerSiguiente();
			panelCuadricula.marcarCola(elementoSerpiente.getFila(), elementoSerpiente.getColumna());
		}
	}


	
	//EVENTOS
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		TipoDireccion aux = null;
		switch(e.getExtendedKeyCode()) {
			case 38:aux=TipoDireccion.ARRIBA; break;
			case 39:aux=TipoDireccion.DERECHA; break;
			case 40:aux=TipoDireccion.ABAJO; break;
			case 37:aux=TipoDireccion.IZQUIERDA; break;
		}
		if(!comprobarContrario(aux)) {
			direccionElegida=aux;
		}
	}
	
	private boolean comprobarContrario(TipoDireccion aux) {
		boolean resultado = false;
		switch(aux) {
			case ARRIBA: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.ABAJO; break;
			case DERECHA: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.IZQUIERDA; break;
			case ABAJO: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.ARRIBA; break;
			case IZQUIERDA: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.DERECHA; break;
		}
		return resultado;
	}
	

}
