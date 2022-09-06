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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {

		try {

			byte[] bufer = new byte[1024];

			// ASOCIANDO EL DATAGRAMA AL PUERTO 12345
			DatagramSocket servidor = new DatagramSocket(12345);

			DatagramPacket recibo;
			DatagramPacket envio;
			int num = 2;
			Numeros numero = new Numeros();
			
			do {
				// ESPERANDO DATAGRAMA
				recibo = new DatagramPacket(bufer, bufer.length);
				servidor.receive(recibo);
				
				// CONVERTIMOS BYTES A OBJETO
				ByteArrayInputStream bais = new ByteArrayInputStream(bufer);
				ObjectInputStream in = new ObjectInputStream(bais);
				numero = (Numeros) in.readObject();
				in.close();
				
				long cua = numero.getNumero()*numero.getNumero();
				long cub = numero.getNumero()*numero.getNumero()*numero.getNumero();
				numero.setCuadrado(cua);
				numero.setCubo(cub);
				
				

				// DEVOLVIENDO EL MENSAJE
				InetAddress IPOrigen = recibo.getAddress();
				int puerto = recibo.getPort();
				
				// CONVERTIMOS OBJETO A BYTES
				ByteArrayOutputStream bs = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(bs);
				out.reset();
				out.writeObject(numero); // escribir objeto
				
				bufer = bs.toByteArray();

				envio = new DatagramPacket(bufer, bufer.length, IPOrigen, puerto);
				servidor.send(envio);

			} while (num>0);

		} catch (SocketException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
