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
	private JTextField txtCliente;
	private JTextField txtDireccion;
	private JTextField txtSexo;
	private JTextField txtTelefono;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtSintomas;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

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
		frameCitas.setBounds(100, 100, 671, 677);
		frameCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCitas.setLocationRelativeTo(null);
		frameCitas.getContentPane().setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.setBorder(null);
		txtCliente.setBounds(177, 218, 434, 39);
		frameCitas.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		txtSintomas = new JTextField();
		txtSintomas.setBorder(null);
		txtSintomas.setBounds(469, 394, 142, 29);
		frameCitas.getContentPane().add(txtSintomas);
		txtSintomas.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_1.setBounds(398, 453, 174, 59);
		frameCitas.getContentPane().add(lblNewLabel_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setBorder(null);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(177, 276, 434, 39);
		frameCitas.getContentPane().add(txtDireccion);
		
		txtSexo = new JTextField();
		txtSexo.setBorder(null);
		txtSexo.setColumns(10);
		txtSexo.setBounds(469, 335, 142, 39);
		frameCitas.getContentPane().add(txtSexo);
		
		txtTelefono = new JTextField();
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(177, 335, 144, 39);
		frameCitas.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBorder(null);
		txtFecha.setColumns(10);
		txtFecha.setBounds(177, 384, 142, 39);
		frameCitas.getContentPane().add(txtFecha);
		
		lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(24, 11, 127, 22);
		frameCitas.getContentPane().add(lblHora);
		
		JLabel Fonto = new JLabel("");
		Fonto.setIcon(new ImageIcon(Citas.class.getResource("/pixel/Documento A4 Hoja De Pedidos Org.png")));
		Fonto.setBounds(-23, -10, 682, 696);
		frameCitas.getContentPane().add(Fonto);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setBounds(114, 458, 159, 54);
		frameCitas.getContentPane().add(lblNewLabel);
		
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
