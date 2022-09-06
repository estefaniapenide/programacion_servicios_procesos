package tarea;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServidorChat {
	static final int MAXIMO = 5;//MAXIMO DE CONEXIONES PERMITIDAS	
	
	public static void main(String args[]) throws IOException {
		int PUERTO = 44444;	
		
		ServerSocket servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado...");
		
		ArrayList<Socket> tabla = new ArrayList<Socket>();//MODIFICADO
		ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);//MODIFICADO//maximo no hace falta, se controlará aqui en el servidor
		
	
		while(true) {//AÑADIDO PARA QUE SIGA ESCUCHANDO CUANDO YA HAYA 5 CLIENTES CONECTADOS Y QUE PUEDA HABER OTROS ESPERANDO PARA ENTRAR	
			
			System.out.print("");//AÑADIDO PARA QUE EL WHILE TRUE SIGA FUNCIONANDO CUANDO NO ENTRA EN EL IF	
	
			if(comun.getACTUALES() < MAXIMO) {//MODIFICADO//para controlar las conexiones
				
				Socket socket = new Socket();
				socket = servidor.accept();// esperando cliente
			
		
				comun.addTabla(socket);//MODIFICADO
				comun.setACTUALES(comun.getACTUALES() + 1);
				comun.setCONEXIONES(comun.getCONEXIONES() + 1);//no hace falta			
			
				HiloServidorChat hilo = new HiloServidorChat(socket, comun);
				hilo.start();
				
			
			}
	
			
		}	
		
		//servidor.close();//El servidor no se cierra porque si se permite la conexión y desconexión de clientes, aunque tengamos 0 se podrá volver a entrar en el chat
		
		
	}//main
}//ServidorChat..  
