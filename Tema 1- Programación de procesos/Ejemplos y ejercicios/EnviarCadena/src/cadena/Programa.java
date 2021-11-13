package cadena;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) {
		

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "cadena.Cadena");
		pb.directory(directorio);

		String linea = "";

		try {
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
