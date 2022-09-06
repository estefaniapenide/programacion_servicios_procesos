package saludo;

public class Profesor extends Thread{
	
	private Bienvenida bv;
	
	public Profesor(Bienvenida bv) {
		this.bv=bv;
	}
	
	@Override
	public void run() {
	
			bv.saludaProfesor();
		
	}

}
