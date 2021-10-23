package sumadosnumeros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Programa {

	public static void main(String[] args)throws IOException {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","sumadosnumeros.SumaNumeros");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("2\n".getBytes());
		os.write("2\n".getBytes());
		os.flush();
	
		
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
		
		int exitVal;
		try {
			exitVal= p.waitFor(); //Recoge la salida de System.exit()
			System.out.println("Valor de salida: "+exitVal);
			
		}catch(InterruptedException e) {		
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
