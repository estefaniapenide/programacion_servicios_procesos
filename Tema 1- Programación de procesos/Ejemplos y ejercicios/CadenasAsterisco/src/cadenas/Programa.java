package cadenas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Programa {

	public static void main(String[] args) {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "cadenas.Cadenas");
		pb.directory(directorio);

		String linea = "";

		try {
			Process p = pb.start();
			
	

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			PrintStream ps = new PrintStream(p.getOutputStream());

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader bre = new BufferedReader(in);

			String cadena = "";
			while (!cadena.equals("*")) {
				System.out.println("Introduzca una cadena: ");
				cadena = bre.readLine();
				ps.println(cadena);
				ps.flush();

				if ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			}

			int exitVal;
			exitVal = p.waitFor(); // Recoge la salida de System.exit()
			System.out.println("Valor de salida: " + exitVal);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
