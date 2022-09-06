package contar;

public class ContarThread extends Thread{
	
	private int maxContar;
	private int repeticion=0;
	
	public ContarThread(String nombre,int num) {
		super(nombre);
		this.maxContar=num;
	}
	
	@Override
	public void run() {
		for(int i=0; i<maxContar; i++) {
			repeticion++;
			System.out.println("Repetición: "+repeticion);
			System.out.println("Nombre del hilo: "+getName()+"\n");
			try {
			sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
