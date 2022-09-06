package ejercicio4;

import java.io.Serializable;

public class Profesor implements Serializable{
	
	private int idprofesor;
	private String nombre;
	private Asignatura[] asignaturas;
	private Especialidad espe;
	
	public Profesor() {}
	
	public Profesor(String nombre) {
		this.nombre=nombre;
	}
	
	public Profesor(int idprofesor) {
		this.idprofesor=idprofesor;
	}
	
	public Profesor(int idprofesor, String nombre, Asignatura[] asignaturas, Especialidad espe) {
		this.idprofesor=idprofesor;
		this.nombre=nombre;
		this.asignaturas=asignaturas;
		this.espe=espe;
	}
	
	public int getIdProfesor() {
		return this.idprofesor;
	}
	
	public void setIdProfesor(int idprofesor) {
		this.idprofesor=idprofesor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public Asignatura[] getAsignaturas() {
		return this.asignaturas;
	}
	
	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas=asignaturas;
	}
	
	public Especialidad getEspecialidad() {
		return this.espe;
	}
	
	public void setEspecialidad(Especialidad espe) {
		this.espe=espe;
	}

}
