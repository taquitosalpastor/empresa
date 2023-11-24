package Pestañas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

	public class Frmc {

	    public JFrame frmFarmaciaUsuario;
	    private JLabel lblCliente;
	    private JButton btnComprar;
	    private JButton btnNewButton;
	    private JLabel lblHora;
	    private JLabel lblProvedores;
	    private JLabel lblTicketP;
	    private JLabel lblEmpleadosP;
	    private JLabel lblCitasP;
	    private JLabel lblQuejas;
	    private JMenu mnNewMenuReportes;
	    private JMenu mnNewMenuQuejas;
	    private JMenu mnNewMenuPDF;
	    private JMenu mnNewMenuAdminsitrador;
	    private JLabel lblProvedoresR;
	    private JLabel lblEmpleadosR;
	    private JLabel lblQuejasQ;
	    private JLabel lblSugerenciasS;
	    private JLabel lblAgregarU;
	    private JLabel lblAdministrarM;
	    private JLabel lblNewLabel_4;
	    private JLabel label;
	    private JLabel lblNewLabel;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Frmc window = new Frmc();
	                    window.frmFarmaciaUsuario.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Frmc() {
	        initialize();
	        HoraMX();
	    }

	    private void initialize() {

	        frmFarmaciaUsuario = new JFrame();
	        frmFarmaciaUsuario.setBackground(new Color(128, 255, 255));
	        frmFarmaciaUsuario.getContentPane().setBackground(new Color(128, 255, 255));
	        frmFarmaciaUsuario.setTitle("Farmacia Usuario");
	        
	        frmFarmaciaUsuario.setBounds(700, 120, 1197, 728);
	        frmFarmaciaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmFarmaciaUsuario.getContentPane().setLayout(null);
	        frmFarmaciaUsuario.setLocationRelativeTo(null);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Frmc.class.getResource("/pixel/Farmacia full house.png")));
			lblNewLabel.setBounds(0, -25, 1370, 736);
			frmFarmaciaUsuario.getContentPane().add(lblNewLabel);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setOpaque(false);
			menuBar.setBackground(new Color(255, 217, 217));
			menuBar.setBounds(0, 0, 1370, 25);
			frmFarmaciaUsuario.getContentPane().add(menuBar);
			
			mnNewMenuPDF = new JMenu("PDF");
			mnNewMenuPDF.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			menuBar.add(mnNewMenuPDF);
			
			lblTicketP = new JLabel("Ticket");
			lblTicketP.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblTicketP);
			
			lblEmpleadosP = new JLabel("Empleados");
			lblEmpleadosP.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblEmpleadosP);
			
			lblCitasP = new JLabel("Citas");
			lblCitasP.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblCitasP);
			
			lblQuejas = new JLabel("Quejas/Sugerencias");
			lblQuejas.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblQuejas);
			
			lblProvedores = new JLabel("Provedores");
			lblProvedores.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblProvedores);
			
			mnNewMenuQuejas = new JMenu("Quejas /Sugererncias");
			mnNewMenuQuejas.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/buzon.png")));
			menuBar.add(mnNewMenuQuejas);
			
			lblQuejasQ = new JLabel("Quejas");
			lblQuejasQ.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/informe.png")));
			mnNewMenuQuejas.add(lblQuejasQ);
			
			lblSugerenciasS = new JLabel("Sugerencias");
			lblSugerenciasS.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/pregunta.png")));
			mnNewMenuQuejas.add(lblSugerenciasS);
			
			mnNewMenuReportes = new JMenu("Reportes");
			mnNewMenuReportes.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/reporte.png")));
			menuBar.add(mnNewMenuReportes);
			
			lblEmpleadosR = new JLabel("Empleados");
			lblEmpleadosR.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/empleado.png")));
			mnNewMenuReportes.add(lblEmpleadosR);
			
			lblProvedoresR = new JLabel("Provedores");
			lblProvedoresR.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/proveedor-hotelero.png")));
			mnNewMenuReportes.add(lblProvedoresR);
			
			mnNewMenuAdminsitrador = new JMenu("Administrador");
			mnNewMenuAdminsitrador.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/apoyo.png")));
			menuBar.add(mnNewMenuAdminsitrador);
			
			lblAgregarU = new JLabel("Agregar Usuarios");
			lblAgregarU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblAgregarU.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/usuario.png")));
			mnNewMenuAdminsitrador.add(lblAgregarU);
			
			lblAdministrarM = new JLabel("Administrar Medicamento");
			lblAdministrarM.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AgregMedica AGM=new AgregMedica();
					AGM.frmAgregarM.setVisible(true);
				}
			});
			
			lblNewLabel_4 = new JLabel("Agregar Provedores");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AgregarProve AP=new AgregarProve();
					AP.frmProvedores.setVisible(true);
				}
			});
			lblNewLabel_4.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/proveedor-hotelero.png")));
			mnNewMenuAdminsitrador.add(lblNewLabel_4);
			lblAdministrarM.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/medi.png")));
			mnNewMenuAdminsitrador.add(lblAdministrarM);
			
			label = new JLabel("New label");
			label.setBounds(0, 0, 45, 13);
			frmFarmaciaUsuario.getContentPane().add(label);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 35, 1370, 50);
			frmFarmaciaUsuario.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
				        
						lblHora = new JLabel("");
						lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblHora.setBounds(1234, 0, 136, 50);
						panel_1.add(lblHora);
						lblHora.setBorder(new LineBorder(new Color(14, 203, 218), 2, true));
						
							        lblCliente = new JLabel("Usuario:");
							        lblCliente.setBounds(970, 0, 267, 50);
							        panel_1.add(lblCliente);
							        lblCliente.setBorder(new LineBorder(new Color(0, 255, 255), 3, true));
							        lblCliente.setFont(new Font("Serif", Font.BOLD, 14));
							        	        
							        	        	        btnNewButton = new JButton("Agendar Cita");
							        	        	        btnNewButton.addActionListener(new ActionListener() {
							        	        	        	public void actionPerformed(ActionEvent e) {
							        	        	        		Citas Cs=new Citas();
							        	        	        		Cs.frameCitas.setVisible(true);
							        	        	        	}
							        	        	        });
							        	        	        btnNewButton.setBounds(155, 0, 130, 49);
							        	        	        panel_1.add(btnNewButton);
							        	        	        btnNewButton.setContentAreaFilled(false);
							        	        	        btnNewButton.setRolloverIcon(new ImageIcon(Frmc.class.getResource("/Imag/calendario.png")));
							        	        	        btnNewButton.setPressedIcon(new ImageIcon(Frmc.class.getResource("/Imag/calendario (1).png")));
							        	        	        btnNewButton.setBorder(null);
							        	        	        btnNewButton.setOpaque(false);
							        	        	        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
							        	        	        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
							        	        	        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
							        	        	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
							        	        	        btnNewButton.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/calendario (1).png")));
							        	        	        
							        	        	        	        btnComprar = new JButton("Comprar Medicamento");
							        	        	        	        btnComprar.setBounds(10, 0, 145, 50);
							        	        	        	        panel_1.add(btnComprar);
							        	        	        	        btnComprar.addActionListener(new ActionListener() {
							        	        	        	        	public void actionPerformed(ActionEvent e) {
							        	        	        	        		CompraMedicamentos CM=new CompraMedicamentos();
							        	        	        	        		CM.frmMedicamentos.setVisible(true);
							        	        	        	        	}
							        	        	        	        });
							        	        	        	        btnComprar.setBorder(null);
							        	        	        	        btnComprar.setVerticalAlignment(SwingConstants.BOTTOM);
							        	        	        	        btnComprar.setRolloverIcon(new ImageIcon(Frmc.class.getResource("/Imag/medicamento (1).png")));
							        	        	        	        btnComprar.setPressedIcon(new ImageIcon(Frmc.class.getResource("/Imag/medicamento (2).png")));
							        	        	        	        btnComprar.setVerticalTextPosition(SwingConstants.BOTTOM);
							        	        	        	        btnComprar.setFont(new Font("Tahoma", Font.BOLD, 10));
							        	        	        	        btnComprar.setBackground(new Color(255, 255, 255));
							        	        	        	        btnComprar.setForeground(new Color(0, 0, 0));
							        	        	        	        btnComprar.setHorizontalTextPosition(SwingConstants.CENTER);
							        	        	        	        btnComprar.setContentAreaFilled(false);
							        	        	        	        btnComprar.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/medicamento (2).png")));

			
			
			
	    }
	    public void HoraMX() {
	    	new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ZonedDateTime mexicoTime = ZonedDateTime.now(ZoneId.of("America/Mexico_City"));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					lblHora.setText("Hora: "+mexicoTime.format(formatter));
				}
			}).start();
	    }
}
