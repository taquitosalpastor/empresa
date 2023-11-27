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

public class AgregarUsuarios {

	public JFrame frame;
	private JLabel lblContrasea;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtContraseña;
	private JButton btnCargar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	Usuario Us=new Usuario();
	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarUsuarios window = new AgregarUsuarios();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 234, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 45, 67, 13);
		frame.getContentPane().add(lblNewLabel);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 21, 67, 13);
		frame.getContentPane().add(lblId);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(10, 69, 67, 13);
		frame.getContentPane().add(lblContrasea);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtId.getText().length()>11) {
					e.consume();
					}
			}
		});
		txtId.setBounds(87, 17, 86, 20);
		frame.getContentPane().add(txtId);
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
		txtNom.setBounds(87, 41, 86, 20);
		frame.getContentPane().add(txtNom);
		
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
		txtContraseña.setBounds(87, 65, 86, 20);
		frame.getContentPane().add(txtContraseña);
		
		btnCargar = new JButton("Cargar");
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
		btnCargar.setBounds(10, 104, 89, 23);
		frame.getContentPane().add(btnCargar);
		
		btnInsertar = new JButton("Insertar");
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
		btnInsertar.setBounds(109, 104, 89, 23);
		frame.getContentPane().add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
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
		btnEliminar.setBounds(10, 138, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(109, 138, 89, 23);
		frame.getContentPane().add(btnLimpiar);
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
