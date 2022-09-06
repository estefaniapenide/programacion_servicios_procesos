package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto
		Socket Cliente = new Socket(Host, Puerto);
			
		// CREO FLUJO DE SALIDA AL SERVIDOR	
		OutputStream salida = null;
		salida = Cliente.getOutputStream();
		DataOutputStream fsalida = new DataOutputStream(salida);
				 
		// CREO FLUJO DE ENTRADA DE SERVIDOR
		InputStream entrada = null;
		entrada = Cliente.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		String cadena;
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce cadena: ");
		cadena = sc.nextLine();
		while(!cadena.equals("*")){	
			fsalida.writeUTF(cadena);	
			Integer longitud = flujoEntrada.readInt();
			System.out.print("\tN�mero de caracteres: "+longitud);
			System.out.println("Introduce cadena: ");
			cadena = sc.nextLine();
		} 
		fsalida.writeUTF("*");	
		fsalida.close();
		flujoEntrada.close();
		System.out.println("Fin de proceso... ");
		Cliente.close();
	
		

	}

}
