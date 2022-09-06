package enunciado3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente3 {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		InetAddress destino = InetAddress.getLocalHost();
		int port =12345;
		
		DatagramSocket socket = new DatagramSocket(34567);
		
		byte[] mensaje = new byte[1024];
		byte[] mensaje2 = new byte[1024];
		
		System.out.println("Usuario:");
		String usuario = input.nextLine();
		mensaje = usuario.getBytes();
		
		DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length,destino,port);
		socket.send(envio);
		
		System.out.println("Contraseña:");
		String password = input.nextLine();
		mensaje=password.getBytes();
		DatagramPacket envio2 = new DatagramPacket(mensaje,mensaje.length,destino,port);
		socket.send(envio2);
		
		socket.close();

	}

}
