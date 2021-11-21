package redirect;

import java.io.File;
import java.io.IOException;

public class Ejemplo5Redirect {

	public static void main(String[] args) {
		
		File directorio = new File(".\\bin");
		
		File fTexto = new File("FicheroTextoEntrada.txt");
		File fOut = new File("salida.txt");
		File fError = new File("errores.txt");
		
		ProcessBuilder pb = new ProcessBuilder("java","redirect.EjemploLectura");
		pb.directory(directorio);
		
		pb.redirectInput(ProcessBuilder.Redirect.from(fTexto));
		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		pb.redirectError(ProcessBuilder.Redirect.to(fError));
		
		try {
		Process p = pb.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
