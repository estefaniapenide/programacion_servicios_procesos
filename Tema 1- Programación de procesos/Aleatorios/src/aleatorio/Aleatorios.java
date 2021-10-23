package aleatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class Aleatorios {

	public static void main(String[] args) throws IOException {
		
		
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder h = new ProcessBuilder("java","aleatorio.ProcesoHijo");
		h.directory(directorio);
		
		Process hijo =h.start();	
		
		BufferedReader br=new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		PrintStream ps = new PrintStream(hijo.getOutputStream());
		
		//OutputStream os = hijo.getOutputStream();
		//os.write("2\n".getBytes());
		//os.write("2\n".getBytes());
		//os.flush();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.println("AAA: ");
		String linea=in.readLine();
		
		ps.println(linea+"\n");
				
		try {
			InputStream is = hijo.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
			is.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {
			
			InputStream er = hijo.getErrorStream();
			BufferedReader brer= new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while((liner=brer.readLine())!=null) {
				System.out.println("ERROR >"+liner);
			}
			
		}catch(IOException ioe) {
			
			ioe.printStackTrace();
		}
		
		int exitVal;
		try {
			exitVal= hijo.waitFor(); //Recoge la salida de System.exit()
			System.out.println("Valor de salida: "+exitVal);
			
		}catch(InterruptedException e) {		
			e.printStackTrace();
		}
		
		

	}

}
