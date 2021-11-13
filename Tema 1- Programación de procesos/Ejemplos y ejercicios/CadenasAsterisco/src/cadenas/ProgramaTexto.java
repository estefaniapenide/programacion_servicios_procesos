package cadenas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProgramaTexto {

	public static void main(String[] args) {
		
		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "cadenas.Cadenas");
		pb.directory(directorio);

		String linea = "";

		try {
			File fichero = new File("fichero.txt");
			fichero.createNewFile();
			
			Process p = pb.start();
			

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			PrintStream ps = new PrintStream(p.getOutputStream());

			BufferedReader brf =new BufferedReader(new FileReader(fichero));
			

			String cadena = "";
			while (!cadena.equals("*") && (cadena=brf.readLine())!=null) {
				//System.out.println("Introduzca una cadena: ");
				cadena = brf.readLine();
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
