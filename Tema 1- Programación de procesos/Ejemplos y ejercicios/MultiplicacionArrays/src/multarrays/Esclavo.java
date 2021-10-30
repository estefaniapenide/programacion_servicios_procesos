package multarrays;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Esclavo {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
			
		try {		
			
			int numero1;
			int numero2;
			
			BufferedReader br = new BufferedReader(in);

			//System.out.println("Numero 1:");
			numero1 = Integer.parseInt(br.readLine());
			//System.out.println(numero1);
			//System.out.println("Numero 2:");
			numero2=Integer.parseInt(br.readLine());
			
			//System.out.println(numero1);
			//System.out.println(numero2);
			
			int resultado=numero1*numero2;
			
			System.out.println(resultado);
		
			
		} catch (Exception e) {
			e.printStackTrace();			
		}

	}

}
