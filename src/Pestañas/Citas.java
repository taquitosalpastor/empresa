package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Citas {

	public JFrame frameCitas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblHora;
	private JLabel lblGuardar;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Citas window = new Citas();
					window.frameCitas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Citas() {
		initialize();
		HoraMX();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCitas = new JFrame();
		frameCitas.setBounds(100, 100, 498, 294);
		frameCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCitas.setLocationRelativeTo(null);
		frameCitas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(24, 44, 127, 14);
		frameCitas.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(154, 38, 112, 20);
		frameCitas.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(276, 44, 47, 14);
		frameCitas.getContentPane().add(lblSexo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBox.setBounds(337, 41, 79, 22);
		frameCitas.getContentPane().add(comboBox);
		
		JLabel lblDiaDeConsulta = new JLabel("Fecha:");
		lblDiaDeConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaDeConsulta.setBounds(24, 69, 127, 14);
		frameCitas.getContentPane().add(lblDiaDeConsulta);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 63, 112, 20);
		frameCitas.getContentPane().add(textField_1);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(272, 69, 70, 14);
		frameCitas.getContentPane().add(lblTelefono);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(337, 67, 112, 20);
		frameCitas.getContentPane().add(textField_2);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccin.setBounds(24, 100, 100, 14);
		frameCitas.getContentPane().add(lblDireccin);
		
		textField_3 = new JTextField();
		textField_3.setBounds(154, 98, 112, 20);
		frameCitas.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSistomas = new JLabel("Sistomas:");
		lblSistomas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSistomas.setBounds(272, 100, 79, 14);
		frameCitas.getContentPane().add(lblSistomas);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(337, 98, 112, 20);
		frameCitas.getContentPane().add(textField_4);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameCitas.dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Citas.class.getResource("/Imag/volver.png")));
		lblNewLabel_1.setBounds(440, 198, 32, 40);
		frameCitas.getContentPane().add(lblNewLabel_1);
		
		lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(24, 11, 127, 22);
		frameCitas.getContentPane().add(lblHora);
		
		lblGuardar = new JLabel("");
		lblGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblGuardar.setIcon(new ImageIcon(Citas.class.getResource("/Imag/disquete.png")));
		lblGuardar.setBounds(369, 198, 47, 40);
		frameCitas.getContentPane().add(lblGuardar);
		
	}
	 public void HoraMX() {
	    	new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ZonedDateTime mexicoTime = ZonedDateTime.now(ZoneId.of("America/Mexico_City"));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					lblHora.setText("Hora: "+mexicoTime.format(formatter));
				}
			}).start();
	    }
}
