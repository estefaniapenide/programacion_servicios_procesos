package ejercicio_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;


public class Servidor {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		
		Curso curso1 = new Curso("1","PSP");
		Curso curso2 = new Curso("2","AADD");
		
		Alumno alumno1 = new Alumno("1","Juan",curso1,5);
		Alumno alumno2 = new Alumno("2","Pedro",curso1,9);
		Alumno alumno3 = new Alumno("3","Paula",curso2,10);
		Alumno alumno4 = new Alumno("4","Laura",curso1,7);
		Alumno alumno5 = new Alumno("5","Mónica",curso2,4);
		
		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		alumnos.add(alumno4);
		alumnos.add(alumno5);
		

		
		
		int Puerto=6000;
		DatagramSocket servidor = new DatagramSocket(Puerto);
		
		System.out.println("SERVIDOR INICIADO\n");
		
		
		
		while(true) {
			
			System.out.println("\nEsperando al cliente...");
			
			byte[] recibidos = new byte[1024];
			DatagramPacket paqRecibido = new DatagramPacket(recibidos,recibidos.length);
			servidor.receive(paqRecibido);
			
			ByteArrayInputStream ibs = new ByteArrayInputStream(recibidos);
			ObjectInputStream inObjeto = new ObjectInputStream(ibs);
			String idAlumno = (String) inObjeto.readObject();
			inObjeto.close();
			
			System.out.println("\nIDENTIFICADOR RECIBIDO: "+idAlumno);
			
			Alumno alumno = new Alumno();
			
			for(Alumno al: alumnos) {
				if(al.getIdAlumno().equals(idAlumno)) {
					alumno=al;
				}
			}
			
			InetAddress IPCliente = paqRecibido.getAddress();
			int puertoCliente = paqRecibido.getPort();
			
			ByteArrayOutputStream obs = new ByteArrayOutputStream();
			ObjectOutputStream outObjeto = new ObjectOutputStream(obs);
			outObjeto.reset();
			outObjeto.writeObject(alumno);
			outObjeto.close();
			
			byte[] enviados = obs.toByteArray();
			DatagramPacket paqEnviado = new DatagramPacket(enviados,enviados.length,IPCliente,puertoCliente);
			servidor.send(paqEnviado);
			
			System.out.println("Enviando datos...");
		}
		

	}

}
