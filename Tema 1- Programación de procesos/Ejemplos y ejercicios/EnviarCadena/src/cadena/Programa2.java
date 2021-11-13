package cadena;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa2 {

	public static void main(String[] args) {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bre = new BufferedReader(in);

		try {

			System.out.println("Introduzca una cadena: ");
			String cadena = bre.readLine();

			File directorio = new File(".\\bin");

			ProcessBuilder pb = new ProcessBuilder("java", "cadena.Cadena", cadena);
			pb.directory(directorio);

			String linea = "";

			Process p = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
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
