package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregMedica {

	public JFrame frmAgregarM;
	private JLabel lblNewLabel;
	private JLabel lblStocks;
	private JLabel lblPrecio;
	private JTextField txtMedicamento;
	private JTextField txtStoks;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnRegresar;
	private JTextField txtTipo;
	private JLabel lblProvedor;
	private JTextField txtProvedor;

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
		frmAgregarM.setBounds(100, 100, 251, 258);
		frmAgregarM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarM.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Medicamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 26, 95, 13);
		frmAgregarM.getContentPane().add(lblNewLabel);
		
		lblStocks = new JLabel("Stocks ");
		lblStocks.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStocks.setBounds(10, 112, 95, 13);
		frmAgregarM.getContentPane().add(lblStocks);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(10, 146, 95, 13);
		frmAgregarM.getContentPane().add(lblPrecio);
		
		txtMedicamento = new JTextField();
		txtMedicamento.setBounds(115, 24, 116, 19);
		frmAgregarM.getContentPane().add(txtMedicamento);
		txtMedicamento.setColumns(10);
		
		txtStoks = new JTextField();
		txtStoks.setColumns(10);
		txtStoks.setBounds(115, 110, 116, 19);
		frmAgregarM.getContentPane().add(txtStoks);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(115, 144, 116, 19);
		frmAgregarM.getContentPane().add(txtPrecio);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 174, 85, 21);
		frmAgregarM.getContentPane().add(btnAgregar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarM.dispose();
			}
		});
		btnRegresar.setBounds(120, 174, 85, 21);
		frmAgregarM.getContentPane().add(btnRegresar);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(10, 78, 95, 13);
		frmAgregarM.getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(115, 82, 116, 19);
		frmAgregarM.getContentPane().add(txtTipo);
		
		lblProvedor = new JLabel("Provedor");
		lblProvedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProvedor.setBounds(10, 54, 95, 13);
		frmAgregarM.getContentPane().add(lblProvedor);
		
		txtProvedor = new JTextField();
		txtProvedor.setColumns(10);
		txtProvedor.setBounds(115, 54, 116, 19);
		frmAgregarM.getContentPane().add(txtProvedor);
	}
}
