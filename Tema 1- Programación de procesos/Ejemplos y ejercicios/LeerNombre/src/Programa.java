import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","LeerNombre","pepe");
		pb.directory(directorio);
		Process p = pb.start();
		
		
		
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
	
	
