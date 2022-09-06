package Ejercicios_Sonia.EjemploComienzoClase;

public class Profesor extends Thread {
	String nombre;
	Bienvenida saludo;

	public Profesor(String nombre, Bienvenida bienvenida) {
		this.nombre = nombre;
		this.saludo = bienvenida;
	}

	public void run() {
		System.out.println(nombre + " llegó");
		try {
			Thread.sleep(1000);
			saludo.llegadaProfesor(nombre);
		} catch (InterruptedException ex) {
			System.err.println("Thread profesor interrumpido");
			System.exit(-1);
		}
	}

}
