package actividad3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		int Puerto=6000;
		try {
		System.out.println("Servidor con puerto :"+Puerto);
			
		ServerSocket servidor = new ServerSocket(Puerto);
		
		Socket cliente1 = servidor.accept();
		System.out.println("Puerto local servidor: "+cliente1.getLocalPort());
		System.out.println("Puerto remoto cliente 1: "+cliente1.getPort());
		
		Socket cliente2 = servidor.accept();
		System.out.println("Puerto local servidor: "+cliente2.getLocalPort());
		System.out.println("Puerto remoto cliente 2: "+cliente2.getPort());
		
		servidor.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
