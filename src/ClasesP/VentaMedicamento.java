package ClasesP;

import Datas.DataVentaMedicamento;

public class VentaMedicamento {
int idVentaM;
String Producto;
int Monto;
String Fecha;
int Folio;
int Total;
int idMedicamento;
int iduser;
DataVentaMedicamento DV=new DataVentaMedicamento();


public boolean InsertarMedi() {
	if(DV.InsertarMedi(this)) {
		return true;
	}
	return false;
}

public boolean EliminarMedi() {
	if(DV.EliminarMedi(this)) {
		return true;
	}
	return false;
}

public VentaMedicamento(){
	
}

public int getIdVentaM() {
	return idVentaM;
}

public void setIdVentaM(int idVentaM) {
	this.idVentaM = idVentaM;
}

public String getProducto() {
	return Producto;
}

public void setProducto(String producto) {
	Producto = producto;
}

public int getMonto() {
	return Monto;
}

public int setMonto(int monto) {
	return Monto = monto;
}

public String getFecha() {
	return Fecha;
}

public void setFecha(String fecha) {
	Fecha = fecha;
}

public int getFolio() {
	return Folio;
}

public int setFolio(int folio) {
	return Folio = folio;
}



public int getTotal() {
	return Total;
}

public void setTotal(int total) {
	Total = total;
}

public int getIdMedicamento() {
	return idMedicamento;
}

public void setIdMedicamento(int idMedicamento) {
	this.idMedicamento = idMedicamento;
}

public int getIduser() {
	return iduser;
}

public void setIduser(int iduser) {
	this.iduser = iduser;
}

}
