package ejemplosprocesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejemplo5 {

	public static void main(String[] args) throws IOException {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","ejemplosprocesos.EjemploLectura");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("Hola Manuel\n".getBytes());
		os.flush();
		
		try {
			InputStream is = p.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
			is.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int exitVal;
		try {
			exitVal= p.waitFor(); //Recoge la salida de System.exit()
			System.out.println("Valor de salida: "+exitVal);
			
		}catch(InterruptedException e) {		
			e.printStackTrace();
		}
		

	}

}
