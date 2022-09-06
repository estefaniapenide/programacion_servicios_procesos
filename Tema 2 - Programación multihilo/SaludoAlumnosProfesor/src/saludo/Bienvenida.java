package saludo;

public class Bienvenida {
	boolean clase_comenzada;
	
	public Bienvenida() {
		this.clase_comenzada=false;
	}
	
	public synchronized void llegaProfesor() {
		try {
		if(clase_comenzada) {
			wait();	
		}
		System.out.println("Buenos días profesor.");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void saludaProfesor() {
		System.out.println("Hola, soy el profesor.");
		this.clase_comenzada=true;
		notifyAll();
	}
	
	


}
