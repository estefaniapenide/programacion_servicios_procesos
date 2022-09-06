package cajero;

public class Cajero {
	
	private int localidades=0;
	public String nombre;
	
	public Cajero(String nombre) {
		this.nombre=nombre;
	}
	
	public void setLocalidades(int localidades) {
		this.localidades=localidades;
	}
	
	public int mostrarLocatlidades() {
		return this.localidades;
	}
	
	public synchronized void sumarLocalidades() {
		this.localidades++;
	}
	

}
