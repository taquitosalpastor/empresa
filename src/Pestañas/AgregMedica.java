package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

import ClasesP.Medicamento;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgregMedica {

	public JFrame frmAgregarM;
	private JTextField txtMedicamento;
	private JTextField txtStoks;
	private JTextField txtPrecio;
	private JTextField txtTipo;
	private JTextField txtProvedor;
	private JLabel fondo;
	private JLabel lblRegresar;
	private JLabel lblNewLabel_2;
	private JTextField txtIDM;
	private JLabel lblNewLabel_3;
	private JTextField txtIDP;
	private JLabel lblAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregMedica window = new AgregMedica();
					window.frmAgregarM.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregMedica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarM = new JFrame();
		frmAgregarM.setBounds(100, 100, 637, 632);
		frmAgregarM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarM.getContentPane().setLayout(null);
		
		txtMedicamento = new JTextField();
		txtMedicamento.setBorder(null);
		txtMedicamento.setBounds(465, 216, 130, 27);
		frmAgregarM.getContentPane().add(txtMedicamento);
		txtMedicamento.setColumns(10);
		
		txtIDP = new JTextField();
		txtIDP.setColumns(10);
		txtIDP.setBounds(465, 466, 86, 20);
		frmAgregarM.getContentPane().add(txtIDP);
		
		lblNewLabel_2 = new JLabel("IdMedicamento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(312, 176, 117, 14);
		frmAgregarM.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("IdProvedor");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(352, 464, 117, 14);
		frmAgregarM.getContentPane().add(lblNewLabel_3);
		
		txtIDM = new JTextField();
		txtIDM.setBounds(469, 172, 86, 20);
		frmAgregarM.getContentPane().add(txtIDM);
		txtIDM.setColumns(10);
		
		txtStoks = new JTextField();
		txtStoks.setBorder(null);
		txtStoks.setColumns(10);
		txtStoks.setBounds(467, 367, 128, 27);
		frmAgregarM.getContentPane().add(txtStoks);
		
		txtPrecio = new JTextField();
		txtPrecio.setBorder(null);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(465, 414, 130, 27);
		frmAgregarM.getContentPane().add(txtPrecio);
		
		txtTipo = new JTextField();
		txtTipo.setBorder(null);
		txtTipo.setColumns(10);
		txtTipo.setBounds(465, 319, 130, 27);
		frmAgregarM.getContentPane().add(txtTipo);
		
		txtProvedor = new JTextField();
		txtProvedor.setBorder(null);
		txtProvedor.setColumns(10);
		txtProvedor.setBounds(466, 267, 130, 27);
		frmAgregarM.getContentPane().add(txtProvedor);
		
		fondo = new JLabel("");
		fondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblAgregar = new JLabel("");
		lblAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Medicamento M=new Medicamento();
					M.setIdMedicamento(Integer.parseInt(txtIDM.getText()));
					M.setMedicamento(txtMedicamento.getText());
					M.setProvedor(txtProvedor.getText());
					M.setTipo(txtTipo.getText());
					M.setStock(txtStoks.getText());
					M.setPrecio(txtPrecio.getText());
					M.setIdProvedor(Integer.parseInt(txtIDP.getText()));
					
					if(M.insertarMedicamento()) {
						JOptionPane.showMessageDialog(null, "Se inserto Correctamente el Medicamento ");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"Error Al Insertar");
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		lblAgregar.setBounds(106, 516, 177, 49);
		frmAgregarM.getContentPane().add(lblAgregar);
		fondo.setIcon(new ImageIcon(AgregMedica.class.getResource("/pixel/Nuevo producto (1).png")));
		fondo.setBounds(0, 0, 623, 595);
		frmAgregarM.getContentPane().add(fondo);
		
		lblRegresar = new JLabel("");
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblRegresar.setBounds(352, 516, 177, 49);
		frmAgregarM.getContentPane().add(lblRegresar);
	}
	public void limpiar() {
		txtIDM.setText("");
		txtIDP.setText("");
		txtMedicamento.setText("");
		txtPrecio.setText("");
		txtProvedor.setText("");
		txtStoks.setText("");
		txtTipo.setText("");
	}
}
