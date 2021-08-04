package Juegos.GUISnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class PanelInformacionPartida extends JPanel{
	private GUISystemSnake guiGeneral;
	private JLabel labelPuntuacion, labelMovimientosRestantes1, labelMovimientosRestantes2,
		labelVelocidad, labelAumentoPuntuacion, labelAumentoMovimientos;
	
	public PanelInformacionPartida(GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarPanel();
		initComponentesLabelsPartida();
		initComponentesLabelsConfiguracion();
		this.actualizarValores();
	}
	
	private void configurarPanel() {
		this.setBackground(new Color(140,140,140)); //BORRAR
		//this.setBorder(BorderFactory.createLineBorder(Color.black),15); //BORRAR
		this.setLayout(null);
	}
	
	
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
	
	private void initComponentesLabelsConfiguracion() {
		labelVelocidad= new JLabel();
		labelVelocidad.setFont(new Font("Arial", Font.BOLD, 18));
		labelVelocidad.setBounds(10,120,280,30);
		this.add(labelVelocidad);
		
		labelAumentoPuntuacion= new JLabel();
		labelAumentoPuntuacion.setFont(new Font("Arial", Font.BOLD, 18));
		labelAumentoPuntuacion.setBounds(10,150,280,30);
		this.add(labelAumentoPuntuacion);
		
		labelAumentoMovimientos= new JLabel();
		labelAumentoMovimientos.setFont(new Font("Arial", Font.BOLD, 18));
		labelAumentoMovimientos.setBounds(10,180,280,30);
		this.add(labelAumentoMovimientos);

	}
	
	
	//METODOS PARA ACTUALIZAR LOS VALORES
	private void actualizarPuntuacion() { 
		if(guiGeneral.getJuegoSnake()!=null) {
			labelPuntuacion.setText("PUNTUACIÓN: "+guiGeneral.getJuegoSnake().getPuntuacion());
		} else labelPuntuacion.setText("PUNTUACIÓN:");
	}
	
	private void actualizarMovimientosRestantes() { 
		if(guiGeneral.getJuegoSnake()!=null) {
			labelMovimientosRestantes2.setText(""+guiGeneral.getJuegoSnake().getMovimientosRestantes());
		} else labelMovimientosRestantes2.setText("");
	}
	
	private void actualizarVelocidad() { 
		labelVelocidad.setText("VELOCIDAD: "+guiGeneral.getPanelAjustes().getVelocidad()); 
	}
	private void actualizarAumentoPuntuacion() { 
		labelAumentoPuntuacion.setText("AUMENTO PUNTUACIÓN: "+guiGeneral.getPanelAjustes().getAumentoPuntuacion()); 
	}
	private void actualizarAumentoMovimientos() { 
		labelAumentoMovimientos.setText("AUMENTO MOVIMIENTOS: "+guiGeneral.getPanelAjustes().getAumentoMovimientos()); 
	}
	
	public void actualizarValores() {
		this.actualizarPuntuacion();
		this.actualizarMovimientosRestantes();
		this.actualizarVelocidad();
		this.actualizarAumentoPuntuacion();
		this.actualizarAumentoMovimientos();
	}
}
