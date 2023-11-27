package Pestañas;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;

import ClasesP.Usuario;
import Datas.DataUsuario;



public class TicketU {
	protected Object generarPDF;
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
               Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
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
