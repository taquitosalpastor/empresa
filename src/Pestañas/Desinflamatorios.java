package Pestañas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Desinflamatorios {

	public JFrame frameDesinfla;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desinflamatorios window = new Desinflamatorios();
					window.frameDesinfla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Desinflamatorios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDesinfla = new JFrame();
		frameDesinfla.setBounds(100, 100, 450, 300);
		frameDesinfla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDesinfla.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 334, 226);
		frameDesinfla.getContentPane().add(scrollPane);
		
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
		btnNewButton.setBounds(351, 30, 85, 21);
		frameDesinfla.getContentPane().add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(351, 85, 85, 21);
		frameDesinfla.getContentPane().add(btnRegresar);
	}

}
