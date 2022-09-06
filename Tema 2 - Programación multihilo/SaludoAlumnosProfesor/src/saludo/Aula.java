package saludo;

public class Aula {

	public static void main(String[] args) {
		
		Bienvenida bv = new Bienvenida();
		
		Profesor p = new Profesor(bv);
		Alumno a1 = new Alumno("Juan",bv);
		Alumno a2 = new Alumno("Pedro",bv);
		Alumno a3 = new Alumno("María",bv);
		Alumno a4 = new Alumno("Lucía",bv);
		Alumno a5 = new Alumno("Laura",bv);
		
		
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		
		p.start();
		


	}

}
