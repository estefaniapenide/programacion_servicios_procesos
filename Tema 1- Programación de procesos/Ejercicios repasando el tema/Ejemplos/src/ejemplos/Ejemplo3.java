package ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejemplo3 {

	public static void main(String[] args) {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","ejemplos.Ejemplo2");
		pb.directory(directorio);
		
		System.out.println("Directorio de trabajo: "+pb.directory());
		
		try {
		Process p = pb.start();
		
		InputStream is = p.getInputStream();
		
		int c;
		while((c=is.read())!=-1) {
			System.out.print((char)c);
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
