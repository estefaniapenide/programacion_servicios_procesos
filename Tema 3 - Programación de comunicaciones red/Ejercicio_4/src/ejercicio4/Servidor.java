package ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.out.println("Servidor iniciado...");
		
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		
		for(int i =0; i<5; i++) {
			Profesor p = new Profesor(i);
			profesores.add(p);
		}
		
		int j=1;
		
		while(true) {
			Socket cliente = servidor.accept();
			System.out.println("Cliente "+j+" conectado");
			
			// CREO FLUJO DE SALIDA AL SERVIDOR
			OutputStream salida = null;
			salida = cliente.getOutputStream();
			DataOutputStream fsalida = new DataOutputStream(salida);

			// CREO FLUJO DE ENTRADA DE SERVIDOR
			InputStream entrada = null;
			entrada = cliente.getInputStream();
			DataInputStream fentrada = new DataInputStream(entrada);
			
			//FLUJO DE SALIDA DE OBJETOS
			ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
			
			fsalida.writeInt(j);
			
			int idprofesor = fentrada.readInt();
			System.out.println("\tConsultado id: "+idprofesor+", solicitado por cliente: "+j);
			
			for(Profesor p : profesores) {
				if (p.getIdProfesor()==idprofesor) {
					outObjeto.writeObject(p);
				}else {
					outObjeto.writeObject(new Profesor("EL PROFESOR NO EXISTE"));
				}
			}
			
			j++;
			
			fentrada.close();
			fsalida.close();
			outObjeto.close();
			cliente.close();
			
		}

	}

}
