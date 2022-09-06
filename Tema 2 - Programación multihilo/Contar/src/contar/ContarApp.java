package contar;

public class ContarApp {

	public static void main(String[] args) {
		
		ContarThread ct1 = new ContarThread("Hilo 1",6);
		
		
		ct1.start();
		try {
		ct1.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		ContarThread ct2 = new ContarThread("Hilo 2",5);
		ct2.start();
		
		while(ct1.isAlive() && ct2.isAlive()) {
			System.out.println("Sigo contando");
			try {
				Thread.sleep(3000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
		}

	}

}
