package ej2hilos;

public class HiloHolaMundo implements Runnable {
	
	private String mensaje;
	
	public HiloHolaMundo(String mensaje) {
		this.mensaje=mensaje;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.currentThread().sleep(1000*Thread.currentThread().getId());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hola mundo "+this.mensaje+" ID:"+Thread.currentThread().getId());
		
	}

}
