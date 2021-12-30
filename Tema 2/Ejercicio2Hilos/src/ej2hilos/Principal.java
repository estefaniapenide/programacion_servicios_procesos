package ej2hilos;

import ej2hilos.HiloHolaMundo;

public class Principal {

	public static void main(String[] args) {
		
		for(int i=1;i<6;i++) {
		Thread h = new Thread(new HiloHolaMundo("Hilo "+i+" "));
		h.start();
		}

	}

}
