package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import ClasesP.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.ImageIcon;

public class AgregarUsuarios {

	public JFrame frmAgregarUsuario;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtContraseña;
	private JButton btnCargar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	Usuario Us=new Usuario();
	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarUsuarios window = new AgregarUsuarios();
					window.frmAgregarUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarUsuario = new JFrame();
		frmAgregarUsuario.setBounds(100, 100, 518, 549);
		frmAgregarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarUsuario.getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtId.getText().length()>11) {
					e.consume();
					}
			}
		});
		txtId.setBounds(257, 190, 86, 20);
		frmAgregarUsuario.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNom.getText().length()>50) {
					e.consume();
					}
			}
		});
		txtNom.setColumns(10);
		txtNom.setBounds(243, 246, 118, 20);
		frmAgregarUsuario.getContentPane().add(txtNom);
		
		txtContraseña = new JTextField();
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtContraseña.getText().length()>100) {
					e.consume();
					}
			}
		});
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(243, 303, 118, 20);
		frmAgregarUsuario.getContentPane().add(txtContraseña);
		
		btnCargar = new JButton("");
		btnCargar.setOpaque(false);
		btnCargar.setBorder(null);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int iduser=Integer.parseInt(JOptionPane.showInputDialog("ID A CARGAR"));
					Us.setIduser(iduser);
					if(Us.cargarUsuario()) {
						txtId.setText(""+Us.getIduser());
						txtNom.setText(Us.getNombre());
						txtContraseña.setText(Us.getContraseña());
						
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
						
					}else {
						JOptionPane.showMessageDialog(null, "ERROR al Insertar");
						}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR al Insertar");
				}
			}
		});
		btnCargar.setBounds(68, 355, 161, 44);
		frmAgregarUsuario.getContentPane().add(btnCargar);
		
		btnInsertar = new JButton("");
		btnInsertar.setBorder(null);
		btnInsertar.setOpaque(false);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario c=new Usuario();
					c.setIduser(Integer.parseInt(txtId.getText()));
					c.setNombre(txtNom.getText());
					c.setContraseña(txtContraseña.getText());
					
					if(c.insertarUsuario()) {
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
		btnInsertar.setBounds(301, 355, 161, 44);
		frmAgregarUsuario.getContentPane().add(btnInsertar);
		
		btnEliminar = new JButton("");
		btnEliminar.setBorder(null);
		btnEliminar.setOpaque(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int iduser=Integer.parseInt(JOptionPane.showInputDialog("Id a Eliminar"));
					Us.setIduser(iduser);
					if(Us.eliminarUsuario(iduser)) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
						
					}else {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
					}
				} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
				}
			}
		});
		btnEliminar.setBounds(69, 428, 151, 56);
		frmAgregarUsuario.getContentPane().add(btnEliminar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.setOpaque(false);
		btnLimpiar.setBorder(null);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(301, 440, 161, 44);
		frmAgregarUsuario.getContentPane().add(btnLimpiar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AgregarUsuarios.class.getResource("/pixelfont/Captura de pantalla 2023-12-03 131550.png")));
		lblNewLabel_1.setBounds(0, 0, 528, 512);
		frmAgregarUsuario.getContentPane().add(lblNewLabel_1);
	}
	public void limpiar() {
		txtId.setText("");
		txtNom.setText("");
		txtContraseña.setText("");
	}
	public String encriptarPassword(String Contraseña) {

	      MessageDigest md;
	      byte[] encoded = null;
		try {
			md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			 md.update(Contraseña.getBytes());
		      byte[] digest = md.digest();

		      for (byte b : digest) {
		         //System.out.print(Integer.toHexString(0xFF & b));
		      }
		      System.out.println();

		      encoded = Base64.encodeBase64(digest);
		      //System.out.println(new String(encoded));	
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return new String(encoded);
	}
}
