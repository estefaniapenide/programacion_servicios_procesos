package ej1hilos;

public class Principal {

	public static void main(String[] args) {
		
		
		for(int i=1;i<6;i++) {
		HiloHolaMundo h = new HiloHolaMundo();
		h.start();
		}

	}

}
