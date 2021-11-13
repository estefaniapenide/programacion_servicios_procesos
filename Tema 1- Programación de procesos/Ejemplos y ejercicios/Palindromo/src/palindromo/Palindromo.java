package palindromo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindromo {

	public static void main(String[] args) {

		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);

			// System.out.println("Introduzca una cadena:");
			String cadena = br.readLine();

			if (cadena.length() == 0) {
				System.out.println("La cadena est� vac�a.");
			} else {

				StringBuilder c = new StringBuilder();
				c.append(cadena);
				String palindromo = c.reverse().toString();

				if (cadena.equals(palindromo)) {
					System.out.println("La cadena es un pal�ndromo.");

				} else {
					System.out.println("La cadena NO es un pal�ndromo.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
