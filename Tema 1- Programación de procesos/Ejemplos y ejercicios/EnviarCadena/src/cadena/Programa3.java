package cadena;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class Programa3 {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bre = new BufferedReader(in);

		try {
			
			File fichero = new File("fichero.txt");
			fichero.createNewFile();

			System.out.println("Introduzca una cadena: ");
			String cadena = bre.readLine();

			File directorio = new File(".\\bin");

			ProcessBuilder pb = new ProcessBuilder("java", "cadena.Cadena", cadena);
			pb.directory(directorio);

			String linea = "";

			Process p = pb.start();
			
			int exitVal;
			exitVal = p.waitFor(); // Recoge la salida de System.exit()
			System.out.println("Valor de salida: " + exitVal);

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			PrintStream fileout = new PrintStream(fichero);
			System.setOut(fileout);

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			
			}

			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
