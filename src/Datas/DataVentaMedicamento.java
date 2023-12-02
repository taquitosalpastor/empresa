package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasesP.Provedor;
import ClasesP.VentaMedicamento;

public class DataVentaMedicamento {
	Connection cx;
	public Connection Conectar() {
		try {
			cx=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
					System.out.println("CONEXION EXITOSA");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}
	public boolean InsertarMedi(VentaMedicamento V) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO ventamedicamento VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1,V.getIdVentaM());
			ps.setString(2,V.getProducto());
			ps.setInt(3, V.getMonto());
			ps.setString(4, V.getFecha());
			ps.setInt(5, V.getFolio());
			ps.setInt(6,V.getTotal());
			ps.setInt(7, V.getIdMedicamento());
			ps.setInt(8, V.getIduser());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}	
	}
	public boolean EliminarMedi(VentaMedicamento V) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("DELETE FROM ventamedicamento WHERE(?,?,?,?,?,?,?,?)");
			ps.setInt(1,V.getIdVentaM());
			ps.setString(2,V.getProducto());
			ps.setInt(3, V.getMonto());
			ps.setString(4, V.getFecha());
			ps.setInt(5, V.getFolio());
			ps.setInt(6,V.getTotal());
			ps.setInt(7, V.getIdMedicamento());
			ps.setInt(8, V.getIduser());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}	
	}
	public ArrayList<VentaMedicamento> selectVM() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<VentaMedicamento> listaVM=new ArrayList<VentaMedicamento>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM ventamedicamento");            
            rs = ps.executeQuery();
            while (rs.next()) {
            	VentaMedicamento c=new VentaMedicamento();
                c.setIdVentaM(rs.getInt(1));
                c.setProducto(rs.getString(2));
                c.setMonto(rs.getInt(3));
                c.setFecha(rs.getString(4));
                c.setFolio(rs.getInt(5));
                c.setTotal(rs.getInt(6));
                c.setIdMedicamento(rs.getInt(7));
                c.setIduser(rs.getInt(8));
                
                listaVM.add(c);
            }
        } catch (Exception e) {
        }
        return listaVM;
    }
}
