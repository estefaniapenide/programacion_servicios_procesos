package ejercicio1;

class Caja{
	
	private int importeGlobal=0;
	
	public Caja() {
	}
	
	public synchronized void incrementarImporte(int cobro) {
		importeGlobal=importeGlobal+cobro;
	}
	
	public synchronized int mostrarImporte() {
		return importeGlobal;
	}
}

class Terminal extends Thread{
	
	 private Caja caja;
	 private int importeTerminal;
	 
	 public Terminal(String nombre, Caja caja) {
		 super(nombre);
		 this.caja=caja;
	 }
	 
	 public void run() {
		 int cobro=0;
		 
		 for(int i=0; i<200; i++) {
			 cobro=1+(int)(100*Math.random());
			 importeTerminal=importeTerminal+cobro;
			 caja.incrementarImporte(cobro);

			 try {
				 sleep(2000);
			 }catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			 
		 }
		 System.out.println("El terminal "+getName()+" ha facturado "+importeTerminal);
	 }
}

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Caja caja = new Caja();
		Terminal t1 = new Terminal("1",caja);
		Terminal t2 = new Terminal("2",caja);
		Terminal t3 = new Terminal("3",caja);
		Terminal t4 = new Terminal("4",caja);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nTOTAL IMPORTE CAJA: "+caja.mostrarImporte());
		

	}

}
