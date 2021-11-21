package ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo8_2 {

	public static void main(String[] args) {
		
		File fBat = new File ("fichero.bat");
		File fOut = new File ("ficherosalida.txt");
		File fError = new File("ficheroerror.txt");
		
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		pb.redirectInput(ProcessBuilder.Redirect.from(fBat));
		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
		pb.redirectError(ProcessBuilder.Redirect.to(fError));
		
		try {
		Process p = pb.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
