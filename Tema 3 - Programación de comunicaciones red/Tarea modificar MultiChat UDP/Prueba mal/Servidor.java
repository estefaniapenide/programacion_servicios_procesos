package modificacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;

import modificacion.ComunHilos;


public class Servidor {

	public static void main(String[] args) throws IOException {
		
		ArrayList<MulticastSocket> tabla = new ArrayList<MulticastSocket>();//MODIFICADO
		ComunHilos comun = new ComunHilos(tabla);
		MulticastSocket ms = null;
		byte[] buf = new byte[1000];
		InetAddress grupo = null;
		int Puerto = 12345;// Puerto multicast
		
		
		
		while(true) {
			
			// Se crea el socket multicast
			ms = new MulticastSocket(Puerto);
			grupo = InetAddress.getByName("225.0.0.1");// Grupo
		
				comun.addTabla(ms);	
				
				HiloChat hilo = new HiloChat(ms, Puerto,grupo,comun);
				hilo.start();
				
		}
		
		

	}

}
