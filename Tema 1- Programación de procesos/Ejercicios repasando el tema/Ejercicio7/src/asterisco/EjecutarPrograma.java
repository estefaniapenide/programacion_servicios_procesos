package asterisco;

import java.io.File;

public class EjecutarPrograma {

	public static void main(String[] args) {
		
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","Progama");
		pb.directory(directorio);
		
		

	}

}
