package cajero;

public class MainCajero {

	public static void main(String[] args) {
		
		Cajero cajero = new Cajero("Cajero Alameda");
		System.out.println("Cajero: "+cajero.nombre);
		Terminal t1 = new Terminal("1",cajero);
		Terminal t2 = new Terminal("2",cajero);
		Terminal t3 = new Terminal("3",cajero);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
		t1.join();
		t2.join();
		t3.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		
		System.out.println("Total localidades vendidas: "+cajero.mostrarLocatlidades());
		

	}

}
