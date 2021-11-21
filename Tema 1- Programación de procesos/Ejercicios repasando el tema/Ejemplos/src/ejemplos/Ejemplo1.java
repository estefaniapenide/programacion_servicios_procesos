package ejemplos;

import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		try {
			
		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		Process p = pb.start();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
