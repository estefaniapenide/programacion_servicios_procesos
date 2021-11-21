package ejemplos;

import java.io.IOException;

public class Ejemplo9 {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
		
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		
		try {
		Process p = pb.start();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
