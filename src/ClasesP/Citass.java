package ClasesP;

import Datas.DataCitas;

public class Citass {
	int idCitas;
	String NomC;
	String Fecha;
	String Direccion;
	String Sexo;
	String NumTel;
	String Sintomas;
	int iduser;
	DataCitas DC=new DataCitas();

	public boolean insertarCita() {
		if(DC.insertarCita(this)) {
			return true;
		}
		return false;
	}
	

	public Citass() {
		
	}

	public int getIdCitas() {
		return idCitas;
	}
	public void setIdCitas(int idCitas) {
		this.idCitas = idCitas;
	}
	public String getNomC() {
		return NomC;
	}
	public void setNomC(String nomC) {
		NomC = nomC;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getNumTel() {
		return NumTel;
	}
	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	public String getSintomas() {
		return Sintomas;
	}
	public void setSintomas(String sintomas) {
		Sintomas = sintomas;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
}
