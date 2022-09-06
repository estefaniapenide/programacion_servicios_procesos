package actividad3_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) {
		
		try {
		
		System.out.println("PROGRAMA SERVIDOR");
		
		ServerSocket serverSocket = new ServerSocket();
		
		InetSocketAddress addr = new InetSocketAddress("localhost",5555);
		serverSocket.bind(addr);
	
		Socket cliente1 = serverSocket.accept();
		System.out.println("Puerto local Cliente 1:"+cliente1.getLocalPort());
		System.out.println("Puerto remoto Cliente 1:"+cliente1.getPort());
		
		Socket cliente2 = serverSocket.accept();
		System.out.println("Puerto local Cliente 2:"+cliente2.getLocalPort());
		System.out.println("Puerto remoto Cliente 2:"+cliente2.getPort());
		
//		InputStream is = cliente1.getInputStream();
//		byte[] mensaje = new byte[25];
//		is.read(mensaje);
//		
//		System.out.println("Mensaje recibido: "+new String(mensaje));
		
		serverSocket.close();
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
