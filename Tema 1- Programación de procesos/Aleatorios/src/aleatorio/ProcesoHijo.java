package aleatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class ProcesoHijo {

	public static void main(String[] args) throws IOException {
		
		//Scanner input = new Scanner(System.in);
		//usar inputstreamreader en lugar de scanner
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String cadena="";
		do {
		System.out.println("Cadena:");
		cadena=br.readLine();
		//cadena = input.nextLine();
		cadena=cadena.toLowerCase();
		
		if(cadena.equals("fin")) {
			System.out.println("fin");
			System.exit(1);
		}else {
		
		int numero=(int)(Math.random()*10+1);
		System.out.println(numero);
		}
		}while(!cadena.equals("fin"));
		

	}

}
