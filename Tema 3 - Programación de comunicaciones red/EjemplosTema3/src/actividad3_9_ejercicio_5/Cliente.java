package actividad3_9_ejercicio_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String Host = "localhost";
		int Port = 44444;
		try {
			Socket cliente = new Socket(Host, Port);

			// FLUJO DE ENTRADA
			
			//BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			InputStream entrada = null;
			entrada = cliente.getInputStream();
			DataInputStream fentrada = new DataInputStream(entrada);
			

			// FLUJO DE SALIDA
			
			//PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(),true);
			OutputStream salida = null;
			salida = cliente.getOutputStream();
			DataOutputStream fsalida = new DataOutputStream(salida);
	
			
			System.out.println("* para desconectarse:");
			String mensaje =input.nextLine().trim();
			
			//fsalida.println(mensaje);
			fsalida.writeUTF(mensaje);
			
			//mensaje = fentrada.readLine();
			mensaje = fentrada.readUTF();
			
			System.out.println(mensaje);


			fentrada.close();
			fsalida.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
