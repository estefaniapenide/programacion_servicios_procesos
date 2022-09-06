package actividad3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		int Port = 6000;
		System.out.println("SERVIDOR");

		try {
			ServerSocket servidor = new ServerSocket(Port);

			Socket cliente = servidor.accept();

			// FLUJO DE ENTRADA
			ObjectInputStream entrada = null;
			

			// FLUJO DE SALODA
			ObjectOutputStream salida = null;
			

			Numeros numero= new Numeros();

			do {
				entrada = new ObjectInputStream(cliente.getInputStream());
				numero = (Numeros) entrada.readObject();
				long cua = numero.getNumero()*numero.getNumero();
				long cub = numero.getNumero()*numero.getNumero()*numero.getNumero();
				numero.setCuadrado(cua);
				numero.setCubo(cub);
				salida = new ObjectOutputStream(cliente.getOutputStream());
				salida.writeObject(numero);
			} while (numero.getNumero()>0);

			entrada.close();
			salida.close();
			cliente.close();
			servidor.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
