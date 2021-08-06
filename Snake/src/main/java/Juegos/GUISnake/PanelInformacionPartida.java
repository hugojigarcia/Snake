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
		labelTiempoEntreTurnos, labelAncho, labelAumentoMovimientos;
	
	public PanelInformacionPartida(GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarPanel();
		initComponentesLabelsPartida();
		initComponentesLabelsConfiguracion();
		this.actualizarValores();
	}
	
	private void configurarPanel() {
		this.setBackground(new Color(140,140,140));
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
	
	private void actualizarTiempoEntreTurnos() { 
		labelTiempoEntreTurnos.setText("TIEMPO ENTRE TURNOS: "+guiGeneral.getPanelAjustes().getTiempoEntreTurnos()); 
	}
	private void actualizarAncho() { 
		labelAncho.setText("ANCHO: "+guiGeneral.getPanelAjustes().getAncho()); 
	}
	private void actualizarAlto() { 
		labelAumentoMovimientos.setText("ALTO: "+guiGeneral.getPanelAjustes().getAlto()); 
	}
	
	public void actualizarValores() {
		this.actualizarPuntuacion();
		this.actualizarMovimientosRestantes();
		this.actualizarTiempoEntreTurnos();
		this.actualizarAncho();
		this.actualizarAlto();
	}
}
