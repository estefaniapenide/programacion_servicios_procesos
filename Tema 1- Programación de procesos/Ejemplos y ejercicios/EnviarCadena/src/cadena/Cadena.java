package cadena;

public class Cadena {

	public static void main(String[] args) {

		
		if (args.length < 1) {
			
			System.out.println("No se ha enviado ninguna cadena.");
			System.exit(1);
			
		} else {
			
			String cadena = args[0];
			
			for (int i = 0; i < 5; i++) {
				System.out.println(cadena);
			}
			System.exit(0);
			
		}

	}

}
