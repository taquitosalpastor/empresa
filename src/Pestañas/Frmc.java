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
import javax.swing.JButton;
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

import ClasesP.Citass;
import ClasesP.Provedor;
import ClasesP.Quejas;
import ClasesP.Usuario;
import Datas.DataCitas;
import Datas.DataProvedor;
import Datas.DataQuejas;
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
	    private JLabel lblAgregarU;
	    private JLabel lblAdministrarM;
	    private JLabel lblNewLabel_4;
	    private JLabel lblNewLabel;
	    private JLabel lblHora;
	    private JLabel lblComprar;
	    private JLabel lblAgendarCita;
	    private JLabel lblSalir;
	    ArrayList<Usuario> listaUsuario =new ArrayList<Usuario>();
	    ArrayList<Citass> listaCita =new ArrayList<Citass>();
	    ArrayList<Quejas> listaQuejas=new ArrayList<Quejas>();
	    ArrayList<Provedor> listaProv=new ArrayList<Provedor>();
	    private JLabel lblUsuario;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Frmc window = new Frmc(null);
	                    window.frmFarmaciaUsuario.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Frmc(String usuario) {
	        initialize();
	        HoraMX();
	    
	        lblUsuario.setText(usuario);
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
			
			lblUsuario = new JLabel("<dynamic>");
			lblUsuario.setOpaque(true);
			lblUsuario.setForeground(Color.BLACK);
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblUsuario.setBorder(null);
			lblUsuario.setBackground(new Color(182, 207, 228));
			lblUsuario.setBounds(830, 35, 125, 61);
			frmFarmaciaUsuario.getContentPane().add(lblUsuario);
	     
	        
			
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
			lblCitasP.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					generarPDFC();
				}
			});
			lblCitasP.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblCitasP);
			
			lblQuejas = new JLabel("Quejas/Sugerencias");
			lblQuejas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					generarPDFQ();
				}
			});
			lblQuejas.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblQuejas);
			
			lblProvedores = new JLabel("Provedores");
			lblProvedores.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					generarPDFP();
				}
				
			});
			lblProvedores.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/archivo-pdf.png")));
			mnNewMenuPDF.add(lblProvedores);
			
			mnNewMenuQuejas = new JMenu("Quejas /Sugererncias                ");
			mnNewMenuQuejas.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/buzon.png")));
			menuBar.add(mnNewMenuQuejas);
			
			lblQuejasQ = new JLabel("Quejas/Sugerencias");
			lblQuejasQ.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					QuejasC QEC=new QuejasC();
					QEC.frmQueja.setVisible(true);
				}
			});
			lblQuejasQ.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/informe.png")));
			mnNewMenuQuejas.add(lblQuejasQ);
			
			mnNewMenuReportes = new JMenu("Reportes            ");
			mnNewMenuReportes.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/reporte.png")));
			menuBar.add(mnNewMenuReportes);
			
			lblEmpleadosR = new JLabel("Empleados");
			lblEmpleadosR.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RepUsuario RPU=new RepUsuario();
					RPU.frmRepU.setVisible(true);
				}
			});
			lblEmpleadosR.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/empleado.png")));
			mnNewMenuReportes.add(lblEmpleadosR);
			
			lblProvedoresR = new JLabel("Provedores");
			lblProvedoresR.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RepP RP=new RepP();
					RP.frmREP.setVisible(true);
				}
			});
			lblProvedoresR.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/proveedor-hotelero.png")));
			mnNewMenuReportes.add(lblProvedoresR);
			
			mnNewMenuAdminsitrador = new JMenu("Administrador               ");
			mnNewMenuAdminsitrador.setIcon(new ImageIcon(Frmc.class.getResource("/Imag/apoyo.png")));
			menuBar.add(mnNewMenuAdminsitrador);
			
			lblAgregarU = new JLabel("Agregar Usuarios");
			lblAgregarU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AgregarUsuarios AGU=new AgregarUsuarios();
					AGU.frmAgregarUsuario.setVisible(true);
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
	    public void generarPDFC() {
	        try {
	               FileOutputStream archivo;
	               
	               File file = new File("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\PDFTU\\PDFC.pdf");
	               archivo = new FileOutputStream(file);
	               Document doc = new Document();
	               PdfWriter.getInstance(doc, archivo);
	               doc.open();
	              Image img = Image.getInstance("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\Imag\\FarmaciaLogo.png");

	               img.setAlignment(Element.ALIGN_CENTER);
	               img.scaleToFit(150, 150);
	               doc.add(img);
	               Paragraph p = new Paragraph(10);
	               com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
	               p.add(Chunk.NEWLINE);
	               p.add("CONTROL DE Citas");
	               p.add(Chunk.NEWLINE);
	               p.add(Chunk.NEWLINE);
	               p.setAlignment(Element.ALIGN_CENTER);
	               doc.add(p);
	               
	               PdfPTable tabla = new PdfPTable(8);
	               tabla.setWidthPercentage(100);
	               PdfPCell c1 = new PdfPCell(new Phrase("ID Citas", negrita));
	               PdfPCell c2 = new PdfPCell(new Phrase("NomC", negrita));
	               PdfPCell c3 = new PdfPCell(new Phrase("Fecha", negrita));
	               PdfPCell c4 = new PdfPCell(new Phrase("Direccion", negrita));
	               PdfPCell c5 = new PdfPCell(new Phrase("Sexo", negrita));
	               PdfPCell c6 = new PdfPCell(new Phrase("NumTel", negrita));
	               PdfPCell c7 = new PdfPCell(new Phrase("Sintomas", negrita));
	               PdfPCell c8 = new PdfPCell(new Phrase("ID User", negrita));
	               
	               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c7.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c8.setHorizontalAlignment(Element.ALIGN_CENTER);
	              
	               c1.setBackgroundColor(BaseColor.CYAN);
	               c2.setBackgroundColor(BaseColor.CYAN);
	               c3.setBackgroundColor(BaseColor.CYAN);
	               c4.setBackgroundColor(BaseColor.CYAN);
	               c5.setBackgroundColor(BaseColor.CYAN);
	               c6.setBackgroundColor(BaseColor.CYAN);
	               c7.setBackgroundColor(BaseColor.CYAN);
	               c8.setBackgroundColor(BaseColor.CYAN);
	               
	               tabla.addCell(c1);
	               tabla.addCell(c2);
	               tabla.addCell(c3);
	               tabla.addCell(c4);
	               tabla.addCell(c5);
	               tabla.addCell(c6);
	               tabla.addCell(c7);
	               tabla.addCell(c8);
	               
	               
	               DataCitas DC=new DataCitas();
	               listaCita = DC.selectCitas();
	               for (Citass c : listaCita) {
	                   tabla.addCell("" +c.getIdCitas());
	                   tabla.addCell("" + c.getNomC());
	                   tabla.addCell("" + c.getFecha());
	                   tabla.addCell("" + c.getDireccion());
	                   tabla.addCell("" + c.getSexo());
	                   tabla.addCell("" + c.getNumTel());
	                   tabla.addCell("" + c.getSintomas());
	                   tabla.addCell("" + c.getIduser());
	                   
	               }
	               doc.add(tabla);
	               Paragraph p1 = new Paragraph(3);
	               p1.add(Chunk.NEWLINE);
	               p1.add("NÚMERO DE Citas: " + listaCita.size());
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
	               
	               JOptionPane.showMessageDialog(frmFarmaciaUsuario, ""+ex.getMessage());
	              
	           }
	   }
		public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
	        java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho,
	                alto, java.awt.Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(imgEscalada);
	        return image;
	        
	    }
		public void generarPDFQ() {
	        try {
	               FileOutputStream archivo;
	               
	               File file = new File("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\PDFTU\\PDFQ.pdf");
	               archivo = new FileOutputStream(file);
	               Document doc = new Document();
	               PdfWriter.getInstance(doc, archivo);
	               doc.open();
	              Image img = Image.getInstance("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\Imag\\FarmaciaLogo.png");

	               img.setAlignment(Element.ALIGN_CENTER);
	               img.scaleToFit(150, 150);
	               doc.add(img);
	               Paragraph p = new Paragraph(10);
	               com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
	               p.add(Chunk.NEWLINE);
	               p.add("CONTROL DE Quejas");
	               p.add(Chunk.NEWLINE);
	               p.add(Chunk.NEWLINE);
	               p.setAlignment(Element.ALIGN_CENTER);
	               doc.add(p);
	               
	               PdfPTable tabla = new PdfPTable(6);
	               tabla.setWidthPercentage(100);
	               PdfPCell c1 = new PdfPCell(new Phrase("ID Queja", negrita));
	               PdfPCell c2 = new PdfPCell(new Phrase("Nombre", negrita));
	               PdfPCell c3 = new PdfPCell(new Phrase("Tipo", negrita));
	               PdfPCell c4 = new PdfPCell(new Phrase("Texto", negrita));
	               PdfPCell c5 = new PdfPCell(new Phrase("Fecha", negrita));
	               
	               PdfPCell c6 = new PdfPCell(new Phrase("ID User", negrita));
	               
	               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
	               
	              
	               c1.setBackgroundColor(BaseColor.CYAN);
	               c2.setBackgroundColor(BaseColor.CYAN);
	               c3.setBackgroundColor(BaseColor.CYAN);
	               c4.setBackgroundColor(BaseColor.CYAN);
	               c5.setBackgroundColor(BaseColor.CYAN);
	               c6.setBackgroundColor(BaseColor.CYAN);
	              
	               
	               tabla.addCell(c1);
	               tabla.addCell(c2);
	               tabla.addCell(c3);
	               tabla.addCell(c4);
	               tabla.addCell(c5);
	               tabla.addCell(c6);
	               
	               
	               
	               DataQuejas DQ=new DataQuejas();
	               listaQuejas = DQ.selectQueja();
	               for (Quejas Q : listaQuejas) {
	                   tabla.addCell("" + Q.getIdQuejas());
	                   tabla.addCell("" + Q.getNombre());
	                   tabla.addCell("" + Q.getTipo());
	                   tabla.addCell("" + Q.getTexto());
	                   tabla.addCell("" + Q.getFecha());
	                   
	                   tabla.addCell("" + Q.getIduser());
	                   
	               }
	               doc.add(tabla);
	               Paragraph p1 = new Paragraph(3);
	               p1.add(Chunk.NEWLINE);
	               p1.add("NÚMERO DE Quejas: " + listaQuejas.size());
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
	               
	               JOptionPane.showMessageDialog(frmFarmaciaUsuario, ""+ex.getMessage());
	              
	           }
	   }
		public void generarPDFP() {
	        try {
	               FileOutputStream archivo;
	               
	               File file = new File("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\PDFTU\\PDFP.pdf");
	               archivo = new FileOutputStream(file);
	               Document doc = new Document();
	               PdfWriter.getInstance(doc, archivo);
	               doc.open();
	              Image img = Image.getInstance("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\Imag\\FarmaciaLogo.png");

	               img.setAlignment(Element.ALIGN_CENTER);
	               img.scaleToFit(150, 150);
	               doc.add(img);
	               Paragraph p = new Paragraph(10);
	               com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
	               p.add(Chunk.NEWLINE);
	               p.add("CONTROL DE Provedores");
	               p.add(Chunk.NEWLINE);
	               p.add(Chunk.NEWLINE);
	               p.setAlignment(Element.ALIGN_CENTER);
	               doc.add(p);
	               
	               PdfPTable tabla = new PdfPTable(6);
	               tabla.setWidthPercentage(100);
	               PdfPCell c1 = new PdfPCell(new Phrase("ID Prov", negrita));
	               PdfPCell c2 = new PdfPCell(new Phrase("NomEmpresa", negrita));
	               PdfPCell c3 = new PdfPCell(new Phrase("NomLab", negrita));
	               PdfPCell c4 = new PdfPCell(new Phrase("NomProv", negrita));
	               PdfPCell c5 = new PdfPCell(new Phrase("NumeroProv", negrita));
	               
	               PdfPCell c6 = new PdfPCell(new Phrase("ID User", negrita));
	               
	               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
	               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
	               
	              
	               c1.setBackgroundColor(BaseColor.CYAN);
	               c2.setBackgroundColor(BaseColor.CYAN);
	               c3.setBackgroundColor(BaseColor.CYAN);
	               c4.setBackgroundColor(BaseColor.CYAN);
	               c5.setBackgroundColor(BaseColor.CYAN);
	               c6.setBackgroundColor(BaseColor.CYAN);
	              
	               
	               tabla.addCell(c1);
	               tabla.addCell(c2);
	               tabla.addCell(c3);
	               tabla.addCell(c4);
	               tabla.addCell(c5);
	               tabla.addCell(c6);
	               
	               
	               
	               DataProvedor Dp=new DataProvedor();
	               listaProv = Dp.selectProv();
	               for (Provedor c : listaProv) {
	                   tabla.addCell("" + c.getIdProvedor());
	                   tabla.addCell("" + c.getNomEmpresa());
	                   tabla.addCell("" + c.getNomLab());
	                   tabla.addCell("" + c.getNomProv());
	                   tabla.addCell("" + c.getNumeroProv());
	                   
	                   tabla.addCell("" + c.getIduser());
	                   
	               }
	               doc.add(tabla);
	               Paragraph p1 = new Paragraph(3);
	               p1.add(Chunk.NEWLINE);
	               p1.add("NÚMERO DE Provedores: " + listaProv.size());
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
	               
	               JOptionPane.showMessageDialog(frmFarmaciaUsuario, ""+ex.getMessage());
	              
	           }
		}
		public void generarPDFU() {
	        try {
	               FileOutputStream archivo;
	               
	               File file = new File("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\PDFTU\\PDF.pdf");
	               archivo = new FileOutputStream(file);
	               Document doc = new Document();
	               PdfWriter.getInstance(doc, archivo);
	               doc.open();
	              Image img = Image.getInstance("C:\\Users\\gusgu\\OneDrive\\Documentos\\empresa\\src\\Imag\\FarmaciaLogo.png");

	               img.setAlignment(Element.ALIGN_CENTER);
	               img.scaleToFit(150, 150);
	               doc.add(img);
	               Paragraph p = new Paragraph(10);
	               com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
	               p.add(Chunk.NEWLINE);
	               p.add("CONTROL DE Usuarios");
	               p.add(Chunk.NEWLINE);
	               p.add(Chunk.NEWLINE);
	               p.setAlignment(Element.ALIGN_CENTER);
	               doc.add(p);
	               
	               PdfPTable tabla = new PdfPTable(3);
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
	               listaUsuario = DA.selectUsuarios();
	               for (Usuario c : listaUsuario) {
	                   tabla.addCell("" +c.getIduser());
	                   tabla.addCell("" + c.getNombre());
	                   tabla.addCell("" + c.getContraseña());
	                   
	               }
	               doc.add(tabla);
	               Paragraph p1 = new Paragraph(3);
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
	               
	               JOptionPane.showMessageDialog(frmFarmaciaUsuario, ""+ex.getMessage());
	              
	           }
	   }
}
