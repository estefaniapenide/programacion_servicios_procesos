package cajero;

public class Terminal extends Thread{
	
	private Cajero cajero;
	private int localidadesTerminal=0;
	private int limiteLocalidadesTerminal=20000;
	
	public Terminal(String nombre, Cajero cajero) {
		super(nombre);
		this.cajero = cajero;
	}
	
	public int mostrarLocatlidadesTerminal() {
		return this.localidadesTerminal;
	}
	
	public int sumarLocalidadesTerminal() {
		return this.localidadesTerminal++;
	}
	
	@Override
	public void run() {
		for(int i=0; i<limiteLocalidadesTerminal; i++) {
			cajero.sumarLocalidades();
			sumarLocalidadesTerminal();
		}
			System.out.println("Terminal "+getName()+" vendió: "+mostrarLocatlidadesTerminal());
			System.out.println("Localidades agotadas en terminal "+getName());
		
	}

}
