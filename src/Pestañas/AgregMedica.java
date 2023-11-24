package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

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
		fondo.setIcon(new ImageIcon(AgregMedica.class.getResource("/pixel/Nuevo producto (1).png")));
		fondo.setBounds(0, 0, 623, 595);
		frmAgregarM.getContentPane().add(fondo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(106, 516, 177, 49);
		frmAgregarM.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_1.setBounds(352, 516, 177, 49);
		frmAgregarM.getContentPane().add(lblNewLabel_1);
	}
}
