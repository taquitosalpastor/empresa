package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClasesP.Provedor;
import ClasesP.Usuario;

public class DataProvedor {
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
	public boolean insertarProv(Provedor Pis) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO agprovedores VALUES(?,?,?,?,?,?)");
			ps.setInt(1,Pis.getIdProvedor());
			ps.setString(2,Pis.getNomEmpresa());
			ps.setString(3, Pis.getNomLab());
			ps.setString(4,Pis.getNomProv());
			ps.setString(5,Pis.getNumeroProv());
			ps.setInt(6,Pis.getIduser());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Provedor> selectProv() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Provedor> listaProv=new ArrayList<Provedor>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM agprovedores");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Provedor c=new Provedor();
                c.setIdProvedor(rs.getInt(1));
                c.setNomEmpresa(rs.getString(2));
                c.setNomLab(rs.getString(3));
                c.setNomProv(rs.getString(4));
                c.setNumeroProv(rs.getString(5));
                c.setIduser(rs.getInt(6));
                
                listaProv.add(c);
            }
        } catch (Exception e) {
        }
        return listaProv;
    }
}
