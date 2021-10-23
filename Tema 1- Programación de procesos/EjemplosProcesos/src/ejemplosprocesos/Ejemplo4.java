package ejemplosprocesos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejemplo4 {

	public static void main(String[] args) throws IOException{
		
		Process p = new ProcessBuilder("CMD","/C","DATE").start();
		
		//escritura -- envia entrada a DATE
		OutputStream  os =p.getOutputStream();
		os.write("15-10-21".getBytes());
		os.flush();//vacía el buffer de salida
		
		//lectura -- obtiene la salida de DATE
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read())!=-1) {
			System.out.print((char)c);
		}
		is.close();
		
		//COMPROBACIÓN DE ERROR -0 bien -1 mal
		int exitVal;
		try {
			exitVal=p.waitFor();
			System.out.println("Valor de salida "+exitVal);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
