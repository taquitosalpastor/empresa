package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import ClasesP.Usuario;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.Toolkit;

public class Log {

	public JFrame frame;
	private JTextField txtCorreo;
	private JTextField txtContraseña;
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log window = new Log();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Log() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/Imag/persona.png")));
		frame.setBounds(100, 100, 975, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		txtContraseña = new JTextField();
		txtContraseña.setBorder(null);
		txtContraseña.setBounds(62, 335, 263, 34);
		frame.getContentPane().add(txtContraseña);
		txtContraseña.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(new Color(255, 255, 255));
		txtCorreo.setBorder(null);
		txtCorreo.setOpaque(false);
		txtCorreo.setBounds(62, 246, 263, 30);
		frame.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Usuario U=new Usuario();
					U.setNombre(txtCorreo.getText());
					U.setContraseña((txtContraseña.getText()));
					if(U.login()) {
						JOptionPane.showMessageDialog(null, "BIENVENIDO");
						BarraDeCarga BA=new BarraDeCarga();
						frame.setVisible(false);
						BA.frmBarrraDeProgreso.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "correou/o password incorrecto");
					}
				} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Log.class.getResource("/pixel/fond.png")));
		lblNewLabel.setBounds(0, -20, 1005, 642);
		frame.getContentPane().add(lblNewLabel);
		
		lblLogin = new JLabel("");
		lblLogin.setBounds(75, 429, 258, 28);
		frame.getContentPane().add(lblLogin);
	}
	
}
