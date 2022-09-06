package enunciado1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor;
		servidor = new ServerSocket(4444);
		
		System.out.println("Servidor iniciado");
		
		Socket cliente = new Socket();
		cliente = servidor.accept();
		
		System.out.println("Servidor esperando DATOS DEL CLIENTE...");
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = null;
		salida = cliente.getOutputStream();
		DataOutputStream fsalida = new DataOutputStream(salida);

		// CREO FLUJO DE ENTRADA DE CLIENTE
		InputStream entrada = null;
		entrada = cliente.getInputStream();
		DataInputStream fentrada = new DataInputStream(entrada);
		
		int num=fentrada.readInt();
		
		int doble = num*2;
		
		System.out.println("Número recibido: "+num);
		
		fsalida.writeInt(num);
		fsalida.writeInt(doble);
		
		System.out.println("Respuesta enviada");
		
		fentrada.close();
		fsalida.close();
		cliente.close();

	}

}
