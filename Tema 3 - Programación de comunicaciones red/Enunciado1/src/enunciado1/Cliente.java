package enunciado1;

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
		
		String Host="localhost";
		int Puerto = 4444;//puerto remoto
		Socket cliente = new Socket(Host,Puerto);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Número:");
		int num = input.nextInt();
		
		// CREO FLUJO DE SALIDA AL SERVIDOR	
	    OutputStream salida = null;
	    salida = cliente.getOutputStream();
		DataOutputStream fsalida = new DataOutputStream(salida);
								 
		// CREO FLUJO DE ENTRADA DE SERVIDOR
		InputStream entrada = null;
		entrada = cliente.getInputStream();
		DataInputStream fentrada = new DataInputStream(entrada);
		
		fsalida.writeInt(num);
		
		int numrecibido=fentrada.readInt();
		int doblerecibido=fentrada.readInt();
		
		System.out.println("NÚMERO ENVIADO: "+numrecibido);
		System.out.println("DOBLE RECIBIDO: "+doblerecibido);
		
		fentrada.close();
		fsalida.close();
		cliente.close();


	}

}
