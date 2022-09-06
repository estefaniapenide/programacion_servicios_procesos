package enunciado3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor3 {

	public static void main(String[] args) throws IOException {
		
		byte[] bufer = new byte[1024];
		
		DatagramSocket socket = new DatagramSocket(12345);
		
		System.out.println("Esperando Datagrama...");
		
		DatagramPacket recibo = new DatagramPacket(bufer,bufer.length);
		socket.receive(recibo);
		int bytesRec = recibo.getLength();
		String usuario = new String(recibo.getData());
		
		
		DatagramPacket recibo2 = new DatagramPacket(bufer,bufer.length);
		socket.receive(recibo2);
		int bytesRec2 = recibo2.getLength();
		String password = new String(recibo2.getData());
		
		if(usuario.equals("alumno") && password.equals("java")) {
			System.out.println("USUARIO Y CONTRASEÑA CORRECTOS");
		}else {	
			System.out.println("INCORRECTOS");		
		}
		
		
		socket.close();
	}

}
