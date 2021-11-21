package ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo8 {

	public static void main(String[] args) {
		
		File fBat = new File("fichero.bat");
		File fOut = new File("salida.txt");
		File fEr = new File("errores.txt");
		
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		pb.redirectInput(fBat);
		pb.redirectOutput(fOut);
		pb.redirectError(fEr);
		try {
		pb.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
