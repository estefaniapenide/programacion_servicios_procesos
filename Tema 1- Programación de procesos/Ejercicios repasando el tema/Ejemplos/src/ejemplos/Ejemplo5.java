package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejemplo5 {

	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","ejemplos.EjemploLectura");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("Hola Manuel".getBytes());
		os.flush();
		
		os.close();
		
		InputStream in = p.getInputStream();
		int c=0;
		while((c=in.read())!=-1) {
			System.out.print((char)c);
		}
		
		InputStream er = p.getErrorStream();
		BufferedReader brEr = new BufferedReader(new InputStreamReader(er));
		String error="";
		while((error=brEr.readLine())!=null) {
			System.out.println("ERROR > "+error);
		}
		
		try {
		int valSalida=0;
		valSalida=p.waitFor();
		System.out.println("Valor de salida: "+valSalida);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
