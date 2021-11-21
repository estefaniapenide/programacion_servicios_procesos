package suma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumaDosNumeros {

	public static void main(String[] args) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		try {

			int num1 = Integer.parseInt(br.readLine());
			System.out.println("N�mero: "+num1);
			
			int num2 = Integer.parseInt(br.readLine());
			System.out.println("N�mero: "+num2);
			
			int suma = num1 + num2;

			System.out.println("Resultado:\n" + num1 + "+" + num2 + "=" + suma);
			
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR. Debe introducir n�meros enteros.");
			System.exit(-1);
		}

	}

}
