package tarea;

import java.net.Socket;
import java.util.ArrayList;

public class ComunHilos {
	 int CONEXIONES; //N� DE CONEXIONES TOTALES, OCUPADAS EN EL ARRAY //Creo que lo hay que modificar va por aquí y que estas tienen que variar en función de las actuales. O simplemente pasar de esto y gestionarlo todo con ls conexiones actuales
	 int ACTUALES;   //N�MERO DE CONEXIONES ACTUALES
	 int MAXIMO;     //M�XIMO DE CONEXIONES PERMITIDAS	
	 ArrayList<Socket> tabla = new ArrayList<Socket>();// SOCKETS CONECTADOS//MODIFICADO
	 String mensajes; //MENSAJES DEL CHAT
	
	 //MODIFICADO
	public ComunHilos(int maximo, int actuales, int conexiones, 
			ArrayList<Socket> tabla) {
		MAXIMO = maximo;	 
		ACTUALES = actuales; 
		CONEXIONES = conexiones;	
		this.tabla = tabla;  
		mensajes="";        
	}

	public ComunHilos() { super(); }

    public int getMAXIMO() { return MAXIMO;	}
	public void setMAXIMO(int maximo) { MAXIMO = maximo;}


	public int getCONEXIONES() { return CONEXIONES;	}
	public synchronized void  setCONEXIONES(int conexiones) {
		CONEXIONES = conexiones;
	}

	public String getMensajes() { return mensajes; }
	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	public int getACTUALES() { return ACTUALES; }
	public synchronized void setACTUALES(int actuales) {
		ACTUALES = actuales;
	}
	
	//MODIFICADO
	public synchronized void addTabla(Socket s) {		
		tabla.add(s);
	}	
	
	//AÑADIDO
		public synchronized void removeFromTabla(Socket s) {		
			tabla.remove(s);
		}
	
	//MODIFICADO
	public Socket getElementoTabla(int i) { return tabla.get(i); }
		
}//ComunHilos
