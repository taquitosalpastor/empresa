package Pestañas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClasesP.Provedor;

import Datas.DataProvedor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class RepP {

	public JFrame frmREP;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable tblProv;
	 ArrayList<Provedor> listaProv=new ArrayList<Provedor>();
	 Provedor x=null;
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
					RepP window = new RepP();
					window.frmREP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public RepP() {
		initialize();
		actualizarTabla();
	}

	public void actualizarTabla() {
		DataProvedor Dp=new DataProvedor();
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		listaProv=Dp.selectProv();
		for(Provedor Prove : listaProv) {
			Object o[]=new Object[6];
			o[0]=Prove.getIdProvedor();
			o[1]=Prove.getNomEmpresa();
			o[2]=Prove.getNomLab();
			o[3]=Prove.getNomProv();
			o[4]=Prove.getNumeroProv();
			o[5]=Prove.getIduser();
			
			modelo.addRow(o);
			
		}
		tblProv.setModel(modelo);
		
	}
	
	private void initialize() {
		frmREP = new JFrame();
		frmREP.setBounds(100, 100, 450, 300);
		frmREP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmREP.getContentPane().setLayout(null);
		
		JScrollPane TablaE = new JScrollPane();
		TablaE.setBounds(10, 11, 414, 151);
		frmREP.getContentPane().add(TablaE);
		
		tblProv = new JTable();
		tblProv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila=tblProv.getSelectedRow();
				x=listaProv.get(fila);
				x.getIdProvedor();
				x.getNomEmpresa();
				x.getNomLab();
				x.getNomProv();
				x.getNumeroProv();
				x.getIduser();
				
			}
			
		});
		tblProv.setModel(new DefaultTableModel(	
			
		));
		TablaE.setViewportView(tblProv);
		modelo.addColumn("IDProv");
		modelo.addColumn("NomEmpresa");
		modelo.addColumn("NomLab");
		modelo.addColumn("NomProv");
		modelo.addColumn("NumeroProv");
		modelo.addColumn("IDUser");
		tblProv.setModel(modelo);
		actualizarTabla();
		TablaE.setViewportView(tblProv);
		
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmREP.dispose();
			}
		});
		btnNewButton.setBounds(10, 188, 89, 23);
		frmREP.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("PDF");
		btnNewButton_1.setBounds(141, 188, 89, 23);
		frmREP.getContentPane().add(btnNewButton_1);
	}

}