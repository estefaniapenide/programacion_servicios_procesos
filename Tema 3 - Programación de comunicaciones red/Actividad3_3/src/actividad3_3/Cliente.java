package actividad3_3;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try {
		
		Socket clientSocket = new Socket();
		
		InetSocketAddress addr = new InetSocketAddress("localhost",5555);
		clientSocket.connect(addr);
		
		InputStream is = clientSocket.getInputStream();
		byte[] mensaje = new byte[25];
		is.read(mensaje);
		
		System.out.println("Mensaje recibido del servidor: "+new String(mensaje).toLowerCase());
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
