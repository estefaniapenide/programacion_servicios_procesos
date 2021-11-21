package aleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class Programa {

	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "aleatorios.GeneraNumeroAleatorio");
		pb.directory(directorio);
		
		Process p = pb.start();
		// OutputStream os = p.getOutputStream();
		PrintStream ps = new PrintStream(p.getOutputStream());

		InputStream is = p.getInputStream();
		BufferedReader brIs = new BufferedReader(new InputStreamReader(is));

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		
		String cadena = "";
		
		System.out.println("Introduzca un caracter para recibir un número:");

		while (!(cadena=br.readLine()).equals("fin")) {
	
			// os.write(cadena.getBytes());
			// os.write("\n".getBytes());
			// os.flush();
			ps.println(cadena);
			ps.flush();

			String linea = "";
			if ((linea = brIs.readLine()) != null) {
				System.out.println(linea);
			}
		}
		System.out.println("Programa finalizado");
		p.destroy();

	}

}
