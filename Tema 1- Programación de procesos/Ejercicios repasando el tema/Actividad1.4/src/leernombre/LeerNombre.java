package leernombre;

public class LeerNombre {

	public static void main(String[] args) {
		
		if(args.length==1) {
			System.out.println("Nombre: "+args[0]);
			System.exit(1);
		}else {
			System.out.println("No ha introducido ning�n argumento.");
			System.exit(-1);
		}
		
	}
	

}
