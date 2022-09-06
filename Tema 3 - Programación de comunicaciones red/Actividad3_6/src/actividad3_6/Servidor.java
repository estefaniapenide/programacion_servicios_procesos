package actividad3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("PROGRAMA SERVIDOR");
		
		DatagramSocket socket = new DatagramSocket(12345);
		
		InetAddress IPCliente = InetAddress.getLocalHost();
		int puerto =12346;
		
		String paquete="";
		
		while(!paquete.equals("*")) {
		
		byte[] bufer = new byte[1024];
		
		DatagramPacket recibo = new DatagramPacket (bufer, bufer.length);
		
		socket.receive(recibo);
		
		int byteRec = recibo.getLength();
		paquete = new String(recibo.getData());
		
		System.out.println("MENSAJE RECIBIDO:");
		System.out.println(paquete);
		
		String paquetemayus=paquete.toUpperCase();
		
		
		byte[] enviar = new byte[1024];
		enviar=paquetemayus.getBytes();
		
		DatagramPacket envio = new DatagramPacket(enviar, enviar.length, IPCliente, puerto);
		
		socket.send(envio);
		
		}
	}

}
