package EjerciciosGarceta;

import java.io.*;

class Ejercicio3Hilo extends Thread{
	
	FileReader fic;
	public Ejercicio3Hilo(FileReader fic, String nombre) {	
		this.fic = fic;
		setName(nombre);
	}

	public void run() {			
		int c=0;
		long t_comienzo = System.currentTimeMillis();				
		try {
			c=ContarCaracteres(fic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
		long t_fin = System.currentTimeMillis();
		long tiempoTotal = t_fin - t_comienzo ;
		System.out.printf("Caracteres de %s => %d %n "
				+ "   El proceso ha tardado: %d milisegundos %n", getName(), c, tiempoTotal);
		try {
			fic.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // cerrar fichero	
		
	}
	  int ContarCaracteres(FileReader fic) throws IOException {
		int i;
		int c = 0;
		while ((i = fic.read()) != -1) // se va leyendo un carácter
			c++;
		return c;
	}
	
	
}//fin del hilo

public class Ejercicio3_Contar_Hilo {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Faltan argumentos en main...");
			return;
		}
		
		for (int i = 0; i < args.length; i++) {
			File fichero = new File(args[i]); // declarar fichero			
			if (fichero.exists()) {	
				FileReader fic = new FileReader(fichero); // crear el flujo de entrada
				Ejercicio3Hilo hilo = new Ejercicio3Hilo(fic,args[i] );
				hilo.start();					
			} else
				System.out.printf("El fichero [%s] no existe...%n", args[i]);
		}
		
	}//main

	
}
