package leernombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class EjecutarLeerNombre {

	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		
		//Valor salida: 1
		ProcessBuilder pb = new ProcessBuilder("java","leernombre.LeerNombre","Juan");
		
		//Valor salida: -1
		//ProcessBuilder pb = new ProcessBuilder("java","leernombre.LeerNombre");
		
		pb.directory(directorio);
		
		Process p = pb.start();
		
		InputStream is = p.getInputStream();
		
		int c=0;
		while((c=is.read())!=-1) {
			System.out.print((char)c);
		}
		
		try {
			
			int valSalida=0;
			valSalida=p.waitFor();
			System.out.println("Valor salida: "+valSalida);
			
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		

	}

}
