package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClasesP.Medicamento;

public class DataMedicamento {
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
	public boolean insertarMedicamento(Medicamento M) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO agmedicamento VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1,M.getIdMedicamento());
			ps.setString(2,M.getMedicamento());
			ps.setString(3, M.getProvedor());
			ps.setString(4,M.getTipo());
			ps.setString(5,M.getStock());
			ps.setString(6,M.getPrecio());
			ps.setInt(7,M.getIdProvedor());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
