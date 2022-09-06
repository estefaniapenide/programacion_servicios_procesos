package acrividad3_4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("PROGRAMA CLIENTE");

		try {
		System.out.println("Introduce un número:");
		int num = input.nextInt();
		String numero = Integer.toString(num);
			
			Socket clientSocket = new Socket();
			
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			clientSocket.connect(addr);
			
			OutputStream os = clientSocket.getOutputStream();
			os.write(numero.getBytes());
			
		}catch(InputMismatchException e) {
				System.out.println("No has introducido un número.");	
				}catch(IOException e) {
				e.printStackTrace();
			}

	}

}
