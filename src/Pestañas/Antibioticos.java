package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Antibioticos {

	public JFrame frameAnti;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Antibioticos window = new Antibioticos();
					window.frameAnti.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Antibioticos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAnti = new JFrame();
		frameAnti.setBounds(100, 100, 450, 300);
		frameAnti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAnti.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 322, 226);
		frameAnti.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setBounds(342, 30, 85, 21);
		frameAnti.getContentPane().add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(342, 79, 85, 21);
		frameAnti.getContentPane().add(btnRegresar);
	}
}
