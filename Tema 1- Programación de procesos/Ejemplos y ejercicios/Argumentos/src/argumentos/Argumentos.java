package argumentos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Argumentos {

	public static void main(String[] args) {
		

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "argumentos.Programa","2");
		pb.directory(directorio);

		try {
			Process p = pb.start();

			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR >" + liner);
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
