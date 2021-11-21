import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

// probamos a crear un proceso hijo, comunicarnos con él E/S y finalizar su ejecución
public class Aleatorios {

	public static void main(String[] args) {
		
		String line;
		try {
			File directorio = new File(".\\bin");
			ProcessBuilder pb = new ProcessBuilder("java", "GenerarAleatorios");
			pb.directory(directorio);
			Process hijo = pb.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			String lineRec;
			while ((lineRec = in.readLine()).compareTo("fin") != 0) {
				//ps.println(lineRec);
				ps.println(" "); // No es necesario escribir nada en concreto, da igual que cadena
				// de hecho la cadena tecleada por usuario no la recogemos.
				ps.flush(); // Asegura que los datos se han enviado

				if ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} // fin while
			
			System.out.println("Finalizando");
			hijo.destroy();

		} catch (IOException e) {
			System.out.println("Error ocurrió durante la ejecución.Descripción del error:" + e.getMessage());
		}
	}
}
