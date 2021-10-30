package multarrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class MultiplicacionArrays {

	public static void main(String[] args) throws IOException {

		
		ArrayList<Integer> resultados = new ArrayList<Integer>();
		
		
		int[] array1 = { 14, 35, 23, 1, 2, 0, 7, 19, 78, 3 };
		int[] array2 = { 2, 67, 2, 4, 17, 34, 83, 21, 5, 8 };

		File directorio = new File(".\\bin");

		ProcessBuilder h = new ProcessBuilder("java", "multarrays.Esclavo");
		h.directory(directorio);
		
		Process esclavo1;
		Process esclavo2;

		for (int i = 0; i < 5; i++) {
			esclavo1 = h.start();
			procesoEsclavo(esclavo1,i,array1, array2,resultados);

		}
		
		for (int i = 6; i < 10; i++) {
			esclavo2 = h.start();
			procesoEsclavo(esclavo2,i,array1, array2,resultados);

		}
		
		System.out.println(resultados);
		

	}
	
	public static void procesoEsclavo(Process esclavo,int i, int[] array1, int[] array2, ArrayList<Integer> resultados) throws IOException  {
		
		String linea;
		int numero;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(esclavo.getInputStream()));
		PrintStream ps = new PrintStream(esclavo.getOutputStream());

		ps.print(array1[i]);
		ps.print("\r");
		ps.print(array2[i]);
		ps.print("\r");
		ps.flush();

		if ((linea = br.readLine()) != null) {
			numero=Integer.parseInt(linea);
			resultados.add(numero);
		}
		

		try {

			InputStream er = esclavo.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR >" + liner);
			}

		} catch (IOException ioe) {

			ioe.printStackTrace();
		}
		
		
	}

}
