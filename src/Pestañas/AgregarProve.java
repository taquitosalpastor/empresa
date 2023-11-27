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
	private JLabel fondo;
	private JLabel lblNewLabel;
	private JTextField txtIDP;
	private JLabel lblIduser;
	private JLabel lblUser;
	private JTextField txtIDU;

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
		frmProvedores.setBounds(100, 100, 455, 486);
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
		txtIDU.setBounds(249, 337, 31, 20);
		frmProvedores.getContentPane().add(txtIDU);
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(249, 337, 69, 19);
		frmProvedores.getContentPane().add(lblUser);
		
		lblIduser = new JLabel("IDUser");
		lblIduser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIduser.setBounds(25, 337, 178, 19);
		frmProvedores.getContentPane().add(lblIduser);
		
		txtIDP = new JTextField();
		txtIDP.setBounds(254, 152, 31, 20);
		frmProvedores.getContentPane().add(txtIDP);
		txtIDP.setColumns(10);
		
		lblNewLabel = new JLabel("IDProvedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 153, 178, 19);
		frmProvedores.getContentPane().add(lblNewLabel);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(AgregarProve.class.getResource("/pixel/provedores (1).png")));
		fondo.setBounds(0, 0, 450, 445);
		frmProvedores.getContentPane().add(fondo);
		txtNomEmpresa.setBorder(null);
		txtNomEmpresa.setBounds(254, 183, 133, 19);
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
		txtNomLab.setBounds(254, 231, 133, 19);
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
		txtNomProve.setBounds(254, 269, 133, 19);
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
		txtNumProv.setBounds(254, 310, 133, 19);
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
