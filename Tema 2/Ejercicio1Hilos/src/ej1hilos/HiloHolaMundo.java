package ej1hilos;

public class HiloHolaMundo extends Thread{
	
	public HiloHolaMundo() {
		super();
	}
	
	@Override
	public void run() {
		System.out.println("Hola mundo del "+getId());
	}

}
