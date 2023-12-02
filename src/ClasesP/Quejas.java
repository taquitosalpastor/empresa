package ClasesP;

import Datas.DataQuejas;

public class Quejas {
int idQuejas;
String Nombre;
String Tipo;
String Texto;
String Fecha;
int iduser;
DataQuejas DQ=new DataQuejas();

public boolean InsertarQueja() {
	if(DQ.InsertarQueja(this)) {
		return true;
	}
	return false;
}

public Quejas() {
	
}


public int getIdQuejas() {
	return idQuejas;
}


public void setIdQuejas(int idQuejas) {
	this.idQuejas = idQuejas;
}


public String getNombre() {
	return Nombre;
}


public void setNombre(String nombre) {
	Nombre = nombre;
}


public String getTipo() {
	return Tipo;
}


public void setTipo(String tipo) {
	Tipo = tipo;
}


public String getTexto() {
	return Texto;
}


public void setTexto(String texto) {
	Texto = texto;
}


public String getFecha() {
	return Fecha;
}


public void setFecha(String fecha) {
	Fecha = fecha;
}


public int getIduser() {
	return iduser;
}


public void setIduser(int iduser) {
	this.iduser = iduser;
}

}
