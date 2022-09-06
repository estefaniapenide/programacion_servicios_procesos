package actividad3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		int Puerto=6000;
		String Host="localhost";
		
		System.out.println("INICIANDO SERVIDOR");
		
		ServerSocket servidor = new ServerSocket(Puerto);
		System.out.println("Esperando al cliente...");
	
		Socket  cliente = servidor.accept();
		
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		
		int numeroRecibido=0;
	
		do {
		Numeros objNumero = (Numeros) inObjeto.readObject();
		System.out.println("\nNúmero recibido:" +objNumero.getNumero());
		
		numeroRecibido=objNumero.getNumero();
		if(numeroRecibido>0 ) {
		
			long cuadradro = objNumero.getNumero()*objNumero.getNumero();
			long cubo = objNumero.getNumero()*objNumero.getNumero()*objNumero.getNumero();
		
			objNumero.setCuadrado(cuadradro);
			objNumero.setCubo(cubo);
		
			outObjeto.writeObject(objNumero);
		
			System.out.println("Respuesta enviada\n");
		
			}
		}while(numeroRecibido>0);
	
		
		inObjeto.close();
		outObjeto.close();
		cliente.close();
		servidor.close();
		
		System.out.println("\nSERVIDOR FINALIZADO");

	}

}
