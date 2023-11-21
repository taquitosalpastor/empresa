package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cajero {

	public JFrame frmResumenDeCompra;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnPagar;
	private JPanel panel_1;
	private JLabel lblCarro2;
	private JPanel panel_2;
	private JLabel lblProduc;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtTotalProducto;
	private JTextField txtTotalCompra;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JButton btnRegresar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cajero window = new Cajero();
					window.frmResumenDeCompra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cajero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResumenDeCompra = new JFrame();
		frmResumenDeCompra.getContentPane().setBackground(new Color(6, 138, 151));
		frmResumenDeCompra.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(3, 0, 0, 0));
		panel.setBackground(new Color(255, 255, 244));
		panel.setBounds(10, 10, 144, 363);
		frmResumenDeCompra.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(10, 53, 124, 47);
		btnPagar.setBorderPainted(false);
		btnPagar.setForeground(new Color(0, 0, 0));
		panel.add(btnPagar);
		btnPagar.setBackground(new Color(186, 219, 223));
		btnPagar.setFont(new Font("Sylfaen", Font.BOLD, 19));
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(10, 135, 124, 47);
		btnLimpiar.setForeground(Color.BLACK);
		btnLimpiar.setFont(new Font("Sylfaen", Font.BOLD, 19));
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setBackground(new Color(186, 219, 223));
		panel.add(btnLimpiar);
		
		btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmResumenDeCompra.dispose();
			}
		});
		btnRegresar.setBounds(10, 218, 124, 47);
		btnRegresar.setForeground(Color.BLACK);
		btnRegresar.setFont(new Font("Sylfaen", Font.BOLD, 17));
		btnRegresar.setBorderPainted(false);
		btnRegresar.setBackground(new Color(186, 219, 223));
		panel.add(btnRegresar);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(111, 81, 62, 70);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(111, 10, 45, 13);
		panel.add(lblNewLabel_16);
		lblNewLabel_16.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(208, 245, 250));
		panel_1.setBounds(151, 10, 576, 363);
		frmResumenDeCompra.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 120, 527, 233);
		panel_1.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(128, 255, 255));
		
		table = new JTable();
		table.setOpaque(false);
		table.setBackground(new Color(128, 255, 255));
		table.setGridColor(new Color(128, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/5465858 (1).png")));
		lblCarro.setBounds(23, 10, 89, 82);
		panel_1.add(lblCarro);
		
		lblCarro2 = new JLabel("");
		lblCarro2.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/5465858 (1).png")));
		lblCarro2.setBounds(451, 10, 89, 82);
		panel_1.add(lblCarro2);
		
		lblProduc = new JLabel("Tus productos");
		lblProduc.setFont(new Font("Sylfaen", Font.BOLD, 46));
		lblProduc.setBounds(122, 21, 307, 70);
		panel_1.add(lblProduc);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-32, 0, 62, 70);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_1.setBounds(-32, 80, 55, 70);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_8.setBounds(-32, 160, 45, 70);
		panel_1.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_9.setBounds(-32, 240, 45, 74);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_10.setBounds(-32, 324, 45, 70);
		panel_1.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_11.setBounds(531, 0, 45, 70);
		panel_1.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_12.setBounds(531, 80, 45, 70);
		panel_1.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_13.setBounds(531, 160, 45, 70);
		panel_1.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_14.setBounds(531, 240, 45, 70);
		panel_1.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/linea-discontinua (2).png")));
		lblNewLabel_15.setBounds(531, 320, 45, 70);
		panel_1.add(lblNewLabel_15);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(208, 245, 250));
		panel_2.setBounds(726, 10, 245, 363);
		frmResumenDeCompra.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Ticket de compra");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 33));
		lblNewLabel_3.setBounds(20, 23, 215, 46);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Total de productos:");
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 94, 215, 46);
		panel_2.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Total de compra:");
		lblNewLabel_5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 156, 215, 46);
		panel_2.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/logof (1).png")));
		lblNewLabel_6.setBounds(45, 198, 145, 100);
		panel_2.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Cajero.class.getResource("/pixel/code-128-barcode-gs1-128-coder-c.png")));
		lblNewLabel_7.setBounds(0, 308, 235, 45);
		panel_2.add(lblNewLabel_7);
		
		txtTotalProducto = new JTextField();
		txtTotalProducto.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtTotalProducto.setOpaque(false);
		txtTotalProducto.setFocusTraversalPolicyProvider(true);
		txtTotalProducto.setBounds(149, 110, 52, 19);
		panel_2.add(txtTotalProducto);
		txtTotalProducto.setColumns(10);
		
		txtTotalCompra = new JTextField();
		txtTotalCompra.setOpaque(false);
		txtTotalCompra.setFocusTraversalPolicyProvider(true);
		txtTotalCompra.setColumns(10);
		txtTotalCompra.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtTotalCompra.setBounds(138, 172, 52, 19);
		panel_2.add(txtTotalCompra);
		frmResumenDeCompra.setTitle("Resumen de Compra");
		frmResumenDeCompra.setBounds(100, 100, 995, 421);
		frmResumenDeCompra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResumenDeCompra.setLocationRelativeTo(null);
	}
}
