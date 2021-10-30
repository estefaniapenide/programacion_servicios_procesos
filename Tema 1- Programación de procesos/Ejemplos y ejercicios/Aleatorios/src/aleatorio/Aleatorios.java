package aleatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Aleatorios {

	public static void main(String[] args) throws IOException {
		String textoProgramaRandom;

		File directorio = new File(".\\bin");

		ProcessBuilder h = new ProcessBuilder("java", "aleatorio.ProgramaRandom");
		h.directory(directorio);

		Process hijo = h.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		PrintStream ps = new PrintStream(hijo.getOutputStream());

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String linea = "";
		

		while (!linea.equals("fin")) {
			
			System.out.println("Introduce un carácter:");
					
			linea = in.readLine();

			ps.println(linea);
			ps.flush();

			if((textoProgramaRandom=br.readLine())!=null) {
				System.out.println(textoProgramaRandom);
			}


		}
		
		System.out.println("Programa finalizado");
		

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
