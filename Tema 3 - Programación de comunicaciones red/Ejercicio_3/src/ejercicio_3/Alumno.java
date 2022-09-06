package ejercicio_3;

import java.io.Serializable;

public class Alumno implements Serializable{
	
	private String idAlumno;
	private String nombre;
	private Curso curso;
	private int nota;
	
	public Alumno() {}
	
	public Alumno(String idAlumno, String nombre, Curso curso, int nota) {
		this.idAlumno=idAlumno;
		this.nombre=nombre;
		this.curso=curso;
		this.nota=nota;
	}
	
	public String getIdAlumno() {
		return idAlumno;
	}
	
	public void setIdAlumno(String idAlumno) {
		this.idAlumno=idAlumno;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso=curso;
	}
	
	public int getNota() {
		return nota;
	}
	
	public void setNota(int nota) {
		this.nota=nota;
	}

}
