package ejecuta;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {

	public static void main(String[] args) throws IOException {
		
		if(args.length<=0) {
			System.err.println("Need comand to run");
			System.exit(-1);
		}

		ProcessBuilder pb = new ProcessBuilder(args);
		Process p = pb.start();
		System.out.println("Ejecutando: "+Arrays.toString(args));
		
		try {
			
			InputStream er = p.getErrorStream();
			BufferedReader brer= new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while((liner=brer.readLine())!=null) {
				System.out.println("ERROR >"+liner);
			}
			
		}catch(IOException ioe) {
			
			ioe.printStackTrace();
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
