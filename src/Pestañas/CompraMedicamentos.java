package Pestañas;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import ClasesP.Medicamento;
import ClasesP.Provedor;
import ClasesP.Usuario;
import ClasesP.VentaMedicamento;
import Datas.DataProvedor;
import Datas.DataVentaMedicamento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CompraMedicamentos {

	public JFrame frmMedicamentos;
	private JButton btnRegresar;
	public JScrollPane tblE;
	public JTable TblMI;
	private JTextField txtCantidad;
	private JButton btnComprar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JLabel lblNewLabel_1;
	public DefaultTableModel modelo =new DefaultTableModel();
	int fila=0;
	int id=0;
	private JTextField txtProductos;
	private JTextField txtTotal;
	private JTextField txtPrecio;
	private JTextField txtIDM;

	Medicamento Us=new Medicamento();
	private JLabel lblIdu;
	private JTextField txtIDU;
	private JTextField txtIDP;
	ArrayList<VentaMedicamento> listaVM=new ArrayList<VentaMedicamento>();
	VentaMedicamento x=null;
	
	
	int p=0,t=0,ca=0;
	private JButton btnActualizar;
	private JLabel lblIdu_1;
	
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
		BuscadorM BM=new BuscadorM();
		BM.frmBuscarMS.setVisible(true);
		actualizarTabla();
	}

	public void actualizarTabla() {
		DataVentaMedicamento DV=new DataVentaMedicamento();
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		listaVM=DV.selectVM();
		for(VentaMedicamento Prove : listaVM) {
			Object o[]=new Object[8];
			o[0]=Prove.getIdVentaM();
			o[1]=Prove.getProducto();
			o[2]=Prove.getMonto();
			o[3]=Prove.getFecha();
			o[4]=Prove.getFolio();
			o[5]=Prove.getTotal();
			o[6]=Prove.getIdMedicamento();
			o[7]=Prove.getIduser();
			
			modelo.addRow(o);
			
		}
		TblMI.setModel(modelo);
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
		btnRegresar.setBounds(327, 127, 89, 23);
		frmMedicamentos.getContentPane().add(btnRegresar);
		
		tblE = new JScrollPane();
		tblE.setBounds(0, 161, 428, 152);
		frmMedicamentos.getContentPane().add(tblE);
		
		TblMI = new JTable();
		TblMI.setModel(new DefaultTableModel(
			
			
		));
		tblE.setViewportView(TblMI);
		modelo.addColumn("IDVenta");
		modelo.addColumn("Producto");
		modelo.addColumn("Monto");
		modelo.addColumn("Fecha");
		modelo.addColumn("Precio");
		modelo.addColumn("Total");
		modelo.addColumn("idMedicamneto");
		modelo.addColumn("IDUser");
		
		txtIDU = new JTextField();
		txtIDU.setColumns(10);
		txtIDU.setBounds(235, 102, 53, 20);
		frmMedicamentos.getContentPane().add(txtIDU);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 12, 74, 19);
		frmMedicamentos.getContentPane().add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(10, 43, 48, 19);
		frmMedicamentos.getContentPane().add(lblPrecio);
		
		JButton btnCargar = new JButton("Cargar ID");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idMedicamento=Integer.parseInt(JOptionPane.showInputDialog("ID A CARGAR"));
					Us.setIdMedicamento(idMedicamento);
					if(Us.cargarM()) {
						txtIDP.setText(""+Us.getIdMedicamento());
						txtProductos.setText(Us.getMedicamento());
						txtPrecio.setText(Us.getPrecio());
						
						
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
						
					}else {
						JOptionPane.showMessageDialog(null, "ERROR al Insertar");
						}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		btnCargar.setBounds(298, 11, 89, 23);
		frmMedicamentos.getContentPane().add(btnCargar);
		
		txtIDM = new JTextField();
		txtIDM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtIDM.getText().length()>11) {
					e.consume();
					}
			}
		});
		txtIDM.setColumns(10);
		txtIDM.setBounds(235, 43, 53, 20);
		frmMedicamentos.getContentPane().add(txtIDM);
		
		JLabel lblIdm = new JLabel("IDM");
		lblIdm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdm.setBounds(199, 43, 48, 19);
		frmMedicamentos.getContentPane().add(lblIdm);
		
		txtIDP = new JTextField();
		txtIDP.setColumns(10);
		txtIDP.setBounds(235, 128, 53, 20);
		frmMedicamentos.getContentPane().add(txtIDP);
		
		lblIdu = new JLabel("IDU");
		lblIdu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdu.setBounds(199, 102, 48, 19);
		frmMedicamentos.getContentPane().add(lblIdu);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(94, 43, 79, 20);
		frmMedicamentos.getContentPane().add(txtPrecio);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
		btnActualizar.setBounds(109, 127, 89, 23);
		frmMedicamentos.getContentPane().add(btnActualizar);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(199, 71, 48, 19);
		frmMedicamentos.getContentPane().add(lblTotal);
		
		lblIdu_1 = new JLabel("IDP");
		lblIdu_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdu_1.setBounds(199, 128, 48, 19);
		frmMedicamentos.getContentPane().add(lblIdu_1);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setEditable(false);
		txtTotal.setBounds(239, 71, 79, 20);
		frmMedicamentos.getContentPane().add(txtTotal);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setBounds(10, 71, 63, 19);
		frmMedicamentos.getContentPane().add(lblCantidad);
		
		JLabel lblBuscarr = new JLabel("IdProducto");
		lblBuscarr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblBuscarr.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscarr.setBounds(225, 14, 90, 14);
		frmMedicamentos.getContentPane().add(lblBuscarr);
		
		txtProductos = new JTextField();
		txtProductos.setEditable(false);
		txtProductos.setBounds(94, 12, 121, 20);
		frmMedicamentos.getContentPane().add(txtProductos);
		txtProductos.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCantidad.getText().length()>10) {
					e.consume();
					}
			}
		});
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
		btnComprar.setBounds(374, 0, 63, 30);
		frmMedicamentos.getContentPane().add(btnComprar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VentaMedicamento c=new VentaMedicamento();
					
					c.setIdVentaM(Integer.parseInt(txtIDM.getText()));
					c.setProducto(txtProductos.getText());
					ca=c.setMonto(Integer.parseInt(txtCantidad.getText()));
					p= c.setFolio(Integer.parseInt(txtPrecio.getText()));
					c.setIduser(Integer.parseInt(txtIDU.getText()));
					c.setIdMedicamento(Integer.parseInt(txtIDP.getText()));
					t=ca*p;
					
					txtTotal.setText(""+t);
					c.setTotal(Integer.parseInt(txtTotal.getText()));
					
					if(c.InsertarMedi()) {
						
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
		btnInsertar.setBounds(10, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(10, 127, 89, 23);
		frmMedicamentos.getContentPane().add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setBounds(109, 101, 89, 23);
		frmMedicamentos.getContentPane().add(btnLimpiar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CompraMedicamentos.class.getResource("/Imag/Diseño sin título.png")));
		lblNewLabel_1.setBounds(-95, -15, 641, 405);
		frmMedicamentos.getContentPane().add(lblNewLabel_1);
		frmMedicamentos.setTitle("Medicamentos");
		frmMedicamentos.setBounds(100, 100, 444, 352);
		frmMedicamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicamentos.setLocationRelativeTo(null);
	}
	public void limpiar() {
		txtCantidad.setText("");
		txtIDM.setText("");
		txtIDP.setText("");
		txtIDU.setText("");
		txtPrecio.setText("");
		txtProductos.setText("");
		txtTotal.setText("");
	}
}
