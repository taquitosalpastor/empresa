package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgregarProve {

	public JFrame frmProvedores;
	private JTextField txtNomEmpresa;
	private JTextField txtNomLab;
	private JTextField txtNomProve;
	private JTextField textField;
	private JLabel fondo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;

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
		txtNomEmpresa.setBorder(null);
		txtNomEmpresa.setBounds(254, 188, 133, 19);
		frmProvedores.getContentPane().add(txtNomEmpresa);
		txtNomEmpresa.setColumns(10);
		
		txtNomLab = new JTextField();
		txtNomLab.setBorder(null);
		txtNomLab.setColumns(10);
		txtNomLab.setBounds(254, 231, 133, 19);
		frmProvedores.getContentPane().add(txtNomLab);
		
		txtNomProve = new JTextField();
		txtNomProve.setBorder(null);
		txtNomProve.setColumns(10);
		txtNomProve.setBounds(254, 274, 133, 19);
		frmProvedores.getContentPane().add(txtNomProve);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setColumns(10);
		textField.setBounds(254, 315, 133, 19);
		frmProvedores.getContentPane().add(textField);
		
		fondo = new JLabel("");
		fondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		fondo.setIcon(new ImageIcon(AgregarProve.class.getResource("/pixel/provedores (1).png")));
		fondo.setBounds(0, -20, 503, 493);
		frmProvedores.getContentPane().add(fondo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setBounds(53, 368, 118, 34);
		frmProvedores.getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_2.setBounds(249, 368, 133, 34);
		frmProvedores.getContentPane().add(lblNewLabel_2);
	}
}
