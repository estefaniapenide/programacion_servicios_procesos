package actividad21;

public class HiloTac extends Thread {

	
	public HiloTac(String name) {
		super(name);
		System.out.println("CREANDO HILO_TAC "+getName());
	}
	
	@Override
	public void run() {
		try {
			this.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		while(true) {
			
			System.out.println(" TAC ");
			try {
			this.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
