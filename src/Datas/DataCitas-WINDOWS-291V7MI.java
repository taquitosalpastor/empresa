package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasesP.Citass;
import Pestañas.Citas;

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
	public ArrayList<Citass> selectCita() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Citass> listaCita=new ArrayList<Citass>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM agcitas");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Citass c=new Citass();
                c.setIdCitas(rs.getInt(1));
                c.setNomC(rs.getString(2));
                c.setFecha(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setSexo(rs.getString(5));
                c.setNumTel(rs.getString(6));
                c.setSintomas(rs.getString(7));
                c.setIduser(rs.getInt(8));
                
                listaCita.add(c);
            }
        } catch (Exception e) {
        }
        return listaCita;
    }
}
