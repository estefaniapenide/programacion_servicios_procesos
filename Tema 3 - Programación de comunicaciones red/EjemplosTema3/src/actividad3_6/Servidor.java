package actividad3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {

		try {

			byte[] bufer = new byte[1024];

			// ASOCIANDO EL DATAGRAMA AL PUERTO 12345
			DatagramSocket servidor = new DatagramSocket(12345);

			DatagramPacket recibo;
			DatagramPacket envio;
			String mensaje = "";
			
			do {
				// ESPERANDO DATAGRAMA
				recibo = new DatagramPacket(bufer, bufer.length);
				servidor.receive(recibo);
				
				mensaje = new String(recibo.getData()).trim().toUpperCase();

				// DEVOLVIENDO EL MENSAJE
				InetAddress IPOrigen = recibo.getAddress();
				int puerto = recibo.getPort();

				bufer = mensaje.getBytes();
				envio = new DatagramPacket(bufer, bufer.length, IPOrigen, puerto);
				servidor.send(envio);

			} while (!mensaje.equals("*"));

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
