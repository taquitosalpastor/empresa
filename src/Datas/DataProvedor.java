package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClasesP.Provedor;

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
}
