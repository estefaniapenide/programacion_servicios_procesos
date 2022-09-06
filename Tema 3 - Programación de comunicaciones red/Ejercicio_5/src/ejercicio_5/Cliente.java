package ejercicio_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws  IOException {
		
		String Host="localhost";
		int Puerto = 4444;//puerto remoto
		Socket cliente = new Socket(Host,Puerto);
		
		//SE CREAN LOS FLUJOS DE ENTRADA Y SALIDA
		PrintWriter fsalida=new PrintWriter(cliente.getOutputStream(),true);
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		//FLUJO PARA ENTRADA ESTÁNDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String cadena, eco ="";
		
		do {
			
			System.out.println("Introduce cadena: ");
			cadena =in.readLine();
			fsalida.println(cadena);//envío cadena al servidor
			eco = fentrada.readLine();//recibido cadena del servidor
			System.out.println(" =>ECO: "+eco);
			
			
			
			
		}while(!cadena.trim().equals("*"));
		
		fsalida.close();
		fentrada.close();
		System.out.println("Fin del envío...");
		in.close();
		cliente.close();
		

	}

}
