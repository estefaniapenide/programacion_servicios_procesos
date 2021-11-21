package errores;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo3errores {

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
		
		InputStream er = p.getErrorStream();
		BufferedReader brEr = new BufferedReader(new InputStreamReader(er));
		String error="";
		while((error=brEr.readLine())!=null) {
			System.out.println("ERROR > "+error);
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
