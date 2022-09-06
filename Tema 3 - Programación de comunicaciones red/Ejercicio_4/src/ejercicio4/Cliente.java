package ejercicio4;

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

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto
		Socket Cliente = new Socket(Host, Puerto);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("CLIENTE INICIALIZADO");
		
		// CREO FLUJO DE SALIDA AL SERVIDOR	
		OutputStream salida = null;
		salida = Cliente.getOutputStream();
		DataOutputStream fsalida = new DataOutputStream(salida);
						 
		// CREO FLUJO DE ENTRADA DE SERVIDOR
		InputStream entrada = null;
		entrada = Cliente.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		//FLUJO DE ENTRADA DE OBJETOS
		ObjectInputStream inObjeto = new ObjectInputStream(Cliente.getInputStream());
		
		int idCliente=flujoEntrada.readInt();
		System.out.println("ID CLIENTE: "+idCliente);
		
		
		System.out.println("INTRODUCE UN ID DE PROFESOR:");
		int idprofesor = input.nextInt();
		
		fsalida.writeInt(idprofesor);
		
		System.out.println("DATOS DEL PROFESOR:");
		
		Profesor p = (Profesor) inObjeto.readObject();
		
		System.out.println("ID PROFESOR -> "+p.getIdProfesor());
		System.out.println("NOMBRE PROFESOR -> "+p.getNombre());
		
		
		
	}

}
