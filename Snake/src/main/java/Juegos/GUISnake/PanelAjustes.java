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

public class PanelAjustes extends JPanel implements ActionListener{
	private GUISystemSnake guiGeneral;
	private JSlider barraVelocidad, barraAumentoPuntuacion, barraAumentoMovimientos;
	private JButton botonIniciar, botonParar;
	private Thread partida;
	
	
	public PanelAjustes(GUISystemSnake guiGeneral) {
		this.guiGeneral = guiGeneral;
		configurarPanel();
		initComponentesSliders();
		initComponentesBotones();
	}
	
	private void configurarPanel() {
		this.setBackground(new Color(140,140,140)); //BORRAR
		//this.setBorder(BorderFactory.createLineBorder(Color.black),15); //BORRAR
		this.setLayout(null);
	}
	
	private void initComponentesSliders() {
		barraVelocidad = new JSlider(0,1000);
		barraVelocidad.setPaintTicks(true);
		barraVelocidad.setPaintLabels(true);
		barraVelocidad.setMajorTickSpacing(200);
		barraVelocidad.setValue(500);
		barraVelocidad.setToolTipText("Velocidad");
		barraVelocidad.setBorder(BorderFactory.createTitledBorder("Velocidad"));
		barraVelocidad.setBackground(new Color(200,200,200));
		barraVelocidad.setBounds(15,15,268,65);
		this.add(barraVelocidad);
		
		barraAumentoPuntuacion = new JSlider(1,101);
		barraAumentoPuntuacion.setPaintTicks(true);
		barraAumentoPuntuacion.setPaintLabels(true);
		barraAumentoPuntuacion.setMajorTickSpacing(10);
		barraAumentoPuntuacion.setValue(1);
		barraAumentoPuntuacion.setToolTipText("Aumento puntuacion");
		barraAumentoPuntuacion.setBorder(BorderFactory.createTitledBorder("Aumento puntuacion"));
		barraAumentoPuntuacion.setBackground(new Color(200,200,200));
		barraAumentoPuntuacion.setBounds(15,95,268,65);
		this.add(barraAumentoPuntuacion);
		
		barraAumentoMovimientos = new JSlider(0,1000);
		barraAumentoMovimientos.setPaintTicks(true);
		barraAumentoMovimientos.setPaintLabels(true);
		barraAumentoMovimientos.setMajorTickSpacing(200);
		barraAumentoMovimientos.setValue(100);
		barraAumentoMovimientos.setToolTipText("Aumento movimientos");
		barraAumentoMovimientos.setBorder(BorderFactory.createTitledBorder("Aumento movimientos"));
		barraAumentoMovimientos.setBackground(new Color(200,200,200));
		barraAumentoMovimientos.setBounds(15,175,268,65);
		this.add(barraAumentoMovimientos);
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
	public int getVelocidad() { return barraVelocidad.getValue(); }
	public int getAumentoPuntuacion() { return barraAumentoPuntuacion.getValue(); }
	public int getAumentoMovimientos() { return barraAumentoMovimientos.getValue(); }

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
			barraVelocidad.setEnabled(false);
			barraAumentoPuntuacion.setEnabled(false);
			barraAumentoMovimientos.setEnabled(false);
			//guiGeneral.prepararJuego();
			partida = new Thread(guiGeneral);
			partida.start();
		}
	}
	
	public void clickParar() {
		if(botonParar.isEnabled()) {
			botonIniciar.setEnabled(true);
			botonParar.setEnabled(false);
			barraVelocidad.setEnabled(true);
			barraAumentoPuntuacion.setEnabled(true);
			barraAumentoMovimientos.setEnabled(true);
			partida.stop();
		}
	}
	
}
