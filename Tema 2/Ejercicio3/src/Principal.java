import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		if(args.length==0) {
			System.out.println("Faltan argumentos en main..");
			return;
		}
		
		for(int i=0;i<args.length;i++) {
			File fichero = new File(args[i]);
			
			if(fichero.exists()) {
				long t_comienzo=System.currentTimeMillis();
				int num_caracteres=contarCaracteres(fichero);
				long t_fin=System.currentTimeMillis();
				long t_total=t_fin-t_comienzo;
				System.out.printf("Caracteres de %s => %d %nEl proceso ha tardado: %d milisegundos%n%n", args[i],num_caracteres,t_total);
				
			}else {
				System.out.printf("El fichero %s no existe.",args[i]);
			}
		}

	}//main
	
	private static int contarCaracteres(File fichero) throws IOException {
		
		int num_caracteres=0;
		FileReader fr = new FileReader(fichero);
		int i=0;
		while((i=fr.read())!=-1) {
			num_caracteres++;
		}
		
		return num_caracteres;
	}

}
