package ClasesP;

import Datas.DataMedicamento;

public class Medicamento {
int idMedicamento;
String Medicamento;
String Provedor;
String Tipo;
String Stock;
String Precio;
int idProvedor;
DataMedicamento DMM=new DataMedicamento();

public boolean insertarMedicamento() {
	if(DMM.insertarMedicamento(this)) {
		return true;
	}
	return false;
}

public boolean cargarM() {
	if(DMM.cargarM(this)) {
		return true;
	}
	return false;
}

public Medicamento() {
	
}

public int getIdMedicamento() {
	return idMedicamento;
}

public void setIdMedicamento(int idMedicamento) {
	this.idMedicamento = idMedicamento;
}

public String getMedicamento() {
	return Medicamento;
}

public void setMedicamento(String medicamento) {
	Medicamento = medicamento;
}

public String getProvedor() {
	return Provedor;
}

public void setProvedor(String provedor) {
	Provedor = provedor;
}

public String getTipo() {
	return Tipo;
}

public void setTipo(String tipo) {
	Tipo = tipo;
}

public String getStock() {
	return Stock;
}

public void setStock(String stock) {
	Stock = stock;
}

public String getPrecio() {
	return Precio;
}

public void setPrecio(String precio) {
	Precio = precio;
}

public int getIdProvedor() {
	return idProvedor;
}

public void setIdProvedor(int idProvedor) {
	this.idProvedor = idProvedor;
}

public DataMedicamento getDMM() {
	return DMM;
}

public void setDMM(DataMedicamento dMM) {
	DMM = dMM;
}

}
