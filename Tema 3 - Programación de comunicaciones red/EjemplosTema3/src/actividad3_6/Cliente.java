package actividad3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		try {
			DatagramSocket cliente = new DatagramSocket();

			int Puerto = 12345;// Puerto servidor
			InetAddress IPServidor = InetAddress.getLocalHost();// host servidor

			byte[] bufer = new byte[1024];

			DatagramPacket envio;
			DatagramPacket recibo;
			String mensaje = "";

			cliente.setSoTimeout(5000);

			do {
				System.out.println("Mensaje: ");
				mensaje = input.nextLine();

				bufer = mensaje.getBytes();

				// ENVIANDO DATAGRAMA AL SERVIDOR
				envio = new DatagramPacket(bufer, bufer.length, IPServidor, Puerto);
				cliente.send(envio);

				// ESPERANDO DATAGRAMA
				recibo = new DatagramPacket(bufer, bufer.length);
				//try {
					cliente.receive(recibo);
					mensaje = new String(recibo.getData()).trim();
					System.out.println(mensaje);
				//} catch (InterruptedException Ex) {
				//	System.out.println("No se ha recibido el paquete");
				//}

			} while (!mensaje.equals("*"));

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
