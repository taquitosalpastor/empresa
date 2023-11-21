package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Antiempaticos {

	public JFrame frameAntiempa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Antiempaticos window = new Antiempaticos();
					window.frameAntiempa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Antiempaticos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAntiempa = new JFrame();
		frameAntiempa.setBounds(100, 100, 450, 300);
		frameAntiempa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAntiempa.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 335, 224);
		frameAntiempa.getContentPane().add(scrollPane);
		
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
		btnNewButton.setBounds(351, 32, 85, 21);
		frameAntiempa.getContentPane().add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(351, 97, 85, 21);
		frameAntiempa.getContentPane().add(btnRegresar);
	}

}
