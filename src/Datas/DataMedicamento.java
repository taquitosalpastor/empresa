package Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	 public ArrayList<Medicamento> buscar(String palabra) {
	        ArrayList<Medicamento> lista2 = new ArrayList<Medicamento>();
	        PreparedStatement ps=null;
	        try {
	        	ps=Conectar().prepareStatement ("SELECT * FROM agmedicamento WHERE "
	                    + "(idMedicamento LIKE ?) OR "
	                    + "(Medicamento LIKE ?) OR"
	                    + "(Provedor LIKE ?) OR "
	                    + "(Tipo LIKE ?) OR"
	                    + "(Stock LIKE ?) OR"
	                    + "(Precio LIKE ?) OR"
	                    + "(idProvedor LIKE ?); ");
	            
	            ps.setString(1, "%" + palabra + "%");
	            ps.setString(2, "%" + palabra + "%");
	            ps.setString(3, "%" + palabra + "%");
	            ps.setString(4, "%" + palabra + "%");
	            ps.setString(5, "%" + palabra + "%");
	            ps.setString(6, "%" + palabra + "%");
	            ps.setString(7, "%" + palabra + "%");
	            //System.out.println("CONSULTA" + ps.toString());
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Medicamento p = new Medicamento();
	                p.setIdMedicamento(rs.getInt("idMedicamento"));
	                p.setMedicamento(rs.getString("Medicamento"));
	                p.setProvedor(rs.getString("Provedor"));
	                p.setTipo(rs.getString("Tipo"));
	                p.setStock(rs.getString("Stock"));
	                p.setPrecio(rs.getString("Precio"));
	                p.setIdProvedor(rs.getInt("idProvedor"));
	                lista2.add(p);
	            }
	            ps.close();
	            ps = null;
	           
	        } catch (SQLException ex) {
	            System.out.println("Error en BUSCAR");
	        }
	        return lista2;

	    }
	
	public boolean insertarMedicamento(Medicamento Mi) {
		PreparedStatement ps=null;
		try {
			ps=Conectar().prepareStatement("INSERT INTO agmedicamento VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1,Mi.getIdMedicamento());
			ps.setString(2,Mi.getMedicamento());
			ps.setString(3, Mi.getProvedor());
			ps.setString(4,Mi.getTipo());
			ps.setString(5,Mi.getStock());
			ps.setString(6,Mi.getPrecio());
			ps.setInt(7,Mi.getIdProvedor());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Medicamento> selectMedicamento() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Medicamento> listaM=new ArrayList<Medicamento>();
        try {
            ps = Conectar().prepareStatement("SELECT * FROM agmedicamento");            
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento c=new Medicamento();
                c.setIdMedicamento(rs.getInt(1));
                c.setMedicamento(rs.getString(2));
                c.setProvedor(rs.getString(3));
                c.setTipo(rs.getString(4));
                c.setStock(rs.getString(5));
                c.setPrecio(rs.getString(6));
                c.setIdProvedor(rs.getInt(7));
                
                listaM.add(c);
            }
        } catch (Exception e) {
        }
        return listaM;
    }
	public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
        }

    }
	public boolean cargarM(Medicamento U) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=Conectar().prepareStatement("SELECT * FROM agmedicamento WHERE idMedicamento=?");
			ps.setInt(1,U.getIdMedicamento());
			rs=ps.executeQuery();
			if(rs.next()) {
				U.setMedicamento(rs.getString(2));
				U.setProvedor(rs.getString(3));
				U.setTipo(rs.getString(4));
				U.setStock(rs.getString(5));
				U.setPrecio(rs.getString(6));
				U.setIdProvedor(rs.getInt(7));
				
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
}
}
