package actividad2_10_PingPong;

class Colaping {
    private String pinpon;
    private boolean disponible = false;

    public synchronized String  get() {
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        disponible = false;
        notifyAll();
        return pinpon;
    }

    public synchronized void put(String  valor) {
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        pinpon = valor;
        disponible = true;
        notifyAll();
    }
}
class Consumidor extends Thread {
    private Colaping cola;
   
    public Consumidor(Colaping c) {
        cola = c;       
    }
    public void run() {
        String valor = "";
       for (int i = 0; i < 40; i++) {        
            valor = cola.get();           
			System.out.print(valor);			
        }
    }
}

class Productor extends Thread {
    private Colaping cola;
   
    public Productor(Colaping c) {
	  cola = c;        
    }
    public void run() {
	   
	    String cad="";
        for (int i = 0; i < 40; i++) {	
        	
        	if(i%2==0) cad=" PING ";
			else cad=" PONG ";
        	
            cola.put(cad);            
        }
    }
}
public class actividad2_10 {
  public static void main(String[] args) {
    Colaping cola = new Colaping();
    Productor p = new Productor(cola);
    Consumidor c = new Consumidor(cola);
    p.start();
    c.start();
  }
}