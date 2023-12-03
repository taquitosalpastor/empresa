package Pestañas;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ClasesP.Provedor;

public class AgregarProve {

	public JFrame frmProvedores;
	private JTextField txtNomEmpresa;
	private JTextField txtNomLab;
	private JTextField txtNomProve;
	private JTextField txtNumProv;
	private JLabel lblAgregar;
	private JLabel lblRegresar;
	private JTextField txtIDP;
	private JLabel lblUser;
	private JTextField txtIDU;
	private JLabel lblNewLabel;

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
		frmProvedores.setBounds(100, 100, 468, 492);
		frmProvedores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProvedores.getContentPane().setLayout(null);
		frmProvedores.setLocationRelativeTo(null);
		
		txtNomEmpresa = new JTextField();
		txtNomEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNomEmpresa.getText().length()>50) {
					e.consume();
					}
			}
		});
		
		txtIDU = new JTextField();
		txtIDU.setColumns(10);
		txtIDU.setBounds(327, 153, 96, 20);
		frmProvedores.getContentPane().add(txtIDU);
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(249, 337, 69, 19);
		frmProvedores.getContentPane().add(lblUser);
		
		txtIDP = new JTextField();
		txtIDP.setBounds(114, 153, 87, 20);
		frmProvedores.getContentPane().add(txtIDP);
		txtIDP.setColumns(10);
		txtNomEmpresa.setBorder(null);
		txtNomEmpresa.setBounds(265, 187, 133, 19);
		frmProvedores.getContentPane().add(txtNomEmpresa);
		txtNomEmpresa.setColumns(10);
		
		txtNomLab = new JTextField();
		txtNomLab.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNomLab.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtNomLab.setBorder(null);
		txtNomLab.setColumns(10);
		txtNomLab.setBounds(265, 234, 133, 19);
		frmProvedores.getContentPane().add(txtNomLab);
		
		txtNomProve = new JTextField();
		txtNomProve.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNomProve.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtNomProve.setBorder(null);
		txtNomProve.setColumns(10);
		txtNomProve.setBounds(265, 281, 133, 19);
		frmProvedores.getContentPane().add(txtNomProve);
		
		txtNumProv = new JTextField();
		txtNumProv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNumProv.getText().length()>10) {
					e.consume();
					}
			}
		});
		txtNumProv.setBorder(null);
		txtNumProv.setColumns(10);
		txtNumProv.setBounds(265, 319, 133, 19);
		frmProvedores.getContentPane().add(txtNumProv);
		
		lblAgregar = new JLabel("");
		lblAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					Provedor P=new Provedor();
					P.setIdProvedor(Integer.parseInt(txtIDP.getText()));
					P.setNomEmpresa(txtNomEmpresa.getText());
					P.setNomLab(txtNomLab.getText());
					P.setNomProv(txtNomProve.getText());
					P.setNumeroProv(txtNumProv.getText());
					P.setIduser(Integer.parseInt(txtIDU.getText()));
					
					if(P.insertarProv()) {
						JOptionPane.showMessageDialog(null, "Se inserto Correctamente ");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"Error Al Insertar");
					
				}
			}
		});
		lblAgregar.setBounds(53, 368, 118, 34);
		frmProvedores.getContentPane().add(lblAgregar);
		
		lblRegresar = new JLabel("");
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmProvedores.dispose();
			}
		});
		lblRegresar.setBounds(249, 368, 133, 34);
		frmProvedores.getContentPane().add(lblRegresar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AgregarProve.class.getResource("/pixelfont/Nombre de empresa (1).png")));
		lblNewLabel.setBounds(0, 0, 454, 455);
		frmProvedores.getContentPane().add(lblNewLabel);
	}
	public void limpiar() {
		txtNomEmpresa.setText("");
		txtNomLab.setText("");
		txtNomProve.setText("");
		txtNumProv.setText("");
		txtIDP.setText("");
		txtIDU.setText("");
	}
}
