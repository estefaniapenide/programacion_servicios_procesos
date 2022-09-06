package enunciado2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteObjeto {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		String Host="localhost";
		int Puerto = 4444;//puerto remoto
		Socket cliente = new Socket(Host,Puerto);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Número:");
		int num = input.nextInt();
		
		Cubo cubo = new Cubo(num);
		
		
		
		//FLUJO DE SALIDA DE OBJETOS
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		outObjeto.writeObject(cubo);
		

		//FLUJO DE ENTRADA DE OBJETOS
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Cubo cuborecibido =(Cubo)inObjeto.readObject();

		
		System.out.println("NÚMERO ENVIADO: "+cuborecibido.getNum());
		System.out.println("CUADRADO RECIBIDO: "+cuborecibido.getCuadrado());
		System.out.println("CUBO RECIBIDO: "+cuborecibido.getCubo());
		
		inObjeto.close();
		outObjeto.close();
		cliente.close();

	}

}
