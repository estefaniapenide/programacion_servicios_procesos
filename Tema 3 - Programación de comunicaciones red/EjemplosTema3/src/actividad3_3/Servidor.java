package actividad3_3;

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

			Socket cliente = servidor.accept();

			// FLUJO DE ENTRADA
			InputStream entrada = null;
			entrada = cliente.getInputStream();
			DataInputStream fentrada = new DataInputStream(entrada);

			// FLUJO DE SALODA
			OutputStream salida = null;
			salida = cliente.getOutputStream();
			DataOutputStream fsalida = new DataOutputStream(salida);
			
			String mensaje="MENSAJE DEL SERVIDOR...";
			fsalida.writeUTF(mensaje);
			
			System.out.println(fentrada.readUTF());
			

			entrada.close();
			fentrada.close();
			salida.close();
			fsalida.close();
			cliente.close();
			servidor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
