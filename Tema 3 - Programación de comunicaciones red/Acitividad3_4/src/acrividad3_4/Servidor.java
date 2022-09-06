package acrividad3_4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA SERVIDOR");
		try {
		ServerSocket serverSocket = new ServerSocket();
		
		InetSocketAddress addr = new InetSocketAddress("localhost",5555);
		serverSocket.bind(addr);
		
		Socket cliente = serverSocket.accept();
		
		OutputStream os = cliente.getOutputStream();
		
		InputStream is = cliente.getInputStream();
		byte[] numero = new byte[25];
		is.read(numero);
		
		System.out.println("Número del cliente: "+new String(numero));
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
