package actividad3_7_socktes_udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("INICIANDO CLIENTE");
		
		
		String Host="localhost";
		int Puerto=6000;
		DatagramSocket cliente = new DatagramSocket();
		InetAddress IPServidor = InetAddress.getLocalHost();
		
		try {
		
		int numero=0;
		
		do {
			
			System.out.println("Introduzca un número:");
			numero = input.nextInt();
	
			Numeros objNumero = new Numeros(numero,0,0);
		
			ByteArrayOutputStream obs = new ByteArrayOutputStream();
			ObjectOutputStream outObjeto = new ObjectOutputStream(obs);
			//outObjeto.reset();
			outObjeto.writeObject(objNumero);
			outObjeto.close();
			
			byte[] enviados = obs.toByteArray();
			DatagramPacket paqEnviado = new DatagramPacket(enviados,enviados.length,IPServidor,Puerto);
			cliente.send(paqEnviado);
		

			
			System.out.println("Número enviado al servidor");
		
			if(numero>0) {
				
				System.out.println("Esperando solución...");
		
				byte[] recibidos = new byte[1024];
				DatagramPacket paqRecibido = new DatagramPacket(recibidos,recibidos.length);
				cliente.receive(paqRecibido);
				ByteArrayInputStream ibs = new ByteArrayInputStream(recibidos);
				ObjectInputStream inObjeto = new ObjectInputStream(ibs);
				
				Numeros objNumeroRecibido = (Numeros) inObjeto.readObject();
				inObjeto.close();
				
				System.out.println("Cuadrado: "+objNumeroRecibido.getCuadrado());
				System.out.println("Cubo: "+objNumeroRecibido.getCubo()+"\n");
				
	
			
			}
			
		
		}while(numero>0);
		
		cliente.close();
		
		System.out.println("CLIENTE FINALIZADO");
		
		}catch(java.net.ConnectException E) {
			System.out.println("\nINICIE EL SERVIDOR PRIMERO");
		}
		
		

	}

}
