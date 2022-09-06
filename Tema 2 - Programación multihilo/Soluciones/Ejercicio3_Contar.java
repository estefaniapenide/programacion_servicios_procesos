package EjerciciosGarceta;

import java.io.*;


public class Ejercicio3_Contar {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Faltan argumentos en main...");
			return;
		}
		
		for (int i = 0; i < args.length; i++) {
			File fichero = new File(args[i]); // declarar fichero	
			
			if (fichero.exists()) {	
				FileReader fic = new FileReader(fichero); // crear el flujo de entrada
				
				long t_comienzo = System.currentTimeMillis();				
				int c=ContarCaracteres(fic);						
				long t_fin = System.currentTimeMillis();
				long tiempoTotal = t_fin - t_comienzo ;				
				System.out.printf("Caracteres de %s => %d %n "
						+ "   El proceso ha tardado: %d milisegundos %n", args[i], c, tiempoTotal);
							
				fic.close(); // cerrar fichero		
			} else
				System.out.printf("El fichero [%s] no existe...%n", args[i]);
		}
	}//main

	private static int ContarCaracteres(FileReader fic) throws IOException {
		int i;
		int c = 0;
		while ((i = fic.read()) != -1) // se va leyendo un carácter
			c++;
		return c;
		
	}
}
