package Pestañas;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Login {

	private JFrame frame;
	private JTextField txtCorreo;
	private JButton btnNewButton;
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 217, 217));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pixel/Captura de pantalla 2023-11-15 112054.png")));
		frame.getContentPane().setForeground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 396, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);


		frame.getContentPane().setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(64, 0, 64));
		txtCorreo.setOpaque(false);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(152,125,179,35);
		frame.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnNewButton = new JButton("iniciar");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario x=new Usuario();
					x.setCorreo(txtCorreo.getText());
					x.setPassword(encriptarPassword(txtPassword.getText()));
					if(x.login()) {
						JOptionPane.showMessageDialog(null, "BIENVENIDO");
						BarraDeCarga b = new BarraDeCarga();
						frame.setVisible(false);
						b.frmBarrraDeProgreso.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "correou/o password incorrecto");
					}
				} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnNewButton.setBounds(172,244,126,35);
		frame.getContentPane().add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(64, 0, 64));
		txtPassword.setOpaque(false);
		txtPassword.setBorder(null);
		txtPassword.setBounds(151, 187, 180, 35);
		frame.getContentPane().add(txtPassword);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(4, 172, 181), null, null, null));
		panel.setBackground(new Color(0, 232, 232));
		panel.setBounds(10, 10, 131, 344);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imag/persona (2).png")));
		lblNewLabel.setBounds(25, 43, 64, 73);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD:");
		lblNewLabel_1_1.setBounds(12, 181, 109, 23);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(64, 0, 64));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 19));
		
		JLabel lblNewLabel_1 = new JLabel("CORREO: ");
		lblNewLabel_1.setBounds(22, 119, 89, 35);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(64, 0, 64));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 19));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Imag/medi.png")));
		lblNewLabel_3.setBounds(0, 309, 37, 35);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/medi.png")));
		lblNewLabel_3_1.setBounds(94, 0, 37, 35);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2.setBounds(363, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1.setBounds(363, 52, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1.setBounds(363, 89, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1_1.setBounds(363, 125, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1_1_1.setBounds(363, 165, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("");
		lblNewLabel_2_1_1_2.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1_2.setBounds(363, 195, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("");
		lblNewLabel_2_1_1_1_2.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1_1_2.setBounds(363, 231, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1_1_1_1.setBounds(363, 271, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(363, 309, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_2.setBounds(331, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_2_1.setBounds(298, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("");
		lblNewLabel_2_2_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_2_1_1.setBounds(210, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("");
		lblNewLabel_2_2_2.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_2_2.setBounds(243, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_3.setBounds(275, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("");
		lblNewLabel_2_2_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_2_1_1_1.setBounds(177, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_2_1_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Imag/poker.png")));
		lblNewLabel_2_2_1_1_1_1.setBounds(144, 10, 23, 28);
		frame.getContentPane().add(lblNewLabel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("_______________________________");
		lblNewLabel_4.setBounds(152, 148, 201, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("_______________________________");
		lblNewLabel_4_1.setBounds(152, 213, 201, 13);
		frame.getContentPane().add(lblNewLabel_4_1);
	}
	public ImageIcon cambiar (ImageIcon img, int ancho,int alto) {
		Image imgEscalada = img.getImage().getScaledInstance(ancho, ancho, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imgEscalada);
		return image;
	}
	public String encriptarPassword(String password) {

	      MessageDigest md;
	      byte[] encoded = null;
		try {
			md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			 md.update(password.getBytes());
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
