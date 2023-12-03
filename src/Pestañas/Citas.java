package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.Timer;

import ClasesP.Citass;

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
	private JLabel lblRegresar;
	private JTextField txtIDU;
	private JTextField txtIDC;
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
		
		txtIDC = new JTextField();
		txtIDC.setColumns(10);
		txtIDC.setBounds(457, 253, 138, 29);
		frameCitas.getContentPane().add(txtIDC);
		
		txtIDU = new JTextField();
		txtIDU.setBounds(153, 243, 138, 39);
		frameCitas.getContentPane().add(txtIDU);
		txtIDU.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBorder(null);
		txtCliente.setBounds(153, 301, 434, 39);
		frameCitas.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		txtSintomas = new JTextField();
		txtSintomas.setBorder(null);
		txtSintomas.setBounds(457, 478, 142, 29);
		frameCitas.getContentPane().add(txtSintomas);
		txtSintomas.setColumns(10);
		
		lblRegresar = new JLabel("");
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameCitas.dispose();
			}
		});
		lblRegresar.setBounds(374, 543, 182, 59);
		frameCitas.getContentPane().add(lblRegresar);
		
		txtDireccion = new JTextField();
		txtDireccion.setBorder(null);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(153, 360, 434, 39);
		frameCitas.getContentPane().add(txtDireccion);
		
		txtSexo = new JTextField();
		txtSexo.setBorder(null);
		txtSexo.setColumns(10);
		txtSexo.setBounds(457, 409, 142, 39);
		frameCitas.getContentPane().add(txtSexo);
		
		txtTelefono = new JTextField();
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(147, 409, 144, 39);
		frameCitas.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBorder(null);
		txtFecha.setColumns(10);
		txtFecha.setBounds(158, 473, 142, 39);
		frameCitas.getContentPane().add(txtFecha);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Citass C=new Citass();
					C.setIdCitas(Integer.parseInt(txtIDC.getText()));
					C.setNomC(txtCliente.getText());
					C.setFecha(txtFecha.getText());
					C.setDireccion(txtDireccion.getText());
					C.setSexo(txtSexo.getText());
					C.setNumTel(txtTelefono.getText());
					C.setSintomas(txtSintomas.getText());
					C.setIduser(Integer.parseInt(txtIDU.getText()));
					
					if(C.insertarCita()) {
						JOptionPane.showMessageDialog(null, "Se inserto Correctamente ");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"Error Al Insertar");
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
				
			}
		});
		lblNewLabel_1.setBounds(64, 543, 176, 59);
		frameCitas.getContentPane().add(lblNewLabel_1);
		
		lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHora.setBounds(553, 128, 94, 29);
		frameCitas.getContentPane().add(lblHora);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNewLabel.setBounds(75, 543, 165, 59);
		frameCitas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Citas.class.getResource("/pixelfont/Captura de pantalla 2023-12-03 111048.png")));
		lblNewLabel_4.setBounds(0, 0, 659, 640);
		frameCitas.getContentPane().add(lblNewLabel_4);
		
	}
	public void limpiar() {
		txtCliente.setText("");
		txtDireccion.setText("");
		txtFecha.setText("");
		txtIDC.setText("");
		txtIDU.setText("");
		txtSexo.setText("");
		txtSintomas.setText("");
		txtTelefono.setText("");
	}
	 public void HoraMX() {
	    	new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ZonedDateTime mexicoTime = ZonedDateTime.now(ZoneId.of("America/Mexico_City"));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					lblHora.setText(mexicoTime.format(formatter));
				}
			}).start();
	    }
}
