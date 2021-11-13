package argumentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Programa {

	public static void main(String[] args) {
		

		int a=0;
		
		if(args.length<1) {
			System.exit(1);	
		}
		
		try {
			a=Integer.parseInt(args[0]);
			if(a<0) {
				System.exit(3);	
			}else {
				System.exit(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(2);
		}
		
		
		}
	

//		try {
//			
//			ProcessBuilder pb = new ProcessBuilder(args);
//			Process p = pb.start();
//			System.out.println("Ejecutando: "+Arrays.toString(args));
//			
//			
//				
//				InputStream er = p.getErrorStream();
//				BufferedReader brer= new BufferedReader(new InputStreamReader(er));
//				String liner = null;
//				while((liner=brer.readLine())!=null) {
//					System.out.println("ERROR >"+liner);
//				}
//				int exitVal;
//				exitVal= p.waitFor(); //Recoge la salida de System.exit()
//				System.out.println("Valor de salida: "+exitVal);
//				
//			}catch(IOException ioe) {
//				
//				ioe.printStackTrace();
//			}catch(InterruptedException e) {		
//				e.printStackTrace();
//			}
//
//		}

}
