package ejemplos;

import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Ejemplo6 {

	public static void main(String[] args) {
		
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment();
		System.out.println("Varibales de entorno:");
		System.out.println(entorno);
		
		test = new ProcessBuilder("java","leerNombre.LeerNombre","Juan");
		List l = test.command();
		Iterator iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("\nEjecución del proceso tras cambiar los argumentos del comando:\n");
		
		test.command("CMD","/C","DIR");
		
		try {
		
		Process p = test.start();
		
		InputStream is = p.getInputStream();
		int c=0;
		while((c=is.read())!=-1) {
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
