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
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel_2;

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
		frmQueja.setBounds(100, 100, 600, 689);
		frmQueja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQueja.getContentPane().setLayout(null);
		
		txtIDQ = new JTextField();
		txtIDQ.setBounds(309, 331, 143, 26);
		frmQueja.getContentPane().add(txtIDQ);
		txtIDQ.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(309, 386, 143, 19);
		frmQueja.getContentPane().add(txtNombre);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(310, 445, 142, 26);
		frmQueja.getContentPane().add(txtTipo);
		
		txtQueja = new JTextField();
		txtQueja.setColumns(10);
		txtQueja.setBounds(311, 500, 141, 26);
		frmQueja.getContentPane().add(txtQueja);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(309, 556, 143, 31);
		frmQueja.getContentPane().add(txtFecha);
		
		txtIDU = new JTextField();
		txtIDU.setColumns(10);
		txtIDU.setBounds(309, 271, 143, 26);
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
		btnAgregar.setBounds(154, 597, 113, 45);
		frmQueja.getContentPane().add(btnAgregar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQueja.dispose();
			}
		});
		btnRegresar.setBounds(364, 597, 102, 45);
		frmQueja.getContentPane().add(btnRegresar);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(QuejasC.class.getResource("/pixelfont/Añadir un subtítulo (1).png")));
		lblNewLabel_2.setBounds(-47, -19, 680, 703);
		frmQueja.getContentPane().add(lblNewLabel_2);
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
