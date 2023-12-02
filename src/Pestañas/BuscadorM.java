package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ClasesP.Medicamento;
import Pestañas.CompraMedicamentos;
import Datas.DataMedicamento;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscadorM {

	public JFrame frmBuscarMS;
	public JTable TblM;
	private JTextField txtBuscar;
	ArrayList<Medicamento> lista2=new ArrayList<Medicamento>();
	 Medicamento x=null;
		int fila=0;
		int id=0;
		public DefaultTableModel modelo =new DefaultTableModel();
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorM window = new BuscadorM();
					window.frmBuscarMS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscadorM() {
		initialize();
		actualizarTabla();
	}

	public void actualizarTabla() {
		DataMedicamento DMM=new DataMedicamento();
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		lista2=DMM.selectMedicamento();
		for(Medicamento M : lista2) {
			Object o[]=new Object[7];
			o[0]=M.getIdMedicamento();
			o[1]=M.getMedicamento();
			o[2]=M.getProvedor();
			o[3]=M.getTipo();
			o[4]=M.getStock();
			o[5]=M.getPrecio();
			o[6]=M.getIdProvedor();
			
			modelo.addRow(o);
			
		}
		TblM.setModel(modelo);
		
	}
	
	private void initialize() {
		frmBuscarMS = new JFrame();
		frmBuscarMS.setBounds(100, 100, 450, 253);
		frmBuscarMS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscarMS.getContentPane().setLayout(null);
		frmBuscarMS.setLocation(280,350);
		
		
		
		
		JScrollPane TablaE = new JScrollPane();
		TablaE.setBounds(10, 57, 414, 156);
		frmBuscarMS.getContentPane().add(TablaE);
		
		TblM = new JTable();
		TblM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila=TblM.getSelectedRow();
				x=lista2.get(fila);
				x.getIdMedicamento();
				x.getMedicamento();
				x.getProvedor();
				x.getTipo();
				x.getStock();
				x.getPrecio();
				x.getIdProvedor();
			}
		});
		TblM.setModel(new DefaultTableModel(
			
		));
		TablaE.setViewportView(TblM);
		modelo.addColumn("IDMedicamento");
		modelo.addColumn("Medicamento");
		modelo.addColumn("Provedor");
		modelo.addColumn("Tipo");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		modelo.addColumn("IDProvedor");
		TblM.setModel(modelo);
		actualizarTabla();
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBuscarMS.dispose();
				
			}
		});
		btnRegresar.setBounds(335, 25, 89, 23);
		frmBuscarMS.getContentPane().add(btnRegresar);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtBuscar.getText().toString();
				refrescarTabla2();
			}
		});
		txtBuscar.setBounds(10, 26, 200, 20);
		frmBuscarMS.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
	}
	
	
	
	 public void refrescarTabla2(String palabra) {
	        while (modelo.getRowCount() > 0) {
	            modelo.removeRow(0);
	        }
	        lista2 = DataMedicamento.buscar(palabra);
	        for (Medicamento p : lista2) {
	            Object item[] = new Object[7];
	            item[0] = p.getIdMedicamento();
	            item[1] = p.getMedicamento();
	            item[2] = p.getProvedor();
	            item[3] = p.getTipo();
	            item[4] = p.getStock();
	            item[5] = p.getPrecio();
	            item[6] = p.getIdProvedor();
	            modelo.addRow(item);
	        }
	        TblM.setModel(modelo);
	    }
}
