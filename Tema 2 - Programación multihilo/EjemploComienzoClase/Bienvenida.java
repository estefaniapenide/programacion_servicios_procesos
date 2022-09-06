package Ejercicios_Sonia.EjemploComienzoClase;

public class Bienvenida {
	boolean clase_comenzada;
	
	public Bienvenida() {
		this.clase_comenzada = false;
	}
	
	public synchronized void saludaProfesor() {
		try {
			while (clase_comenzada == false) {
				wait();
			}
			System.out.println("Buenos días profesor");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public synchronized void llegadaProfesor (String nombre) {
		System.out.println("Buenos días a todos, soy el profesor " + nombre);
		this.clase_comenzada = true;
		notifyAll();
	}
}
