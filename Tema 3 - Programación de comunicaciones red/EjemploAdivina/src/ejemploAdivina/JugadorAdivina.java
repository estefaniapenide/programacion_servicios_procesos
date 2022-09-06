package ejemploAdivina;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class JugadorAdivina {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		String Host="localhost";
		int Puerto=6001;//puerto remoto
		Socket cliente = new Socket(Host,Puerto);
		
		ObjectOutputStream fsalida= new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream fentrada = new ObjectInputStream(cliente.getInputStream());
		
		//FLUJO PARA ENTRADA ESTANDAR
		Scanner sc = new Scanner(System.in);
		String cadena ="";
		
		//OBTENER PRIMER OBJETO ENVIADO POR EL SERVIDOR
		Datos datos = (Datos) fentrada.readObject();
		int identificador = datos.getIdentificador();
		System.out.println("ID JUGADOR: "+identificador);
		System.out.println(datos.getCadena());
		
		if(!datos.getJuega()) {
			cadena="*";
		}
		
		while(datos.getJuega() && !cadena.trim().equals("*")) {
			System.out.println("Intento: "+(datos.getIntentos()+1)+" => Introduce número:");
			cadena=sc.nextLine();
			Datos d = new Datos();
			
			if(!validarCadena(cadena)) continue;
			
			d.setCadena(cadena);
			
			//ENVIAR DATOS AL SERVIDOR, el número leído por teclado
			fsalida.reset();
			fsalida.writeObject(d);
			
			//RECIBIR DATOS DEL SERVIDOR
			datos = (Datos) fentrada.readObject();
			System.out.println("\t"+datos.getCadena());
			
			if(datos.getIntentos()>=5) {
				System.out.println("\t<<JUEGO FINALIZADO, NO HAY MÁS INTENTOS>>");
				cadena="*";
			}
			
			if(datos.getGana()) {
				System.out.println("<<HAS GANADO!! EL JUEGO HA TERMINADO>>");
				cadena="*";
			}else if(!(datos.getJuega())){
				System.out.println("<<EL JEUGO HA TERMINADO. HAN ADIVINADO EL NÚMERO>>");
				cadena="*";
			}
		}

	}
	
	public static boolean validarCadena(String cadena) {
		//comprueba si la cadena es numérica
		boolean valor=false;
		try {
			Integer.parseInt(cadena);
			valor=true;
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return valor;
	}

}
