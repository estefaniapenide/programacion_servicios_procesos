package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
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

			String mensaje = "";

			do  {			
				System.out.println("Cadena:");
				mensaje = input.nextLine();
				fsalida.writeUTF(mensaje);
				int recibido=fentrada.readInt();
				System.out.println(recibido);
				
			} while(!mensaje.equals("*"));
			

			entrada.close();
			salida.close();
			fentrada.close();
			fsalida.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
