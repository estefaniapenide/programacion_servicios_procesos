package saludo;

public class Alumno extends Thread {
	
	private Bienvenida bv;
	
	public Alumno(String nombre, Bienvenida bv) {
		super(nombre);
		this.bv=bv;
	}
	
	@Override
	public void run() {
	
			bv.llegaProfesor();
		
	}

}
