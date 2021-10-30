package ejemplosprocesos;

import java.io.IOException;

public class Ejemplo1_2 {
	public static void main(String[] args) throws IOException{
		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		Process p = pb.start();
		
	}

}
