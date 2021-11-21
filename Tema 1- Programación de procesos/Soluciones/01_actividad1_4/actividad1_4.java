import java.io.*;

public class actividad1_4 {
	public static void main(String[] args) throws IOException {
		// creamos objeto File al directorio donde esta el programa
		File directorio = new File(".\\bin");
		//File directorio = new File("bin");

		//Valor de salida 1 
		ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre", "Maria Jesús");
		
		//Valor de salida -1
		//ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre");

		// se establece el directorio donde se encuentra el ejecutable
		pb.directory(directorio);

		// se ejecuta el proceso
		Process p = pb.start();

		// obtener la salida devuelta por el proceso
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMPROBACIÓN DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}// Ejemplo2
