package cadenas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cadenas {

	public static void main(String[] args) {
		
		try {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String cadena="";
		while(!cadena.equals("*")) {
			cadena=br.readLine();
			if(!cadena.equals("*")) {
			System.out.println(cadena);
			}
		}
		System.exit(0);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
