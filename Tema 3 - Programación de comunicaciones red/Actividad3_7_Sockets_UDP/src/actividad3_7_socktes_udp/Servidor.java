package actividad3_7_socktes_udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		System.out.println("INICIANDO SERVIDOR");
		
		int Puerto=6000;
		DatagramSocket servidor = new DatagramSocket(Puerto);
		Numeros numero = new Numeros();
		numero.setNumero(1);
		
		
		
		System.out.println("Esperando al cliente...");
	
		
		int numeroRecibido=0;
	
		do {
				
		
			numero= new Numeros();
			byte[] recibidos = new byte[1024];
			DatagramPacket paqRecibido = new DatagramPacket(recibidos,recibidos.length);
			servidor.receive(paqRecibido);
			
			ByteArrayInputStream ibs = new ByteArrayInputStream(recibidos);
			ObjectInputStream inObjeto = new ObjectInputStream(ibs);
			numero = (Numeros) inObjeto.readObject();
			inObjeto.close();
			
		
			
			System.out.println("\nNúmero recibido:" +numero.getNumero());
		
			numeroRecibido=numero.getNumero();
			
			if(numeroRecibido>0 ) {
		
				long cuadradro = numero.getNumero()*numero.getNumero();
				long cubo = numero.getNumero()*numero.getNumero()*numero.getNumero();
		
				numero.setCuadrado(cuadradro);
				numero.setCubo(cubo);
				
				InetAddress IPCliente = paqRecibido.getAddress();
				int puertoCliente = paqRecibido.getPort();
				
			
				ByteArrayOutputStream obs = new ByteArrayOutputStream();
				ObjectOutputStream outObjeto = new ObjectOutputStream(obs);
				//outObjeto.reset();
				outObjeto.writeObject(numero);
				outObjeto.close();
				
				byte[] enviados = obs.toByteArray();
				DatagramPacket paqEnviado = new DatagramPacket(enviados,enviados.length,IPCliente,puertoCliente);
				servidor.send(paqEnviado);
				
			
				System.out.println("Respuesta enviada\n");
		
				}
		
		
		}while(numeroRecibido>0);
	
		servidor.close();
		
		System.out.println("\nSERVIDOR FINALIZADO");

	}

}
