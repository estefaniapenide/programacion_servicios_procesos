package actividad3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puerto =12345;
		
		DatagramSocket socketCliente = new DatagramSocket(12346);
		
		String cadena="";
		
		while(!cadena.equals("*")) {
		
		System.out.print("Introduce un mensaje:");
		cadena = input.nextLine();
		
		byte[] enviar = new byte[1024];
		enviar=cadena.getBytes();
		
		DatagramPacket envio = new DatagramPacket(enviar, enviar.length, IPServidor, puerto);
		
		clientSocket.send(envio);
		//clientSocket.close();
		
		System.out.println("MENSAJE DE VUELTA:");
		
		byte[] bufer = new byte[1024];
		
		DatagramPacket recibo = new DatagramPacket (bufer, bufer.length);
		
		socketCliente.receive(recibo);
		
		int byteRec = recibo.getLength();
		String paquete = new String(recibo.getData());
		
		System.out.println(paquete);
		
		}
		

	}

}
