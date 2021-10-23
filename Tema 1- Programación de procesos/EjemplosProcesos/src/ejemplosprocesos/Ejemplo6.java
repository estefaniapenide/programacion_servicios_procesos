package ejemplosprocesos;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Iterator;


public class Ejemplo6 {

	public static void main(String[] args) {
		
		
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment();
		System.out.println("Variables de entorno: ");
		System.out.println(entorno);
		
		test = new ProcessBuilder("java","LeerNombre","María");
	
		
		//Devuelve el nombre del proceso y sus argumentos
		List l = test.command();
		Iterator iter= l.iterator();
		System.out.println("\nArgumentos del comando: ");
		while(iter.hasNext()) {
			System.out.println(iter.next());	
		}
		
		test = test.command("CMD","/C","DIR");
		try {
			Process p = test.start();//Se ejecuta DIR
			InputStream is = p.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
			is.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
