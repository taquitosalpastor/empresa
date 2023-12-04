package Pestañas;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RepUsuario {

	public JFrame frmRepU;
	private JTable tblUsu;
	ArrayList<Usuario> listaUsuario =new ArrayList<Usuario>();
	Usuario x=null;
	int fila=0;
	int id=0;
	
	public DefaultTableModel modelo =new DefaultTableModel();
	private JScrollPane TblE;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepUsuario window = new RepUsuario();
					window.frmRepU.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RepUsuario() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void actualizarTabla() {
		DataUsuario DA=new DataUsuario();
		while (modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		listaUsuario=DA.selectUsuarios();
		for(Usuario Usuarioss : listaUsuario) {
			Object o[]=new Object[3];
			o[0]=Usuarioss.getIduser();
			o[1]=Usuarioss.getNombre();
			o[2]=Usuarioss.getContraseña();
			
			modelo.addRow(o);
			
		}
		tblUsu.setModel(modelo);
		
	}
	private void initialize() {
		frmRepU = new JFrame();
		frmRepU.setBounds(100, 100, 337, 300);
		frmRepU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRepU.getContentPane().setLayout(null);
		
		
		
		TblE = new JScrollPane();
		TblE.setBounds(0, 0, 321, 164);
		frmRepU.getContentPane().add(TblE);
		
		tblUsu = new JTable();
		tblUsu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila=tblUsu.getSelectedRow();
				x=listaUsuario.get(fila);
				x.getIduser();
				x.getNombre();
				x.getContraseña();
				}
			
			
		});
		tblUsu.setModel(new DefaultTableModel(

		));
		TblE.setViewportView(tblUsu);
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Contraseña");
		tblUsu.setModel(modelo);
		actualizarTabla();
		TblE.setViewportView(tblUsu);
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRepU.dispose();
			}
		});
		btnNewButton.setBounds(10, 185, 89, 23);
		frmRepU.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("PDF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDFU();
			}
		});
		btnNewButton_1.setBounds(116, 185, 89, 23);
		frmRepU.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RepUsuario.class.getResource("/Imag/Diseño sin título.png")));
		lblNewLabel.setBounds(0, 0, 321, 263);
		frmRepU.getContentPane().add(lblNewLabel);
	}
	public void generarPDFU() {
        try {
               FileOutputStream archivo;
               
               File file = new File("C:\\Users\\gusgu\\OneDrive\\Imágenes\\empresa\\src\\PDFTU\\PDF.pdf");
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
               
               JOptionPane.showMessageDialog(frmRepU, ""+ex.getMessage());
              
           }
   }
	public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
        java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho,alto, java.awt.Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(imgEscalada);
        return image;
    }
	
}
