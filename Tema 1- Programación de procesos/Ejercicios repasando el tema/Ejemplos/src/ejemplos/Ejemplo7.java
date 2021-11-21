package ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo7 {

	public static void main(String[] args) {
		
		File fError = new File ("FicheroErrores.txt");
		File fSalida = new File("FicheroSalida.txt");
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
		
		pb.redirectOutput(fSalida);
		pb.redirectError(fError);
		try {
		pb.start();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
