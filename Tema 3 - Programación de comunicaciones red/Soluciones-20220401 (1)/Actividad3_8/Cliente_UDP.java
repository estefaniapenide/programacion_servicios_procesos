package ActividadesGarceta.Actividad3_7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente_UDP {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

		int Puerto = 6000;// puerto remoto
		InetAddress IPServidor = InetAddress.getLocalHost();// localhost
		Scanner sc = new Scanner(System.in);

		DatagramSocket cliente = null;
		try {
			cliente = new DatagramSocket();
			System.out.println("PROGRAMA CLIENTE INICIADO....");
		} catch (ConnectException ce) {
			System.out.println("ERROR AL ESTABLECER LA CONEXIÓN CON EL SERVIDOR....");
			System.exit(0);
		}

		int numero = 0;

		do {
			System.out.print("Introduce un número: ");

			try {
				numero = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException nn) {
				sc.nextLine();
				numero = 1;
				System.out.print("\tNúmero incorrecto...\n");
				continue;
			}

			Numeros n = new Numeros();
			n.setNumero(numero);

			// CONVERTIMOS OBJETO A BYTES
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bs);

			out.reset();
			out.writeObject(n); // escribir objeto
			byte[] enviados = bs.toByteArray(); // objeto en bytes

			// envir objeto
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, Puerto);
			cliente.send(envio);

			// Se recibe un objeto
			if (numero > 0) {
				byte[] recibidos = new byte[1024];
				DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
				cliente.receive(paqRecibido); // recibo el datagrama

				// CONVERTIMOS BYTES A OBJETO
				ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
				ObjectInputStream in = new ObjectInputStream(bais);

				Numeros dato = new Numeros();
				dato = (Numeros) in.readObject();// obtengo objeto
				in.close();

				System.out.println("\tCuadrado : " + dato.getCuadrado() + ", Cubo: * " + dato.getCubo());
			}

		} while (numero > 0);

		System.out.println("CLIENTE UDP FINALIZADO....");

		// CERRAR STREAMS Y SOCKETS

		cliente.close();

	}

}
