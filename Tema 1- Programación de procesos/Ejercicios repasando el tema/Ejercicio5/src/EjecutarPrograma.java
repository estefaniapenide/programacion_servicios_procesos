import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EjecutarPrograma {

	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca una cadena: ");
		//String cadena = br.readLine();
		String cadena=input.nextLine();
		
		ProcessBuilder pb = new ProcessBuilder("java","Programa",cadena);
		pb.directory(directorio);
		
		try {
			
		Process p = pb.start();
		
		int valSalida=0;
		valSalida=p.waitFor();
		switch(valSalida) {
		case 0:
			System.out.println("Final correcto...");
			break;
		case 1:
			System.out.println("Final incorrecto...");
			break;
		}

		
		BufferedReader brHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String linea;
		while((linea=brHijo.readLine())!=null) {
			System.out.println(linea);
		}
		
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	

	}

}
