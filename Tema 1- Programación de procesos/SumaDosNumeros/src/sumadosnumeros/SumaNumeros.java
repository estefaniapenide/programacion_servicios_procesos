package sumadosnumeros;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SumaNumeros {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		int a;
		int b;
		try {
			System.out.println("Introduce un n�mero:");
			a=input.nextInt();
			//a=Integer.parseInt(br.readLine());
			System.out.println("N�mero escrito:"+a);

			System.out.println("Introduce otro n�mero:");
			b=input.nextInt();
			//b=Integer.parseInt(br.readLine());
			System.out.println("N�mero escrito:"+b);
			
			System.out.println(a+"+"+b+"="+(a+b));
			input.close();
		}catch(Exception e) {
			
			e.printStackTrace();
		}

	}

}
