package actividad3_9_ejercicio_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HiloServidor extends Thread {

	Socket socket = null;
	
	//BufferedReader fentrada = null;
	InputStream entrada = null;
	DataInputStream fentrada =null;
	
	
	//PrintWriter fsalida = null;
	OutputStream salida = null;
	DataOutputStream fsalida=null;

	public HiloServidor(Socket socket) {
		this.socket = socket;
		try {
			
			//fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			entrada = socket.getInputStream();
			fentrada = new DataInputStream(entrada);
			
			//fsalida = new PrintWriter(socket.getOutputStream(), true);
			salida = socket.getOutputStream();
			fsalida = new DataOutputStream(salida);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String cadena = "";

		System.out.println("=> CONECTA IP / " + socket.getLocalAddress() + ", Puesrto remoto: " + socket.getPort());
		try {
			while (!cadena.trim().equals("*")) {
				//cadena = fentrada.readLine();
				cadena=fentrada.readUTF();
				
				//fsalida.println(cadena);
				fsalida.writeUTF(cadena);
			}

			System.out.println(
					"\t=> DESCONECTA IP / " + socket.getLocalAddress() + ", Puerto remoto: " + socket.getPort());

			fsalida.close();
			fentrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
