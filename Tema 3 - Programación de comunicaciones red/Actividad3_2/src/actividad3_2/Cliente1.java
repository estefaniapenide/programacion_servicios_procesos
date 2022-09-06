package actividad3_2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente1 {

	public static void main(String[] args) {
		
		try {
		
		Socket clientSocket = new Socket();
		
		InetSocketAddress addr = new InetSocketAddress("localhost",5555);
		clientSocket.connect(addr);
		
//		OutputStream os = clientSocket.getOutputStream();
//		
//		String cadena ="Mensaje de Cliente 1";
//		os.write(cadena.getBytes());
		
		System.out.println("PROGRAMA CLIENTE 1 MOSTRANDO LOS PUERTOS A LOS QUE ESTÁ CONECTADO");
		
		System.out.println("Puerto local: "+clientSocket.getLocalPort());
		System.out.println("Puerto remoto: "+clientSocket.getPort());
		System.out.println("IP Host Remoto: "+addr.getHostName());
		
		clientSocket.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
