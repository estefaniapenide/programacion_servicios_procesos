import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LeerNombre {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			System.out.println("Nombre: "+args[0]);
			System.exit(1);
		}
		System.out.println("Número de argumentos incorrecto.");
			System.exit(-1);
		

	}

}
