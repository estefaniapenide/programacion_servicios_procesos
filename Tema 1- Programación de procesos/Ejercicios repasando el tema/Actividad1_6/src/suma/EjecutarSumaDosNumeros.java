package suma;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class EjecutarSumaDosNumeros {

	public static void main(String[] args)  {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","suma.SumaDosNumeros");
		pb.directory(directorio);
		try {
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("5\n".getBytes());
		os.write("7\n".getBytes());
		os.flush();
		
		InputStream in = p.getInputStream();
		int c=0;
		while((c=in.read())!=-1) {
			System.out.print((char)c);
		}
		
		InputStream er = p.getErrorStream();
		BufferedReader brEr = new BufferedReader(new InputStreamReader(er));
		String error="";
		while((error=brEr.readLine())!=null) {
			System.out.println("ERROR > "+error);
		}
		
		
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
