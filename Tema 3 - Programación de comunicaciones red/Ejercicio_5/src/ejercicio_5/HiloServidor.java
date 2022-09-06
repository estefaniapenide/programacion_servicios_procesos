package ejercicio_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
	
	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket =null;
	
	public HiloServidor(Socket s) throws IOException {
		socket=s;
		
		fsalida= new PrintWriter(socket.getOutputStream(),true);
		fentrada= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
	}
	
	public void  run() {
		String cadena="";
		
		System.out.println("=> Conecto " + socket.toString());
		
		try {
		
			while(!cadena.trim().equals("*")) {
					cadena=fentrada.readLine();
					fsalida.println(cadena.trim().toUpperCase());
			}
		
			System.out.println("=>Fin con "+socket.toString());
		
			fsalida.close();
			fentrada.close();
			socket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
