package Juegos.GUISnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelAjustes extends JPanel implements ActionListener, ChangeListener{
	private GUISystemSnake guiGeneral;
	private JSlider barraTiempoEntreTurnos, barraAncho, barraAlto;
	private JButton botonIniciar, botonParar;
	private Thread partida;
	
	
	public PanelAjustes(GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarPanel();
		initComponentesSliders();
		initComponentesBotones();
	}
	
	private void configurarPanel() {
		this.setBackground(new Color(140,140,140));
		this.setLayout(null);
	}
	
	private void initComponentesSliders() {
		barraTiempoEntreTurnos = new JSlider(0,1000);
		barraTiempoEntreTurnos.setPaintTicks(true);
		barraTiempoEntreTurnos.setPaintLabels(true);
		barraTiempoEntreTurnos.setMajorTickSpacing(200);
		barraTiempoEntreTurnos.setValue(500);
		barraTiempoEntreTurnos.setToolTipText("Tiempo entre turnos");
		barraTiempoEntreTurnos.setBorder(BorderFactory.createTitledBorder("Tiempo entre turnos"));
		barraTiempoEntreTurnos.setBackground(new Color(200,200,200));
		barraTiempoEntreTurnos.setBounds(15,15,268,65);
		barraTiempoEntreTurnos.addChangeListener(this);
		this.add(barraTiempoEntreTurnos);
		
		barraAncho = new JSlider(2,1002);
		barraAncho.setPaintTicks(true);
		barraAncho.setPaintLabels(true);
		barraAncho.setMajorTickSpacing(200);
		barraAncho.setValue(20);
		barraAncho.setToolTipText("Ancho");
		barraAncho.setBorder(BorderFactory.createTitledBorder("Ancho"));
		barraAncho.setBackground(new Color(200,200,200));
		barraAncho.setBounds(15,95,268,65);
		barraAncho.addChangeListener(this);
		this.add(barraAncho);
		
		barraAlto = new JSlider(2,1002);
		barraAlto.setPaintTicks(true);
		barraAlto.setPaintLabels(true);
		barraAlto.setMajorTickSpacing(200);
		barraAlto.setValue(20);
		barraAlto.setToolTipText("Alto");
		barraAlto.setBorder(BorderFactory.createTitledBorder("Alto"));
		barraAlto.setBackground(new Color(200,200,200));
		barraAlto.setBounds(15,175,268,65);
		barraAlto.addChangeListener(this);
		this.add(barraAlto);
	}
	
	private void initComponentesBotones() {
		botonIniciar = new JButton("Iniciar");
		botonIniciar.setBounds(22,255,120,60);
		botonIniciar.setFont(new Font("Arial", Font.BOLD, 15));
		botonIniciar.addActionListener(this);
		this.add(botonIniciar);
		
		botonParar = new JButton("Parar");
		botonParar.setBounds(155,255,120,60);
		botonParar.setFont(new Font("Arial", Font.BOLD, 15));
		botonParar.addActionListener(this);
		botonParar.setEnabled(false);
		this.add(botonParar);

	}
	
	//METODOS PARA OBTENER LOS VALORES DE CONFIGURACION
	public int getTiempoEntreTurnos() { return barraTiempoEntreTurnos.getValue(); }
	public int getAncho() { return barraAncho.getValue(); }
	public int getAlto() { return barraAlto.getValue(); }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonIniciar) {
			clickIniciar();
		} else {
			clickParar();
		}
		
	}
	public void clickIniciar() {
		if(botonIniciar.isEnabled()) {
			botonIniciar.setEnabled(false);
			botonParar.setEnabled(true);
			barraTiempoEntreTurnos.setEnabled(false);
			barraAncho.setEnabled(false);
			barraAlto.setEnabled(false);
			//guiGeneral.prepararJuego();
			partida = new Thread(guiGeneral);
			partida.start();
		}
	}
	
	public void clickParar() {
		if(botonParar.isEnabled()) {
			botonIniciar.setEnabled(true);
			botonParar.setEnabled(false);
			barraTiempoEntreTurnos.setEnabled(true);
			barraAncho.setEnabled(true);
			barraAlto.setEnabled(true);
			partida.stop();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		guiGeneral.getPanelInformacionPartida().actualizarValores();
	}
	
}
