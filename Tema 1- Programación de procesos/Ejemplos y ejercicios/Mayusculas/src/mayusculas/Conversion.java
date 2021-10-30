package mayusculas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Conversion {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			String liner = null;
			while ((liner = br.readLine()) != null) {
				System.out.println(liner.toUpperCase());				
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}

	}

}
