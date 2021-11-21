package mayusculas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hijo {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String cadena="";
		try {
		while((cadena=br.readLine())!=null) {
			System.out.println(cadena.toUpperCase());
		}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
