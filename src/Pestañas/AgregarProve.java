package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarProve {

	public JFrame frmProvedores;
	private JTextField txtNomEmpresa;
	private JTextField txtNomLab;
	private JTextField txtNomProve;
	private JLabel lblNombreDelProvedor;
	private JLabel lblNombreDelLaboratorio;
	private JLabel lblNewLabel;
	private JLabel lblNumeroDelProvedor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProve window = new AgregarProve();
					window.frmProvedores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarProve() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProvedores = new JFrame();
		frmProvedores.setBounds(100, 100, 310, 274);
		frmProvedores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProvedores.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nombre de la Empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 34, 133, 13);
		frmProvedores.getContentPane().add(lblNewLabel);
		
		lblNombreDelLaboratorio = new JLabel("Nombre del laboratorio");
		lblNombreDelLaboratorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreDelLaboratorio.setBounds(10, 65, 133, 13);
		frmProvedores.getContentPane().add(lblNombreDelLaboratorio);
		
		lblNombreDelProvedor = new JLabel("Nombre del Provedor");
		lblNombreDelProvedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreDelProvedor.setBounds(10, 95, 133, 13);
		frmProvedores.getContentPane().add(lblNombreDelProvedor);
		
		txtNomEmpresa = new JTextField();
		txtNomEmpresa.setBounds(153, 31, 133, 19);
		frmProvedores.getContentPane().add(txtNomEmpresa);
		txtNomEmpresa.setColumns(10);
		
		txtNomLab = new JTextField();
		txtNomLab.setColumns(10);
		txtNomLab.setBounds(153, 61, 133, 19);
		frmProvedores.getContentPane().add(txtNomLab);
		
		txtNomProve = new JTextField();
		txtNomProve.setColumns(10);
		txtNomProve.setBounds(153, 91, 133, 19);
		frmProvedores.getContentPane().add(txtNomProve);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(10, 173, 101, 32);
		frmProvedores.getContentPane().add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProvedores.dispose();
			}
		});
		btnRegresar.setBounds(153, 173, 106, 32);
		frmProvedores.getContentPane().add(btnRegresar);
		
		lblNumeroDelProvedor = new JLabel("Numero del Provedor");
		lblNumeroDelProvedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDelProvedor.setBounds(10, 124, 133, 13);
		frmProvedores.getContentPane().add(lblNumeroDelProvedor);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(153, 120, 133, 19);
		frmProvedores.getContentPane().add(textField);
	}
}
