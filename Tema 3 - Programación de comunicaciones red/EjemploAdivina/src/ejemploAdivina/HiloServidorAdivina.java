package ejemploAdivina;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidorAdivina extends Thread{

	ObjectInputStream fentrada;
	ObjectOutputStream fsalida;
	Socket socket = null;
	ObjetoCompartido objeto;
	int identificador;
	int intentos=0;
	
	public HiloServidorAdivina(Socket s, ObjetoCompartido objeto, int id) {
		
	this.socket=s;
	this.objeto=objeto;
	this.identificador=id;
	
	try {
		fsalida=new ObjectOutputStream(socket.getOutputStream());
		fentrada= new ObjectInputStream(socket.getInputStream());
		
	}catch(IOException e) {
			System.out.println("ERROR DE E/S en HiloServidor");
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("=> Cliente conectado: "+identificador);
		
		//PREPARAR PRIMER ENVIO AL CLIENTE
		Datos datos = new Datos("ADIVINA UN NÚMERO ENTRE 1 Y 25",intentos,identificador);
		if(objeto.seAcabo()) {
			datos.setCadena("LO SENTIMOS, EL JUEGO HA TERMINADO. HAN ADIVINADO EL NÚMERO");
			datos.setJuega(false);//YA NO TIENE QUE JUGAR
		}
		
		try {
			fsalida.reset();
			fsalida.writeObject(datos);
		}catch(IOException e) {
			System.out.println("Error en el Hilo al realizar el primer envío al jugador: "+identificador);
			return;
		}
		
		while(!objeto.seAcabo() || !(datos.getIntentos()==5)) {
			
			int numecli=0;
			try {
				//RECIBIR DATOS DEL CLIENTE
				Datos d =(Datos) fentrada.readObject();
				numecli=Integer.parseInt(d.getCadena());
			}catch(IOException e) {
				System.out.println("Error en el Hilo al leer del jugador: "+identificador);
				break;
			}catch(NumberFormatException n) {
				System.out.println("El jugador: "+identificador+" se ha desconectado.");
				break;
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}
			
			//Jugar el número
			String cad = objeto.nuevaJugada(identificador, numecli);
			intentos++;
			
			datos = new Datos(cad,intentos,identificador);
			
			if(objeto.seAcabo()) {
				datos.setJuega(false);//no tiene que seguir jugando
				if(identificador==objeto.getGanador()) {
					datos.setGana(true);
				}
			}
			
			try {
				fsalida.reset();
				fsalida.writeObject(datos);
			}catch(IOException e) {
				System.out.println("Error escribiendo n flujo de salida del jugador: "+identificador+" * "+e.getMessage());
				break;
				
			}catch(NullPointerException n) {
				System.out.println("El jugador "+identificador+" se ha desconectado");
				break;
			}
			
		}
		
		if(objeto.seAcabo()) {
			System.out.println("EL JUEGO SE HA ACABADO....");
			System.out.println("\t==>Desconecta: "+identificador);
		}
		try {
			fsalida.close();
			fentrada.close();
			socket.close();
		}catch(IOException e) {
			System.out.println("Error en Hilo al cerrar el cliente: "+identificador);
			e.printStackTrace();
		}
	}

}
