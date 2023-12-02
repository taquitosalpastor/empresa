package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import ClasesP.Quejas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuejasC {

	public JFrame frmQueja;
	private JTextField txtIDQ;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtQueja;
	private JTextField txtFecha;
	private JTextField txtIDU;
	private JButton btnAgregar;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuejasC window = new QuejasC();
					window.frmQueja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuejasC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQueja = new JFrame();
		frmQueja.setBounds(100, 100, 318, 413);
		frmQueja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQueja.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IDQuejas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 23, 90, 19);
		frmQueja.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 61, 90, 14);
		frmQueja.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 92, 90, 14);
		frmQueja.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Queja");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 126, 90, 14);
		frmQueja.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 162, 90, 14);
		frmQueja.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("IDUser");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(10, 203, 90, 14);
		frmQueja.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtIDQ = new JTextField();
		txtIDQ.setBounds(128, 24, 86, 20);
		frmQueja.getContentPane().add(txtIDQ);
		txtIDQ.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(128, 60, 86, 20);
		frmQueja.getContentPane().add(txtNombre);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(128, 91, 86, 20);
		frmQueja.getContentPane().add(txtTipo);
		
		txtQueja = new JTextField();
		txtQueja.setColumns(10);
		txtQueja.setBounds(128, 122, 86, 20);
		frmQueja.getContentPane().add(txtQueja);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(128, 161, 86, 20);
		frmQueja.getContentPane().add(txtFecha);
		
		txtIDU = new JTextField();
		txtIDU.setColumns(10);
		txtIDU.setBounds(128, 202, 86, 20);
		frmQueja.getContentPane().add(txtIDU);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Quejas M=new Quejas();
					M.setIdQuejas(Integer.parseInt(txtIDQ.getText()));
					M.setNombre(txtNombre.getText());
					M.setTipo(txtTipo.getText());
					M.setTexto(txtQueja.getText());
					M.setFecha(txtFecha.getText());
					M.setIduser(Integer.parseInt(txtIDU.getText()));
					
					if(M.InsertarQueja()) {
						JOptionPane.showMessageDialog(null, "Se inserto Correctamente el Comentario");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"Error Al Insertar");
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		btnAgregar.setBounds(28, 265, 89, 23);
		frmQueja.getContentPane().add(btnAgregar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQueja.dispose();
			}
		});
		btnRegresar.setBounds(154, 265, 89, 23);
		frmQueja.getContentPane().add(btnRegresar);
	}
	public void limpiar() {
		txtFecha.setText("");
		txtIDQ.setText("");
		txtIDU.setText("");
		txtNombre.setText("");
		txtQueja.setText("");
		txtTipo.setText("");
	}
	
}
