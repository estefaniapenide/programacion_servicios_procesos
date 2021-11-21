package aleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneraNumeroAleatorio {

	public static void main(String[] args) {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		String entrada = "";
		try {

			while ((entrada = br.readLine()) != null) {
				System.out.println((int) (Math.random() * 11));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
