package ejemplosprocesos;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {
	
	public static void main(String[] args) throws IOException{
		//Ejecutamos el proceso DIR
		Process p = new ProcessBuilder("CMD","/C","DIR").start();
		
		//Mostramos caracter a caracter la salida generada por DIR
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
		
		//Comprobación de error - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal= p.waitFor(); //Recoge la salida de System.exit()
			System.out.println("Valor de salida: "+exitVal);
			
		}catch(InterruptedException e) {		
			e.printStackTrace();
		}
	}
	

}
