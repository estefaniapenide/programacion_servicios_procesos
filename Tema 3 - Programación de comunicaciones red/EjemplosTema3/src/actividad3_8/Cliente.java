package actividad3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
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
			int num = 2;

			do {
				System.out.println("Número: ");
				num = input.nextInt();

				Numeros numero = new Numeros();
				numero.setNumero(num);

				// CONVERTIMOS OBJETO A BYTES
				ByteArrayOutputStream bs = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(bs);
				out.reset();
				out.writeObject(numero); // escribir objeto

				bufer = bs.toByteArray();

				// ENVIANDO DATAGRAMA AL SERVIDOR
				envio = new DatagramPacket(bufer, bufer.length, IPServidor, Puerto);
				cliente.send(envio);

				// ESPERANDO DATAGRAMA
				recibo = new DatagramPacket(bufer, bufer.length);
				cliente.receive(recibo);

				// CONVERTIMOS BYTES A OBJETO
				ByteArrayInputStream bais = new ByteArrayInputStream(bufer);
				ObjectInputStream in = new ObjectInputStream(bais);
				numero = (Numeros) in.readObject();
				in.close();

				System.out.println(numero.getNumero() + " " + numero.getCuadrado() + " " + numero.getCubo());

			} while (num > 0);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
