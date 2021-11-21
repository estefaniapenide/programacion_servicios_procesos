package ejemplos;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {

	public static void main(String[] args) {
			
		try {
			
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
		Process p = pb.start();
		
		
		InputStream is = p.getInputStream();
		
		int c=0;
		while((c=is.read())!=-1) {
			System.out.print((char)c);
		}
		
		is.close();
		
		int valSalida;
		valSalida=p.exitValue();
		System.out.println("Valor de salida: "+valSalida);
		
		}catch(IOException e) {
			e.printStackTrace();
		}		

	}

}
