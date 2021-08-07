package Juegos.GUISnake;

import Juegos.Snake.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//@@ Project : Snake
//@@ File Name : GUISystemSnake
//@@ Author : Hugo0133


/**
 * Clase que contiene la Interfaz Grafica de Usuario principal del juego Snake.
 * @author Hugo0133
 */
public class GUISystemSnake extends JFrame implements KeyListener, Runnable{
	private JuegoSnake juegoSnake;
	private PanelAjustes panelAjustes;
	private PanelCuadricula panelCuadricula;
	private PanelInformacionPartida panelInformacionPartida;
	private volatile TipoDireccion direccionElegida;
	
	/**
	 * Crea la GUI.
	 */
	public GUISystemSnake() {
		this.juegoSnake = null;
		this.configurarVentana();
		this.configurarPanelAjustes();
		this.configurarPanelInformacionPartida();
		this.configurarPanelCuadricula(1,1);
		direccionElegida = TipoDireccion.DERECHA;
	}
	
	/**
	 * Configura la ventana general de la aplicacion.
	 */
	private void configurarVentana() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SNAKE");
		//this.getContentPane().setBackground(new Color(119,172,241));
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setBounds(0,0,1000,640);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage() );
        this.setVisible(false);
        this.addKeyListener(this);
        this.setFocusable(true);
	}
	
	/**
	 * Configura y situa el panel encargado de mostrar la informacion de la partida.
	 */
	private void configurarPanelInformacionPartida() {
		this.panelInformacionPartida = new PanelInformacionPartida(this);
		panelInformacionPartida.setBounds(610,17,300,226);
		this.add(panelInformacionPartida);
	}
	
	/**
	 * Configura y situa el panel que permite modificar los parametros del juego.
	 */
	private void configurarPanelAjustes() {
		this.panelAjustes = new PanelAjustes(this);
		panelAjustes.setBounds(610,253,300,334);
		this.add(panelAjustes);
	}
	
	/**
	 * Configura y situa el panel que contiene el tablero del juego.
	 * @param ancho Ancho del tablero.
	 * @param alto Alto del tablero.
	 */
	private void configurarPanelCuadricula(int ancho, int alto) {
		this.panelCuadricula = new PanelCuadricula(ancho, alto, this);
		panelCuadricula.setBounds(20,17,570,570);
		this.add(panelCuadricula);
		panelCuadricula.setVisible(true);
	}
	
	//METODOS PARA OBTENER SUS PANELES
	/**
	 * Devuelve el objeto encargado de controlar la partida.
	 * @return Controlador del juego snake.
	 */
	public JuegoSnake getJuegoSnake() { return juegoSnake; }
	/**
	 * Devuelve el panel que permite modificar los parametros del juego.
	 * @return Panel que permite modificar los parametros del juego
	 */
	public PanelAjustes getPanelAjustes() { return panelAjustes; }
	/**
	 * Devuelve el panel que contiene el tablero del juego.
	 * @return Panel que contiene el tablero del juego
	 */
	public PanelCuadricula getPanelCuadricula() { return panelCuadricula; }
	/**
	 * Devuelve el panal encargado de mostrar la informacion de la partida.
	 * @return Panal encargado de mostrar la informacion de la partida.
	 */
	public PanelInformacionPartida getPanelInformacionPartida() { return panelInformacionPartida; }
	
	//METODOS PARA JUGAR
	/**
	 * Establece todos los elementos necesarios para jugar y gestiona los turnos de la partida.
	 */
	@Override
	public void run() { //Iniciar juego
		int ancho=panelAjustes.getAncho(), alto=panelAjustes.getAlto();
		juegoSnake = new JuegoSnake(ancho, alto);
		configurarPanelCuadricula(ancho, alto);
		direccionElegida=TipoDireccion.DERECHA;
		int tiempoEntreTurnos = panelAjustes.getTiempoEntreTurnos();
	
		while(juegoSnake.pasarTurno(direccionElegida)) {
			panelInformacionPartida.actualizarValores();
			dibujar();
			try {
				Thread.sleep(tiempoEntreTurnos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		panelAjustes.clickParar();
	}
	
	/**
	 * Coloca los elementos del juego en el tablero.
	 */
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
	/**
	 * Modifica la direccion de la serpiente al pulsar una de las flechas del teclado.
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
	/**
	 * Modifica la direccion de la serpiente al pulsar una de las flechas del teclado.
	 */
	@Override
	public void keyReleased(KeyEvent e) {}
	
	/**
	 * Modifica la direccion de la serpiente al pulsar una de las flechas del teclado.
	 */
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
	
	/**
	 * Comprueba que no se este intentado modificar la direccion de la serpiente en direccion contraria a la que va, porque
	 * no se puede hacer en este juego.
	 * @param direccion Direccion a la que se pretende cambiar.
	 * @return True si se esta intentando cambiar a la direccion contraria.
	 */
	private boolean comprobarContrario(TipoDireccion direccion) {
		boolean resultado = false;
		switch(direccion) {
			case ARRIBA: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.ABAJO; break;
			case DERECHA: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.IZQUIERDA; break;
			case ABAJO: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.ARRIBA; break;
			case IZQUIERDA: resultado= juegoSnake.obtenerCabeza().getMovimiento()==TipoDireccion.DERECHA; break;
		}
		return resultado;
	}
	

}
