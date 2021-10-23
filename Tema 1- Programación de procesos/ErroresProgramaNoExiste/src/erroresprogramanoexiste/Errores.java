package erroresprogramanoexiste;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Errores {

	public static void main(String[] args) throws IOException {
		//creamos objeto File al directorio donde está Ejemplo2
				File directorio = new File(".\\bin");
				
				//El proceso a ajecutar es Ejemplo2
				ProcessBuilder pb = new ProcessBuilder("java","Ejemplo2");
				
				//se establece el directorio donde se encuentra el ejecutable
				pb.directory(directorio);
				System.out.printf("Directorio de trabajo: %s%n",pb.directory());
				
				//se ejecuta el proceso
				Process p = pb.start();
				
				//obtener la salida devuelta por el proceso
				try {
					InputStream is = p.getInputStream();
					int c;
					while((c=is.read())!=-1) {
						System.out.print((char)c);
					}
					is.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					
					InputStream er = p.getErrorStream();
					BufferedReader brer= new BufferedReader(new InputStreamReader(er));
					String liner = null;
					while((liner=brer.readLine())!=null) {
						System.out.println("ERROR >"+liner);
					}
					
				}catch(IOException ioe) {
					
					ioe.printStackTrace();
				}

	}

}
