package Pestañas;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ClasesP.Usuario;
import Datas.DataUsuario;

	public class Frmc {

	    public JFrame frmFarmaciaUsuario;
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
	    private JLabel lblNewLabel;
	    private JLabel lblHora;
	    private JLabel lblComprar;
	    private JLabel lblAgendarCita;
	    private JLabel lblSalir;

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
			menuBar.setBounds(0, 0, 1370, 39);
			frmFarmaciaUsuario.getContentPane().add(menuBar);
			
			mnNewMenuPDF = new JMenu("PDF             ");
			mnNewMenuPDF.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			menuBar.add(mnNewMenuPDF);
			
			lblTicketP = new JLabel("Ticket");
			lblTicketP.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblTicketP);
			
			lblEmpleadosP = new JLabel("Empleados");
			lblEmpleadosP.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					generarPDFU();
				}
			});
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
			
			mnNewMenuQuejas = new JMenu("Quejas /Sugererncias                ");
			mnNewMenuQuejas.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/buzon.png")));
			menuBar.add(mnNewMenuQuejas);
			
			lblQuejasQ = new JLabel("Quejas");
			lblQuejasQ.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/informe.png")));
			mnNewMenuQuejas.add(lblQuejasQ);
			
			lblSugerenciasS = new JLabel("Sugerencias");
			lblSugerenciasS.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/pregunta.png")));
			mnNewMenuQuejas.add(lblSugerenciasS);
			
			mnNewMenuReportes = new JMenu("Reportes            ");
			mnNewMenuReportes.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/reporte.png")));
			menuBar.add(mnNewMenuReportes);
			
			lblEmpleadosR = new JLabel("Empleados");
			lblEmpleadosR.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/empleado.png")));
			mnNewMenuReportes.add(lblEmpleadosR);
			
			lblProvedoresR = new JLabel("Provedores");
			lblProvedoresR.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/proveedor-hotelero.png")));
			mnNewMenuReportes.add(lblProvedoresR);
			
			mnNewMenuAdminsitrador = new JMenu("Administrador               ");
			mnNewMenuAdminsitrador.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/apoyo.png")));
			menuBar.add(mnNewMenuAdminsitrador);
			
			lblAgregarU = new JLabel("Agregar Usuarios");
			lblAgregarU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AgregarProve AGP=new AgregarProve();
					AGP.frmProvedores.setVisible(true);
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
							        	        	        	        
							        	        	        	        lblHora = new JLabel("");
							        	        	        	        lblHora.setForeground(new Color(0, 0, 0));
							        	        	        	        lblHora.setFont(new Font("Tahoma", Font.BOLD, 20));
							        	        	        	        lblHora.setBackground(new Color(182, 207, 228));
							        	        	        	        lblHora.setOpaque(true);
							        	        	        	        lblHora.setBorder(null);
							        	        	        	        lblHora.setBounds(1081, 35, 100, 61);
							        	        	        	        frmFarmaciaUsuario.getContentPane().add(lblHora);
							        	        	        	        
							        	        	        	        lblComprar = new JLabel("");
							        	        	        	        lblComprar.addMouseListener(new MouseAdapter() {
							        	        	        	        	@Override
							        	        	        	        	public void mouseClicked(MouseEvent e) {
							        	        	        	        		CompraMedicamentos CM=new CompraMedicamentos();
							        	        	        	        		CM.frmMedicamentos.setVisible(true);
							        	        	        	        	}
							        	        	        	        });
							        	        	        	        
							        	        	        	        lblAgendarCita = new JLabel("");
							        	        	        	        lblAgendarCita.addMouseListener(new MouseAdapter() {
							        	        	        	        	@Override
							        	        	        	        	public void mouseClicked(MouseEvent e) {
							        	        	        	        		Citas Cs=new Citas();
										        	        	        		Cs.frameCitas.setVisible(true);
							        	        	        	        	}
							        	        	        	        });
							        	        	        	        lblAgendarCita.setOpaque(true);
							        	        	        	        lblAgendarCita.setBackground(new Color(182, 207, 228));
							        	        	        	        lblAgendarCita.setBounds(177, 35, 135, 71);
							        	        	        	        frmFarmaciaUsuario.getContentPane().add(lblAgendarCita);
							        	        	        	        lblComprar.setBackground(new Color(182, 207, 228));
							        	        	        	        lblComprar.setBounds(10, 35, 147, 71);
							        	        	        	        frmFarmaciaUsuario.getContentPane().add(lblComprar);
							        	        	        	        
							        	        	        	        lblSalir = new JLabel("");
							        	        	        	        lblSalir.addMouseListener(new MouseAdapter() {
							        	        	        	        	@Override
							        	        	        	        	public void mouseClicked(MouseEvent e) {
							        	        	        	        		frmFarmaciaUsuario.dispose();
							        	        	        	        	}
							        	        	        	        });
							        	        	        	        lblSalir.setOpaque(true);
							        	        	        	        lblSalir.setBackground(new Color(207, 222, 235));
							        	        	        	        lblSalir.setBounds(1102, 636, 79, 53);
							        	        	        	        frmFarmaciaUsuario.getContentPane().add(lblSalir);

			
			
			
	    }
	    public void HoraMX() {
	    	new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ZonedDateTime mexicoTime = ZonedDateTime.now(ZoneId.of("America/Mexico_City"));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					lblHora.setText(mexicoTime.format(formatter));
				}
			}).start();
	    }
	    public void generarPDFU() {
	        try {
	               FileOutputStream archivo;
	               
	               File file = new File("C:\\Users\\Gustavo\\Documents\\Github\\empresa\\src\\PDFTU");
	               archivo = new FileOutputStream(file);
	               Document doc = new Document();
	               PdfWriter.getInstance(doc, archivo);
	               doc.open();
	              Image img = Image.getInstance("C:\\Users\\jonht\\OneDrive\\Escritorio\\tacos-\\src\\Imag\\FarmaciaLogo.png");

	               img.setAlignment(Element.ALIGN_CENTER);
	               img.scaleToFit(150, 150);
	               doc.add(img);
	               Paragraph p = new Paragraph(10);
	               Font negrita = new Font(Font.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
	               p.add(Chunk.NEWLINE);
	               p.add("CONTROL DE Usuarios");
	               p.add(Chunk.NEWLINE);
	               p.add(Chunk.NEWLINE);
	               p.setAlignment(Element.ALIGN_CENTER);
	               doc.add(p);
	               
	               PdfPTable tabla = new PdfPTable(5);
	               tabla.setWidthPercentage(100);
	               PdfPCell c1 = new PdfPCell(new Phrase("ID User", negrita));
	               PdfPCell c2 = new PdfPCell(new Phrase("Nombre", negrita));
	               PdfPCell c3 = new PdfPCell(new Phrase("Contraseña", negrita));
	               
	               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
	              
	               c1.setBackgroundColor(BaseColor.CYAN);
	               c2.setBackgroundColor(BaseColor.CYAN);
	               c3.setBackgroundColor(BaseColor.CYAN);
	               
	               tabla.addCell(c1);
	               tabla.addCell(c2);
	               tabla.addCell(c3);
	               
	               
	               DataUsuario DA=new DataUsuario();
	               ArrayList<Usuario> listaUsuario = DA.selectUsuarios();
	               for (Usuario c : listaUsuario) {
	                   tabla.addCell("" +c.getIduser());
	                   tabla.addCell("" + c.getNombre());
	                   tabla.addCell("" + c.getContraseña());
	                   
	               }
	               doc.add(tabla);
	               Paragraph p1 = new Paragraph(10);
	               p1.add(Chunk.NEWLINE);
	               p1.add("NÚMERO DE Usuarios: " + listaUsuario.size());
	               p1.add(Chunk.NEWLINE);
	               p1.add(Chunk.NEWLINE);
	               p1.setAlignment(Element.ALIGN_RIGHT);
	               doc.add(p1);
	               doc.close();
	               archivo.close();
	               Desktop.getDesktop().open(file);
	           } catch (FileNotFoundException ex) {
	           } catch (DocumentException ex) {
	           } catch (IOException ex) {
	               
	               JOptionPane.showMessageDialog(null, ex.getMessage());
	              
	           }
	   }
		public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
	        java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho,
	                alto, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(imgEscalada);
	        return image;
	    }
}
