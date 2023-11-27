package ClasesP;

import Datas.DataProvedor;

public class Provedor {
int idProvedor;
String NomEmpresa;
String NomLab;
String NomProv;
String NumeroProv;
int iduser;
DataProvedor Dp=new DataProvedor();

public boolean insertarProv() {
	if(Dp.insertarProv(this)) {
		return true;
	}
		return false;
	
}

public Provedor() {
	
}

public int getIdProvedor() {
	return idProvedor;
}
public void setIdProvedor(int idProvedor) {
	this.idProvedor = idProvedor;
}
public String getNomEmpresa() {
	return NomEmpresa;
}
public void setNomEmpresa(String nomEmpresa) {
	NomEmpresa = nomEmpresa;
}
public String getNomLab() {
	return NomLab;
}
public void setNomLab(String nomLab) {
	NomLab = nomLab;
}
public String getNomProv() {
	return NomProv;
}
public void setNomProv(String nomProv) {
	NomProv = nomProv;
}
public String getNumeroProv() {
	return NumeroProv;
}
public void setNumeroProv(String numeroProv) {
	NumeroProv = numeroProv;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
}


}
