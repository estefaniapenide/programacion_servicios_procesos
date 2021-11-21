package almacensalidatexto;

import java.io.File;
import java.io.IOException;

public class Ejemplo5EySTexto {

	public static void main(String[] args) {
		
		File directorio = new File (".\\bin");
		
		File fentrada = new File("fEntradaCadena.txt");
		File fsalida = new File("fSalidaCadena.txt");
		File ferror = new File("fError.txt");
		
		ProcessBuilder pb = new ProcessBuilder("java","almacensalidatexto.EjemploLectura");
		pb.directory(directorio);
		
		pb.redirectInput(fentrada);
		pb.redirectOutput(fsalida);
		pb.redirectError(ferror);
		
		try {
		pb.start();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
