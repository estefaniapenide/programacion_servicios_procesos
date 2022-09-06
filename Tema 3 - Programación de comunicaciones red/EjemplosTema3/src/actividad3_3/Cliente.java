package actividad3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost";
		int Port = 6000;
		try {
			Socket cliente = new Socket(Host, Port);

			// FLUJO DE ENTRADA
			InputStream entrada = null;
			entrada = cliente.getInputStream();
			DataInputStream fentrada = new DataInputStream(entrada);

			// FLUJO DE SALODA
			OutputStream salida = null;
			salida = cliente.getOutputStream();
			DataOutputStream fsalida = new DataOutputStream(salida);
			
			String mensaje= fentrada.readUTF().toLowerCase();
			
			fsalida.writeUTF(mensaje);

			entrada.close();
			fentrada.close();
			salida.close();
			fsalida.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
