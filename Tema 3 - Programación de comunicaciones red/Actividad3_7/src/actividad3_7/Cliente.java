package actividad3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("INICIANDO CLIENTE");
		try {
		
		String Host="localhost";
		int Puerto=6000;
		Socket cliente = new Socket(Host,Puerto);
		
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		
		int numero=0;
		
		do {
			
			System.out.println("Introduzca un número:");
			numero = input.nextInt();
	
			Numeros objNumero = new Numeros(numero,0,0);
		
			outObjeto.writeObject(objNumero);
			System.out.println("Número enviado al servidor");
		
			if(numero>0) {
			System.out.println("Esperando solución...");
	
			Numeros objNumeroRecibido = (Numeros) inObjeto.readObject();
	
			System.out.println("Cuadrado: "+objNumeroRecibido.getCuadrado());
			System.out.println("Cubo: "+objNumeroRecibido.getCubo()+"\n");
			
			}
			
		
		}while(numero>0);
		
		
		inObjeto.close();
		outObjeto.close();
		cliente.close();
		
		System.out.println("CLIENTE FINALIZADO");
		
		}catch(java.net.ConnectException E) {
			System.out.println("\nINICIE EL SERVIDOR PRIMERO");
		}
		
		

	}

}
