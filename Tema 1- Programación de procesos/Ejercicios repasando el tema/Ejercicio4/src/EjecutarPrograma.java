import java.io.File;
import java.io.IOException;

public class EjecutarPrograma {

	public static void main(String[] args) {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","Programa");
		pb.directory(directorio);
		
		try {
		Process p = pb.start();
		
		int valSalida=0;
		valSalida=p.waitFor();
		System.out.println("Valor de salida: "+valSalida);
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
