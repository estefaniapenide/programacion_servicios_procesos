package actividad3_10_ejemplo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import actividad3_10_ejemplo.HiloServidor;

public class Servidor {

	public static void main(String[] args) {
		
		int Port=6001;
		try {
		ServerSocket servidor = new ServerSocket(Port);
		System.out.println("Servidor iniciado...");
		
		//Número a adivinar entre 1 y 25
		int numero = (int) (1+ 25*Math.random());
		System.out.println("=> NÚMERO A ADIVINAR: "+numero);
		
		//Todos los hilos comparten el objeto
		ObjetoCompartido objeto = new ObjetoCompartido(numero);
		
		int id =0;
		
		while(true) {
			Socket cliente = servidor.accept();
			id++;
			HiloServidor hilo = new HiloServidor(cliente,objeto,id);
			hilo.start();
		}
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
