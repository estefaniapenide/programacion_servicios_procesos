package actividad3_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost";
		int Port = 6000;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("CLIENTE");
		
		try {
			
			Socket cliente = new Socket(Host, Port);

			// FLUJO DE ENTRADA
			InputStream entrada = null;
			entrada = cliente.getInputStream();
			DataInputStream fentrada = new DataInputStream(entrada);

			// FLUJO DE SALODA
			OutputStream salida = null;
			salida = cliente.getOutputStream();
			DataOutputStream fsalida = new DataOutputStream(salida);
			
			System.out.println("Cliente: "+fentrada.readInt());

			entrada.close();
			fentrada.close();
			salida.close();
			fsalida.close();
			cliente.close();

		}  catch (IOException e) {
			e.printStackTrace();
		}

	}

}
