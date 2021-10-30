package mayusculas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Mayusculas {

	public static void main(String[] args) throws IOException {
		String line;
		
		File directorio = new File(".\\bin");

		ProcessBuilder h = new ProcessBuilder("java","mayusculas.Conversion");
		h.directory(directorio);
		Process hijo = h.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		PrintStream ps = new PrintStream(hijo.getOutputStream());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String cadena;
		
		while ((cadena = in.readLine()) != null) {
		//Envio la cadena a Conversion
		ps.println(cadena);
		ps.flush();

		//Va leyendo lo que hay en CONVERSION
		if ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		}
		
		System.out.println("Finalizando");
		hijo.destroy();
		

		try {

			InputStream er = hijo.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR >" + liner);
			}

		} catch (IOException ioe) {

			ioe.printStackTrace();
		}

		int exitVal;
		try {
			exitVal = hijo.waitFor(); // Recoge la salida de System.exit()
			System.out.println("Valor de salida: " + exitVal);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
