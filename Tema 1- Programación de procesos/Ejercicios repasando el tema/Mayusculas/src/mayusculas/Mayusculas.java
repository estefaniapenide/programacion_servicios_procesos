package mayusculas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Mayusculas {

	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","mayusculas.hijo");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintStream ps = new PrintStream(p.getOutputStream());
		
		BufferedReader brhijo = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		String cadena="";
		while((cadena=br.readLine())!=null) {
			ps.println(cadena);
			ps.flush();
			
			String linea="";
			if((linea=brhijo.readLine())!=null) {
				System.out.println(linea);
			}
		}
		
		p.destroy();
	}

}
