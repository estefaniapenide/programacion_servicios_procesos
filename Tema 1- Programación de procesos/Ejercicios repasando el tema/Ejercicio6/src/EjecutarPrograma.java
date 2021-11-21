import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjecutarPrograma {

	public static void main(String[] args) {
		 
		File directorio = new File(".\\bin");
		File fichero = new File("fichero.txt");
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Scanner input = new Scanner(System.in);
	    String cadena;
	    System.out.println("Introduzca una cadena: ");
		//String cadena = br.readLine();
		cadena=input.nextLine();
		
		ProcessBuilder pb = new ProcessBuilder("java","Programa",cadena);
		pb.directory(directorio);
		
		pb.redirectOutput(ProcessBuilder.Redirect.to(fichero));
		
		try {
		Process p = pb.start();
		
		/*BufferedReader brHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));
		FileOutputStream fos = new FileOutputStream("fichero.txt");
		PrintWriter pw = new PrintWriter(fos);
		String linea;
		while((linea=brHijo.readLine())!=null) {
			System.out.println(linea);
			pw.println(linea);
			pw.flush();
			
		}
		pw.close();*/
		
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
		
		
		String error;
		InputStream er = p.getErrorStream();
		BufferedReader brEr = new BufferedReader(new InputStreamReader(er));
		while((error=brEr.readLine())!=null) {
			System.out.println("ERROR > "+error);
		}
		brEr.close();
		
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	

	}

}
