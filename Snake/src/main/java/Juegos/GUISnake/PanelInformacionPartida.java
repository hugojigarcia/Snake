package Juegos.GUISnake;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

//@@ Project : Snake
//@@ File Name : Cabeza
//@@ Author : Hugo0133


/**
 * Clase que contiene el panel de la GUI encargado de mostrar la informacion de la partida.
 * @author Hugo0133
 */
public class PanelInformacionPartida extends JPanel{
	private GUISystemSnake guiGeneral;
	private JLabel labelPuntuacion, labelMovimientosRestantes1, labelMovimientosRestantes2,
		labelTiempoEntreTurnos, labelAncho, labelAumentoMovimientos;
	
	/**
	 * Crea el panel.
	 * @param guiGeneral GUI general del juego.
	 */
	public PanelInformacionPartida(GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarPanel();
		initComponentesLabelsPartida();
		initComponentesLabelsConfiguracion();
		this.actualizarValores();
	}
	
	/**
	 * Configura el panel general de informacion.
	 */
	private void configurarPanel() {
		this.setBackground(new Color(140,140,140));
		this.setLayout(null);
	}
	
	/**
	 * Configura los textos que permiten mostrar los resultados del juego.
	 */
	private void initComponentesLabelsPartida() {
		labelPuntuacion= new JLabel();
		labelPuntuacion.setFont(new Font("Arial", Font.BOLD, 18));
		labelPuntuacion.setBounds(10,20,280,30);
		this.add(labelPuntuacion);
		
		labelMovimientosRestantes1= new JLabel("<html>MOVIMIENTOS<br>RESTANTES:<html>");
		labelMovimientosRestantes1.setFont(new Font("Arial", Font.BOLD, 18));
		labelMovimientosRestantes1.setBounds(10,55,139,40);
		this.add(labelMovimientosRestantes1);
		
		labelMovimientosRestantes2= new JLabel();
		labelMovimientosRestantes2.setFont(new Font("Arial", Font.BOLD, 18));
		labelMovimientosRestantes2.setBounds(160,60,280,30);
		this.add(labelMovimientosRestantes2);
	}
	
	/**
	 * Configura los textos que permiten mostrar los parametros del juego.
	 */
	private void initComponentesLabelsConfiguracion() {
		labelTiempoEntreTurnos= new JLabel();
		labelTiempoEntreTurnos.setFont(new Font("Arial", Font.BOLD, 18));
		labelTiempoEntreTurnos.setBounds(10,120,280,30);
		this.add(labelTiempoEntreTurnos);
		
		labelAncho= new JLabel();
		labelAncho.setFont(new Font("Arial", Font.BOLD, 18));
		labelAncho.setBounds(10,150,280,30);
		this.add(labelAncho);
		
		labelAumentoMovimientos= new JLabel();
		labelAumentoMovimientos.setFont(new Font("Arial", Font.BOLD, 18));
		labelAumentoMovimientos.setBounds(10,180,280,30);
		this.add(labelAumentoMovimientos);

	}
	
	
	//METODOS PARA ACTUALIZAR LOS VALORES
	/**
	 * Actualiza el texto encargado de mostrar la puntuacion.
	 */
	private void actualizarPuntuacion() { 
		if(guiGeneral.getJuegoSnake()!=null) {
			labelPuntuacion.setText("PUNTUACIÓN: "+guiGeneral.getJuegoSnake().getPuntuacion());
		} else labelPuntuacion.setText("PUNTUACIÓN:");
	}
	/**
	 * Actualiza el texto encargado de mostrar los movimientos restantes.
	 */
	private void actualizarMovimientosRestantes() { 
		if(guiGeneral.getJuegoSnake()!=null) {
			labelMovimientosRestantes2.setText(""+guiGeneral.getJuegoSnake().getMovimientosRestantes());
		} else labelMovimientosRestantes2.setText("");
	}
	/**
	 * Actualiza el texto encargado de mostrar el tiempo que hay entre turnos.
	 */
	private void actualizarTiempoEntreTurnos() { 
		labelTiempoEntreTurnos.setText("TIEMPO ENTRE TURNOS: "+guiGeneral.getPanelAjustes().getTiempoEntreTurnos()); 
	}
	/**
	 * Actualiza el texto encargado de mostrar el ancho del tablero.
	 */
	private void actualizarAncho() { 
		labelAncho.setText("ANCHO: "+guiGeneral.getPanelAjustes().getAncho()); 
	}
	/**
	 * Actualiza el texto encargado de mostrar el alto del tablero.
	 */
	private void actualizarAlto() { 
		labelAumentoMovimientos.setText("ALTO: "+guiGeneral.getPanelAjustes().getAlto()); 
	}
	
	/**
	 * Actualiza los textos que muestran la informacion del juego.
	 */
	public void actualizarValores() {
		this.actualizarPuntuacion();
		this.actualizarMovimientosRestantes();
		this.actualizarTiempoEntreTurnos();
		this.actualizarAncho();
		this.actualizarAlto();
	}
}
