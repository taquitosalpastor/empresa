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
	private JTextField txtIDM;
	private JTextField txtIDP;
	private JLabel lblAgregar;
	private JLabel lblRegresar_1;

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
		frmAgregarM.setBounds(100, 100, 681, 651);
		frmAgregarM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarM.getContentPane().setLayout(null);
		
		txtMedicamento = new JTextField();
		txtMedicamento.setBorder(null);
		txtMedicamento.setBounds(509, 243, 130, 27);
		frmAgregarM.getContentPane().add(txtMedicamento);
		txtMedicamento.setColumns(10);
		
		txtIDP = new JTextField();
		txtIDP.setColumns(10);
		txtIDP.setBounds(509, 203, 130, 20);
		frmAgregarM.getContentPane().add(txtIDP);
		
		txtIDM = new JTextField();
		txtIDM.setBounds(509, 154, 130, 27);
		frmAgregarM.getContentPane().add(txtIDM);
		txtIDM.setColumns(10);
		
		txtStoks = new JTextField();
		txtStoks.setBorder(null);
		txtStoks.setColumns(10);
		txtStoks.setBounds(509, 403, 128, 27);
		frmAgregarM.getContentPane().add(txtStoks);
		
		txtPrecio = new JTextField();
		txtPrecio.setBorder(null);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(509, 462, 130, 27);
		frmAgregarM.getContentPane().add(txtPrecio);
		
		txtTipo = new JTextField();
		txtTipo.setBorder(null);
		txtTipo.setColumns(10);
		txtTipo.setBounds(509, 355, 130, 27);
		frmAgregarM.getContentPane().add(txtTipo);
		
		txtProvedor = new JTextField();
		txtProvedor.setBorder(null);
		txtProvedor.setColumns(10);
		txtProvedor.setBounds(509, 296, 130, 27);
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
		
		lblRegresar_1 = new JLabel("");
		lblRegresar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAgregarM.dispose();
			}
		});
		lblRegresar_1.setBounds(341, 497, 195, 68);
		frmAgregarM.getContentPane().add(lblRegresar_1);
		fondo.setIcon(new ImageIcon(AgregMedica.class.getResource("/pixelfont/Nuevo producto (1).png")));
		fondo.setBounds(0, 0, 667, 614);
		frmAgregarM.getContentPane().add(fondo);
		
		lblRegresar = new JLabel("");
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAgregarM.dispose();
			}
		});
		lblRegresar.setBounds(341, 497, 195, 68);
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
