package almacensalidatexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploLectura {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		System.out.println("Introduzca una cadena de texto: ");
		
		try {
		String cadena=br.readLine();
		
		System.out.println("Cadena escrita: "+cadena);
		
		in.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
