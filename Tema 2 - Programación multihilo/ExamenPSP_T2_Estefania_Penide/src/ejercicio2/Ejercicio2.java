package ejercicio2;

import java.util.Scanner;

class Cola{
	
	private String cadena;
	private boolean disponible=false;
	
	public Cola() {}
	
	public synchronized String get() {
		if(!disponible) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		disponible=false;
		notify();
		return cadena;
	}
	
	public synchronized void put(String valor) {
		if(disponible) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		cadena=valor;
		disponible=true;
		notify();
	}
	
}

class Productor extends Thread{
	private Cola cola;
	private String cadena;
	private Scanner input;
	
	public Productor(Cola cola, Scanner input) {
		this.cola=cola;
		this.input=input;
	}
	
	public void run() {
		System.out.println("CADENA:");
		while(!input.nextLine().isEmpty()) {
			
			cadena=input.nextLine();
			cola.put(cadena);
		}
	}
}

class Consumidor extends Thread{
	private Cola cola;
	 public Consumidor(Cola cola) {
		 this.cola=cola;
	 }
	 
	 public void run() {
		 
		 String cadena="";
		 cadena=cola.get();
		 cadena=cadena.toUpperCase();
		 for(int i=0; i<cadena.length();i++) {
			 System.out.println(cadena.charAt(i));
		 }
		 
	 }
}

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
//		while(true) {
			
//			System.out.println("CADENA:");
//			String cadena = input.nextLine();
		
			Cola cola = new Cola();
			Productor productor = new Productor(cola,input);
			Consumidor consumidor = new Consumidor(cola);
		
			productor.start();
			consumidor.start();
			
//		}

		
		
//									OTRA OPCIÓN		
//		String cadena="";
//		
//		do {
//			
//			System.out.println("Introduzca una cadena (para finalizar el programa introduzca *):");
//			cadena = input.nextLine();
//		
//			Cola cola = new Cola();
//			Productor productor = new Productor(cola,cadena);
//			Consumidor consumidor = new Consumidor(cola);
//		
//			productor.start();
//			consumidor.start();
//		
//		}while(!cadena.equals("*"));
//		
//		System.out.println("\nPROGRAMA FINALIZADO");
//
//		input.close();
		

	}

}
