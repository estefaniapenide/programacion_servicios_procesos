package actividad21;

public class HiloTic extends Thread{
	
	
	public HiloTic(String name) {
		super(name);
		System.out.println("CREANDO HILO_TIC "+getName());
	}
	
	@Override
	public void run() {
		while(true) {
			
			System.out.println(" TIC ");
			try {
			this.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
