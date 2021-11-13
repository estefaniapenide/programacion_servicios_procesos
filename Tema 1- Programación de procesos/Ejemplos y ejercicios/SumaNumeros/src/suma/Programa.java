package suma;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) {
		
		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "suma.SumaNumeros","1","5");
		pb.directory(directorio);
		
		try {
		String linea="";
		
		Process p = pb.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
