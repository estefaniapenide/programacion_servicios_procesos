import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.err.println("Need command to run");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		Process process = pb.start();
		System.out.println("Ejecutando:" + Arrays.toString(args));
		
		String line;
		BufferedReader berr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		while ((line = berr.readLine()) != null) {
			System.out.println(line);
		}
		
		try {
			System.out.println("Valor de salida: "+ process.waitFor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
