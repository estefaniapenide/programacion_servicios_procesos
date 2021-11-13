package palindromo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Programa {

	public static void main(String[] args) {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "palindromo.Palindromo");
		pb.directory(directorio);

		String linea = "";

		try {
			Process p = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			PrintStream ps = new PrintStream(p.getOutputStream());

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader bre = new BufferedReader(in);

			String cadena = "";
			
			System.out.println("Introduzca una cadena: ");
			
			while ((cadena = bre.readLine()) != null) {
				// Envio la cadena a Conversion
				ps.println(cadena);
				ps.flush();

				// Va leyendo lo que hay en CONVERSION
				if ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
