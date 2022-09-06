package ActividadesGarceta.Actividad3_7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Servidor_UDP {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		DatagramSocket serverSocket = new DatagramSocket(6000);

		Numeros dato = new Numeros();
		dato.setNumero(1);

		System.out.println("SERVIDOR UDP INICIADO");

		while (dato.getNumero() > 0) {

			// RECIBO DTAGRAMA
			dato = new Numeros();
			byte[] recibidos = new byte[1024];
			DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
			serverSocket.receive(paqRecibido);

			// CONVERTIMOS BYTES A OBJETO
			ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
			ObjectInputStream in = new ObjectInputStream(bais);
			dato = (Numeros) in.readObject();// obtengo objeto

			long cuadrado = dato.getNumero() * dato.getNumero();
			long cubo = cuadrado * dato.getNumero();

			dato.setCubo(cubo);
			dato.setCuadrado(cuadrado);

			System.out.println("Recibo: " + dato.getNumero());

			// DIRECCION ORIGEN
			InetAddress IPOrigen = paqRecibido.getAddress();
			int puerto = paqRecibido.getPort();

			// CONVERTIMOS OBJETO A BYTES
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bs);
			out.reset();
			out.writeObject(dato);

			byte[] bytes = bs.toByteArray(); // objeto en bytes

			// ENVIO DATAGRAMA
			DatagramPacket paqEnviado = new DatagramPacket(bytes, bytes.length, IPOrigen, puerto);
			serverSocket.send(paqEnviado);

		}

		System.out.println("SERVIDOR udp FINALIZADO....");

		// CERRAR STREAMS Y SOCKETS
		serverSocket.close();
	}

}
