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
	private JLabel lblNewLabel_2;
	private JTextField txtIDU;
	private JLabel lblNewLabel_3;
	private JTextField txtIDC;
	private JLabel lblAceptar;
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
		txtIDC.setBounds(222, 184, 51, 20);
		frameCitas.getContentPane().add(txtIDC);
		
		lblNewLabel_3 = new JLabel("IDCliente");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(159, 186, 67, 14);
		frameCitas.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("IDUser");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(46, 186, 46, 14);
		frameCitas.getContentPane().add(lblNewLabel_2);
		
		txtIDU = new JTextField();
		txtIDU.setBounds(98, 187, 51, 20);
		frameCitas.getContentPane().add(txtIDU);
		txtIDU.setColumns(10);
		
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
		
		lblRegresar = new JLabel("");
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameCitas.dispose();
			}
		});
		lblRegresar.setBounds(398, 453, 174, 59);
		frameCitas.getContentPane().add(lblRegresar);
		
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
		lblNewLabel_1.setBounds(114, 458, 159, 54);
		frameCitas.getContentPane().add(lblNewLabel_1);
		
		lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHora.setBounds(553, 128, 106, 29);
		frameCitas.getContentPane().add(lblHora);
		
		lblAceptar = new JLabel("");
		lblAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblAceptar.setIcon(new ImageIcon(Citas.class.getResource("/pixel/Documento A4 Hoja De Pedidos Org.png")));
		lblAceptar.setBounds(-23, -10, 682, 696);
		frameCitas.getContentPane().add(lblAceptar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNewLabel.setBounds(114, 458, 159, 54);
		frameCitas.getContentPane().add(lblNewLabel);
		
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
