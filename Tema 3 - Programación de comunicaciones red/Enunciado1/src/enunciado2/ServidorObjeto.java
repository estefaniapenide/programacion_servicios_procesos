package enunciado2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorObjeto {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		ServerSocket servidor;
		servidor = new ServerSocket(4444);
		
		System.out.println("Servidor iniciado");
		
		Socket cliente = new Socket();
		cliente = servidor.accept();
		
		System.out.println("Servidor esperando DATOS DEL CLIENTE...");
		
		
		//FLUJO DE ENTRADA DE OBJETOS
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
				
		
		
		Cubo cubo = (Cubo) inObjeto.readObject();
		
		System.out.println("Número recibido: "+cubo.getNum());
		
		int cuadrado = cubo.getNum()*cubo.getNum();
		int cubo1 =cubo.getNum()*cubo.getNum()*cubo.getNum();
		
		Cubo cuboCalculado = new Cubo(cubo.getNum(),cuadrado,cubo1);
		
		//FLUJO DE SALIDA DE OBJETOS
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		outObjeto.writeObject(cuboCalculado);

		
		System.out.println("Respuesta enviada");
		
		outObjeto.close();
		inObjeto.close();
		cliente.close();

	}

}
