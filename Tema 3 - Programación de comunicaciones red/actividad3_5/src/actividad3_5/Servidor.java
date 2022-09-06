package actividad3_5;

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
		
		for (int i=0;i<3;i++) {
			
			Socket cliente = serverSocket.accept();
			int numCliente=i+1;
			String mensaje ="Eres el cliente "+numCliente;
			OutputStream os = cliente.getOutputStream();
			os.write(mensaje.getBytes());
			
		}
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
