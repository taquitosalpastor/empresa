package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasesP.Citass;


public class DataCitas {
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
	public boolean insertarCita(Citass C) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO agcitas VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1,C.getIdCitas());
			ps.setString(2,C.getNomC());
			ps.setString(3, C.getFecha());
			ps.setString(4,C.getDireccion());
			ps.setString(5,C.getSexo());
			ps.setString(6,C.getNumTel());
			ps.setString(7,C.getSintomas());
			ps.setInt(8,C.getIduser());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Citass> selectCitas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Citass> listaCitas=new ArrayList<Citass>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM agcitas");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Citass Ci=new Citass();
                Ci.setIdCitas(rs.getInt(1));
                Ci.setNomC(rs.getString(2));
                Ci.setFecha(rs.getString(3));
                Ci.setDireccion(rs.getString(4));
                Ci.setSexo(rs.getString(5));
                Ci.setNumTel(rs.getString(6));
                Ci.setSintomas(rs.getString(7));
                Ci.setIduser(rs.getInt(8));
                
                listaCitas.add(Ci);
            }
        } catch (Exception e) {
        }
        return listaCitas;
    }
}
