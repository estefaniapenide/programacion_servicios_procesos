package actividad3_2;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost";
		int Puerto = 6000;

		try {
			System.out.println("CLIENTE");
			
			Socket cliente = new Socket(Host, Puerto);
			
			System.out.println("Puerto local cliente: "+cliente.getLocalPort());
			System.out.println("Puerto remoto servidor: "+cliente.getPort());
			System.out.println("Dirección IP del servidor: "+cliente.getInetAddress());
			
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
