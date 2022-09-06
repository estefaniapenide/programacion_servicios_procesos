package modificacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

import modificacion.ComunHilos;

public class HiloChat extends Thread{
	
	DataInputStream fentrada;
	MulticastSocket ms = null;
	ComunHilos comun;
	byte[] buf = new byte[1000];
	InetAddress grupo = null;
	int Puerto;// Puerto multicast

	public HiloChat(MulticastSocket ms, int Puerto, InetAddress grupo,ComunHilos comun) {
		this.ms = ms;
		this.comun = comun;
		this.Puerto=Puerto;
		this.grupo=grupo;
		try {
			// CREO FLUJO DE entrada para leer los mensajes
			DatagramPacket p = new DatagramPacket(buf, buf.length);
			ms.receive(p);
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}// ..
	
	public void run() {
		//System.out.println("NUMERO DE CONEXIONES ACTUALES: " + comun.getACTUALES());

		// NADA MAS CONECTARSE LE ENVIO TODOS LOS MENSAJES
		String texto = comun.getMensajes();
		EnviarMensajesaTodos(texto);

		while (true) {
			String cadena = "";
			try {
				cadena = fentrada.readUTF();
				if (cadena.trim().equals("*")) {// EL CLIENTE SE DESCONECTA
					comun.removeFromTabla(ms);//ELIMINO EL SOCKET DE QUIEN DEJA LA CONVERSACIÓN
					//comun.setACTUALES(comun.getACTUALES() - 1);
					//comun.setCONEXIONES(comun.getCONEXIONES() - 1);//AÑADIDO , pero no hace falta
					//System.out.println("NUMERO DE CONEXIONES ACTUALES: " + comun.getACTUALES());
					break;
				}
				comun.setMensajes(comun.getMensajes() + cadena + "\n");
				EnviarMensajesaTodos(comun.getMensajes());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		} // fin while

		ms.close();

	}// run
	
	// ENVIA LOS MENSAJES DEL CHAT A LOS CLIENTES
		private void EnviarMensajesaTodos(String texto) {
			int i;
			// recorremos tabla de sockets para enviarles los mensajes
			for (i = 0; i < comun.getTabla().size(); i++) {
				MulticastSocket s1 = comun.getElementoTabla(i);
				if (!s1.isClosed()) {
					try {
						DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, Puerto);
						ms.send(paquete);					
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} // for
			
		}// EnviarMensajesaTodos

}
