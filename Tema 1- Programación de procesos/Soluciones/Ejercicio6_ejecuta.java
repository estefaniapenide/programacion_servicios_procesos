import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio6_ejecuta {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.print("Introduzca la cadena: ");
		cadena = sc.nextLine();

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio5_parte1", cadena);

		// se establece el directorio donde se encuentra el ejecutable
		pb.directory(directorio);

		// REDIRIGE LA SALIDA DEL PROCESO A UN FICHERO
		//pb.redirectOutput(ProcessBuilder.Redirect.to(new File("fichero.txt")));
		
		// se ejecuta el proceso
		Process p = pb.start();
		try {
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null)
				System.out.println("ERROR >" + liner);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// COMPROBACION DE la salida del programa
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
			switch (exitVal) {
			case (0):
				System.out.println("FINAL CORRECTO...");
				break;
			case (1):
				System.out.println("FINAL INCORRECTO...");
				break;
			}

		} catch (InterruptedException e){
			e.printStackTrace();
		}

		try {
			// fichero al que se enviará la salida del programa Unsaludo
			FileOutputStream fos = new FileOutputStream("fichero.txt");
			PrintWriter pw = new PrintWriter(fos);

			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null) // lee la salida de Unsaludo
			{
				//System.out.println("INSERTO EN EL FICHERO > " + linea);
				pw.println(linea); // la inserta en el fichero
			}
			br.close();
			pw.close();
		} catch (Exception ee) 	{
			ee.printStackTrace();
		}

	}
}
