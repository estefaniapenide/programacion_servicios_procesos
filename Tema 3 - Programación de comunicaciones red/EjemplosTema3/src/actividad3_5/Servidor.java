package actividad3_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		int Port = 6000;
		System.out.println("SERVIDOR");

		try {
			ServerSocket servidor = new ServerSocket(Port);

			int n = 3;// Numero de clientes que acepta

			Socket cliente = null;

			// FLUJO DE ENTRADA
			InputStream entrada = null;
			// FLUJO DE SALODA
			OutputStream salida = null;

			for (int i = 1; i <= n; i++) {
				
				cliente = servidor.accept();

				entrada = cliente.getInputStream();
				DataInputStream fentrada = new DataInputStream(entrada);

				salida = cliente.getOutputStream();
				DataOutputStream fsalida = new DataOutputStream(salida);
				
				fsalida.writeInt(i);
				
				fentrada.close();
				fsalida.close();

			}

			entrada.close();
			salida.close();
			cliente.close();
			servidor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
