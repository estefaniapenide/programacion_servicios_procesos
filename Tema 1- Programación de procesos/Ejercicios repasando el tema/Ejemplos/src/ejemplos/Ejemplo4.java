package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejemplo4 {

	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DATE");
		
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("15-06-2018".getBytes());
		os.flush();
		
		os.close();
		
		InputStream is = p.getInputStream();
		
		int c=0;
		while((c=is.read())!=-1) {
			System.out.print((char)c);
		}
		
		is.close();
		
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
