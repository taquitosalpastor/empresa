package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasesP.Quejas;


public class DataQuejas {
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
	public boolean InsertarQueja(Quejas QE) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO quejas VALUES(?,?,?,?,?,?)");
			ps.setInt(1,QE.getIdQuejas());
			ps.setString(2,QE.getNombre());
			ps.setString(3, QE.getTipo());
			ps.setString(4,QE.getTexto());
			ps.setString(5,QE.getFecha());
			ps.setInt(6,QE.getIduser());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Quejas> selectQueja() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Quejas> listaQueja=new ArrayList<Quejas>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM quejas");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Quejas Q=new Quejas();
                Q.setIdQuejas(rs.getInt(1));
                Q.setNombre(rs.getString(2));
                Q.setTipo(rs.getString(3));
                Q.setTexto(rs.getString(4));
                Q.setFecha(rs.getString(5));
                Q.setIduser(rs.getInt(6));
                
                listaQueja.add(Q);
            }
        } catch (Exception e) {
        }
        return listaQueja;
    }
}
