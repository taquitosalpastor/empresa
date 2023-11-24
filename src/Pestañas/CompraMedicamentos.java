package Pestañas;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CompraMedicamentos {

	public JFrame frmMedicamentos;
	private JButton btnRegresar;
	private JScrollPane scrollPaneM;
	private JTable tblM;
	private JTextField txtCantidad;
	private JButton btnComprar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JLabel lblTotalT;
	private JLabel lblPrecioP;
	private JLabel lblBuscar;
	private JComboBox comboBoxCatalogo;
	private JLabel lblNewLabel_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraMedicamentos window = new CompraMedicamentos();
					window.frmMedicamentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CompraMedicamentos() {
		initialize();
	}

	
	private void initialize() {
		frmMedicamentos = new JFrame();
		frmMedicamentos.getContentPane().setBackground(new Color(0, 255, 255));
		frmMedicamentos.getContentPane().setLayout(null);
		
		frmMedicamentos.setUndecorated(false);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMedicamentos.dispose();
			}
		});
		btnRegresar.setBounds(348, 42, 89, 23);
		frmMedicamentos.getContentPane().add(btnRegresar);
		
		scrollPaneM = new JScrollPane();
		scrollPaneM.setBounds(10, 150, 414, 152);
		frmMedicamentos.getContentPane().add(scrollPaneM);
		
		tblM = new JTable();
		tblM.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPaneM.setViewportView(tblM);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 12, 74, 19);
		frmMedicamentos.getContentPane().add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(10, 43, 48, 19);
		frmMedicamentos.getContentPane().add(lblPrecio);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(199, 71, 48, 19);
		frmMedicamentos.getContentPane().add(lblTotal);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setBounds(10, 71, 63, 19);
		frmMedicamentos.getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(94, 70, 79, 20);
		frmMedicamentos.getContentPane().add(txtCantidad);
		
		btnComprar = new JButton("");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cajero CJ=new Cajero();
				frmMedicamentos.setVisible(false);				
				CJ.frmResumenDeCompra.setVisible(true);
			}
		});
		btnComprar.setBorder(null);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setIcon(new ImageIcon(CompraMedicamentos.class.getResource("/Imag/carrito-de-compras.png")));
		btnComprar.setBounds(364, 2, 63, 30);
		frmMedicamentos.getContentPane().add(btnComprar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(10, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(104, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(199, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnLimpiar);
		
		lblTotalT = new JLabel("T");
		lblTotalT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalT.setBounds(245, 73, 77, 14);
		frmMedicamentos.getContentPane().add(lblTotalT);
		
		lblPrecioP = new JLabel("Precio");
		lblPrecioP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecioP.setBounds(94, 46, 46, 14);
		frmMedicamentos.getContentPane().add(lblPrecioP);
		
		lblBuscar = new JLabel("_____________________");
		lblBuscar.setBounds(94, 16, 177, 13);
		frmMedicamentos.getContentPane().add(lblBuscar);
		
		comboBoxCatalogo = new JComboBox();
		comboBoxCatalogo.setModel(new DefaultComboBoxModel(new String[] {"Antibioticos", "Desinflamatorios", "Antiempaticos"}));
		comboBoxCatalogo.setToolTipText("");
		comboBoxCatalogo.setBounds(233, 16, 113, 21);
		frmMedicamentos.getContentPane().add(comboBoxCatalogo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CompraMedicamentos.class.getResource("/Imag/Diseño sin título.png")));
		lblNewLabel_1.setBounds(-95, -15, 567, 341);
		frmMedicamentos.getContentPane().add(lblNewLabel_1);
		frmMedicamentos.setTitle("Medicamentos");
		frmMedicamentos.setBounds(100, 100, 453, 352);
		frmMedicamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicamentos.setLocationRelativeTo(null);
	}
}
