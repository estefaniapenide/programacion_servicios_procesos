package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2Error {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIRR");
		
		try {
		Process p = pb.start();
		
		InputStream is = p.getInputStream();
		
		int c=0;
		while((c=is.read())!=-1) {
			System.out.println((char)c);
		}
		
		InputStream er = p.getErrorStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(er));
		String error="";
		while((error=br.readLine())!=null) {
			System.out.println("ERROR > "+error);
		}	
		
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
