package asterisco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena;
		while(!(cadena=br.readLine()).equals("*")) {
			System.out.println(cadena);
		}

	}

}
