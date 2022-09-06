package modificacion;

import java.net.MulticastSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ComunHilos {
	
	ArrayList<MulticastSocket> tabla = new ArrayList<MulticastSocket>();// SOCKETS CONECTADOS//MODIFICADO
	 String mensajes; //MENSAJES DEL CHAT
	
	 //MODIFICADO
	public ComunHilos(ArrayList<MulticastSocket> tabla) {	
		this.tabla = tabla;  
		mensajes="";        
	}

	public ComunHilos() { super(); }
	
	public String getMensajes() { return mensajes; }
	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	public ArrayList<MulticastSocket> getTabla() { return tabla; }
	
	//MODIFICADO
		public synchronized void addTabla(MulticastSocket s) {		
			tabla.add(s);
		}	
		
		//AÑADIDO
			public synchronized void removeFromTabla( MulticastSocket s) {		
				tabla.remove(s);
			}
		
		//MODIFICADO
		public MulticastSocket getElementoTabla(int i) { return tabla.get(i); }


}
