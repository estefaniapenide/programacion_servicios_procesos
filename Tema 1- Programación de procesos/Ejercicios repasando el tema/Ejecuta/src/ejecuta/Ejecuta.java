package ejecuta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {

	public static void main(String[] args) {
		
		if(args.length<1) {
			System.err.print("Necesita introducir algún comando.");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
		Process p = pb.start();
		System.out.println("Ejecutando "+Arrays.toString(args));
		
		String error="";
		InputStream er = p.getErrorStream();
		BufferedReader brEr = new BufferedReader(new InputStreamReader(er));
		while((error=brEr.readLine())!=null) {
			System.out.println("ERROR > "+error);
		}
		
		int valSalida=0;
		valSalida=p.waitFor();
		System.out.println("Valor de salida: "+valSalida);
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
