package ejercicio_3;

import java.io.Serializable;

public class Curso implements Serializable{
	
	private String id;
	private String descripcion;
	
	public Curso() {}
	
	public Curso(String id, String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}

}
