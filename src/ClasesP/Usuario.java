package ClasesP;

import Datas.DataUsuario;

public class Usuario {
int iduser;
String Nombre;
String Contraseña;
DataUsuario DA=new DataUsuario();

public boolean login () {
	if(DA.login(this)) {
		return true;
	}else {
		
	
	return false;
}
}
public boolean insertarUsuario() {
	if(DA.insertarUsuario(this)) {
		return true;
	}
	return false;
}

public boolean cargarUsuario() {
	if(DA.cargarUsuario(this)) {
		return true;
	}
	return false;
}

public boolean eliminarUsuario(int iduser) {
	if(DA.eliminarUsuario(this.iduser)) {
		return true;
	}
	return false;
}

public Usuario() {
	
}

public int getIduser() {
	return iduser;
}

public void setIduser(int iduser) {
	this.iduser = iduser;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

public String getContraseña() {
	return Contraseña;
}

public void setContraseña(String contraseña) {
	Contraseña = contraseña;
}

}
