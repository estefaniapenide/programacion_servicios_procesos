package palindromo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProgramaFichero {

	public static void main(String[] args) {

		try {
			

			File ficheroError = new File("ficheroError.txt");
			ficheroError.createNewFile();

			File directorio = new File(".\\bin");

			ProcessBuilder pb = new ProcessBuilder("java", "palindromo.Palindromo");
			pb.directory(directorio);

			String linea = "";

			Process p = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			PrintStream ps = new PrintStream(p.getOutputStream());

			
			File ficheroTexto = new File("fichero.txt");
			ficheroTexto.createNewFile();
			
			BufferedReader brf =new BufferedReader(new FileReader(ficheroTexto));

			String cadena = "";


			while ((cadena = brf.readLine()) != null) {
				System.out.println(cadena);
				// Envio la cadena a Conversion
				ps.println(cadena);
				ps.flush();

				// Va leyendo lo que hay en CONVERSION
				if ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			}
			
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroError));
			
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				bw.write("ERROR >" + liner);

			}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
