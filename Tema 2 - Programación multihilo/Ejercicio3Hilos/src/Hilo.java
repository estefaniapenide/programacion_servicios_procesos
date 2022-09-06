import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Hilo extends Thread {
	
	File fichero = null;;
	
	public Hilo(String nombre,File fichero) {
		super.setName(nombre);
		this.fichero=fichero;
		
	}
	
	@Override
	public void run() {
		
		long t_comienzo=System.currentTimeMillis();
		int num_caracteres=contarCaracteres(fichero);
		long t_fin=System.currentTimeMillis();
		long t_total=t_fin-t_comienzo;
		System.out.printf("Caracteres de %s => %d %nEl proceso ha tardado: %d milisegundos%n%n", fichero.getName(),num_caracteres,t_total);
		
		int contarCaracteres(File fichero) throws IOException {
			
			int num_caracteres=0;
			FileReader fr = new FileReader(fichero);
			int i=0;
			while((i=fr.read())!=-1) {
				num_caracteres++;
			}
			
			return num_caracteres;
	 
 }
}
