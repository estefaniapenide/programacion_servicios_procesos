package actividad2_1;

class Hilo1 extends Thread {
	public void run() {
		while (true) {
			System.out.print(" TIC ");
			try {
				sleep(30);					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//tic

class Hilo2 extends Thread {
	public void run() {
		while (true) {
			System.out.print(" TAC ");
			try {
				sleep(40);				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//tac

public class actividad2_1 {	
   public static void main(String[] args) {
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		h1.start();
		h2.start();
	}// main

}// clase
