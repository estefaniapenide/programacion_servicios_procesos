package ejercicio_5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor;
		servidor = new ServerSocket(4444);
		
		System.out.println("Servidor iniciado...");
		
		while(true) {
			Socket cliente = new Socket();
			cliente = servidor.accept();
			HiloServidor hilo = new HiloServidor(cliente);
			hilo.start();
		}

	}

}
