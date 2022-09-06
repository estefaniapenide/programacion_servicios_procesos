package actividad3_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost";
		int Port = 6000;

		Scanner input = new Scanner(System.in);

		System.out.println("CLIENTE");

		try {

			Socket cliente = new Socket(Host, Port);

			// FLUJO DE ENTRADA
			ObjectInputStream entrada = null;
			
			// FLUJO DE SALODA
			ObjectOutputStream salida = null;
		
			int num = 2;
			do {
				System.out.println("Numero: ");
				num = input.nextInt();
				Numeros numero = new Numeros();
				numero.setNumero(num);
				salida = new ObjectOutputStream(cliente.getOutputStream());
				salida.writeObject(numero);
				entrada = new ObjectInputStream(cliente.getInputStream());
				Numeros recibido = (Numeros) entrada.readObject();
				System.out.println(recibido.getNumero()+" "+recibido.getCuadrado()+" "+recibido.getCubo());

			} while (num > 0);

			entrada.close();
			salida.close();
			cliente.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			System.out.println("No se ha encontrado el servidor");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
