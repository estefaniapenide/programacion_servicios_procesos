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
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
Scanner input = new Scanner(System.in);
		
		System.out.println("INICIANDO CLIENTE");
		
		DatagramSocket cliente = new DatagramSocket();
		
		
		int PuertoServidor=6000;
		InetAddress IPServidor = InetAddress.getLocalHost();
		
		String id ="";
		
		while(!id.equals("*")) {
			System.out.println("\nINTRODUZCA EL ID DEL ALUMNO:");
			id = input.nextLine();
			
			if(!id.equals("*")) {
			
				ByteArrayOutputStream obs = new ByteArrayOutputStream();
				ObjectOutputStream outObjeto = new ObjectOutputStream(obs);
				//outObjeto.reset();
				outObjeto.writeObject(id);
				outObjeto.close();
			
				byte[] enviados = obs.toByteArray();
				DatagramPacket paqEnviado = new DatagramPacket(enviados,enviados.length,IPServidor,PuertoServidor);
				cliente.send(paqEnviado);
		
				System.out.println("ID enviado al servidor.Esperando respuesta...");
			
				byte[] recibidos = new byte[1024];
				DatagramPacket paqRecibido = new DatagramPacket(recibidos,recibidos.length);
				cliente.receive(paqRecibido);
				ByteArrayInputStream ibs = new ByteArrayInputStream(recibidos);
				ObjectInputStream inObjeto = new ObjectInputStream(ibs);
			
				Alumno alumno = (Alumno) inObjeto.readObject();
				inObjeto.close();
			
				if(alumno.getIdAlumno()==null) {
					System.out.println("EL ALUMNO NO EXISTE");
				}else {
					System.out.println("DATOS DEL ALUMNO");
					System.out.println("Id: "+alumno.getIdAlumno()
					+"\nNombre: "+alumno.getNombre()
					+"\nCURSO:"
					+"\n\tNota: "+alumno.getNota()
					+"\n\tDescripcion: "+alumno.getCurso().getDescripcion()
					+"\n\tId Curso: "+alumno.getCurso().getId());
				}
			}
			
		}
		
		cliente.close();
		
		System.out.println("\nCLIENTE FINALIZADO");

	}

}
