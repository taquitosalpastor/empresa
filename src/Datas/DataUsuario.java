package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import ClasesP.Usuario;

public class DataUsuario {
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
	public boolean login (Usuario U) {
		try {
			PreparedStatement ps= Conectar().prepareStatement("SELECT * FROM usuario WHERE Nombre=? AND Contraseña=?");
			ps.setString(1, U.getNombre());
			ps.setString(2, U.getContraseña());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				U.setNombre(rs.getString(2));
				U.setContraseña(rs.getString(3));
				
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean insertarUsuario(Usuario U) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO usuario VALUES(?,?,?)");
			ps.setInt(1,U.getIduser());
			ps.setString(2,U.getNombre());
			ps.setString(3, U.getContraseña());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean cargarUsuario(Usuario U) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=Conectar().prepareStatement("SELECT * FROM usuario WHERE iduser=?");
			ps.setInt(1,U.getIduser());
			rs=ps.executeQuery();
			if(rs.next()) {
				U.setNombre(rs.getString(2));
				U.setContraseña(rs.getString(3));
				
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
}
	public boolean eliminarUsuario(int iduser) {
		PreparedStatement ps=null;
		try {
			Usuario x=new Usuario();
			x.setIduser(iduser);
			if(x.cargarUsuario()) {
				ps=Conectar().prepareStatement("DELETE FROM usuario WHERE iduser=?");
				ps.setInt(1, iduser);
				ps.execute();
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public ArrayList<Usuario> selectUsuarios() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Usuario> listaUsuario=new ArrayList<Usuario>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM usuario");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario c=new Usuario();
                c.setIduser(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setContraseña(rs.getString(3));
                
                listaUsuario.add(c);
            }
        } catch (Exception e) {
        }
        return listaUsuario;
    }
}
