import java.io.*;
public class actividad1_6_Sumar {
	public static void main (String [] args)
	 {
	   InputStreamReader in = new InputStreamReader(System.in);
	   BufferedReader br = new BufferedReader (in);
	   try {
	     System.out.println("Introduce numero1: ");	
	     int numero1 = Integer.parseInt (br.readLine());
		 System.out.println("Numero escrito: "+numero1);	
	     System.out.println("Introduce numero2: ");
	     int numero2 = Integer.parseInt (br.readLine());	     
		 System.out.println("Numero escrito: "+numero2);	
	     int suma=numero1 + numero2;	               		
	     System.out.println("La suma es: "+suma);
	     in.close();
	   }
	   catch (NumberFormatException n) {
		 System.out.println("ERROR EN LOS NUMEROS TECLEADOS...");
		 System.exit(0);}
	   catch (Exception e) {  e.printStackTrace();}	
	 }
}//Sumar