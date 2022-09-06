package actividad3_9_ejercicio_5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		int Port = 44444;
		System.out.println("SERVIDOR");

		try {
			System.out.println("Servidor iniciado...");
			ServerSocket servidor = new ServerSocket(Port);

			while (true) {
				
				Socket cliente = servidor.accept();
				HiloServidor hilo = new HiloServidor(cliente);
				hilo.start();
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
