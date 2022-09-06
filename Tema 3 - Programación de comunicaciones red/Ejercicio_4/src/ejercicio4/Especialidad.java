package ejercicio4;

import java.io.Serializable;

public class Especialidad implements Serializable{
	
	private int id;
	private String nombreespe;
	
	public Especialidad() {}
	
	public Especialidad(int id, String nombreespe) {
		this.id=id;
		this.nombreespe=nombreespe;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getNombreEspe() {
		return this.nombreespe;
	}
	
	public void setNombreEspe(String nombreespe) {
		this.nombreespe=nombreespe;
	}

}
