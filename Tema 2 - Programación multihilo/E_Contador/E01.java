
/*
 * Crea una clase Contador que será el recurso compartido por los hilos (lo que se denomina sección crítica). En esta clase:
 * ▪ define un atributo de tipo entero, inicializado a 0
 * ▪ un método en el que se devolverá el valor de la variable anterior
 * ▪ un método que establece (asigna) el valor actual a la variable
 * Clase ContadorHilo (el hilo), en donde cada hilo accederá tres veces al recurso compartido Contador y
 * lo incrementará en 1, luego dormirá un tiempo aleatorio en cada iteración.
 * Clase MainContador (el programa principal, main) que creará 4 hilos (se les pasará el nombre del hilo y
 * un objeto de la clase Contador, es decir, el recurso compartido al que accederá) y se lanzan.
 * 
 * */


class Contador {
	int cont = 0;

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public synchronized void incremento(String nombre) {
		int valor = this.getCont();
		System.out.println("Valor previo: " + valor);
		
		this.setCont(++valor); 
		System.out.println(nombre + ": Valor después: " + this.getCont());
	}
}

class ContadorHilo extends Thread {
	String nombre;
	Contador obj;

	public ContadorHilo(String nombre, Contador obj) {
		this.nombre = nombre;
		this.obj = obj;
	}

	public void run() {
		int valor;
		long tiempo;
		
		// ALTERNATIVA 1 CON BLOQUE SYNCHRONIZED
		//synchronized (obj) {
			for (int i = 0; i < 3; i++) {
				// ALTERNATIVA 1 CON BLOQUE SYNCHRONIZED
				/*valor = obj.getCont();
				System.out.println("Valor previo: " + valor);
				
				obj.setCont(++valor); 
				System.out.println("Valor después: " + obj.getCont());
				// FIN ALTERNATIVA 1 CON BLOQUE SYNCHRONIZED
				*/
				
				// ALTERNATIVA 2 CON MÉTODO SYNCHRONIZED
				obj.incremento(nombre);
				try {
					tiempo = ((int) (Math.random() * 1000));
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					System.out.println("Interrupción");
				}
			}

		//}
		System.out.println("FIN... " + nombre);
	}
}

public class E01 {
	public static void main(String[] args) {
		Contador compartido = new Contador();

		ContadorHilo h1 = new ContadorHilo("hilo1", compartido);
		ContadorHilo h2 = new ContadorHilo("hilo2", compartido);
		ContadorHilo h3 = new ContadorHilo("hilo3", compartido);
		ContadorHilo h4 = new ContadorHilo("hilo4", compartido);

		h1.start();
		h2.start();
		h3.start();
		h4.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			System.out.println("Interrupción");
		}
	}
}
