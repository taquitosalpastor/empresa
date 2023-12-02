package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class BarraDeCarga {

	public JFrame frmBarrraDeProgreso;
	private JProgressBar progressBar;
	private JButton btnStart;
	String  Nombre="";
	String Usuario;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraDeCarga window = new BarraDeCarga();
					window.frmBarrraDeProgreso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BarraDeCarga(String usuario) {
		initialize();
		this.Usuario=usuario;
		Start();
	}

	public void Start() {
		Thread hilo=new Thread(new Runnable() {
			

			@Override
			public void run() {
				for(int i=0;i<=100;i++) {
					progressBar.setValue(i);
					try {
						Thread.sleep(25);
					}catch (InterruptedException e) {
						e.printStackTrace();
				}
					if(i==100) {
						Frmc FRC=new Frmc(Usuario);
						FRC.frmFarmaciaUsuario.show(true);
						frmBarrraDeProgreso.show(false);
					}
				}
				
			}
			
		});
		hilo.start();
	}
	
	private void initialize() {
		frmBarrraDeProgreso = new JFrame();
		frmBarrraDeProgreso.setTitle("Barra de Progreso");
		frmBarrraDeProgreso.setBounds(100, 100, 425, 37);
		frmBarrraDeProgreso.getContentPane().setLayout(null);
		frmBarrraDeProgreso.setLocationRelativeTo(null);
		frmBarrraDeProgreso.setUndecorated(true);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 179, 179));
		progressBar.setBorder(new LineBorder(new Color(255, 185, 185), 4));
		progressBar.setForeground(new Color(255, 179, 179));
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 0, 426, 38);
		frmBarrraDeProgreso.getContentPane().add(progressBar);
		
		
	}
}
