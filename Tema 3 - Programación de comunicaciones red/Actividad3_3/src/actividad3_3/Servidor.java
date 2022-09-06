package actividad3_3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

public class Servidor {

	public static void main(String[] args) {
		
System.out.println("PROGRAMA SERVIDOR");
		try {
		ServerSocket serverSocket = new ServerSocket();
		
		InetSocketAddress addr = new InetSocketAddress("localhost",5555);
		serverSocket.bind(addr);
		
		Socket cliente = serverSocket.accept();
		
		OutputStream os = cliente.getOutputStream();
		
		String cadena ="MENSAJE AL CLIENTE";
		os.write(cadena.getBytes());
	
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
