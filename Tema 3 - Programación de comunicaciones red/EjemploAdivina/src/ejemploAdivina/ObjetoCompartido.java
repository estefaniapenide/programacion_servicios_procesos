package ejemploAdivina;

public class ObjetoCompartido {
	private int numero; //n�mero a adivinar
	private boolean acabo;//true cuando se haya terminado e juego
	private int ganador;//jugador ganador
	
	public ObjetoCompartido(int numero) {
		this.numero=numero;
		this.acabo=false;
	}
	
	public boolean seAcabo() {
		return this.acabo;}
	
	public int getGanador() {
		return this.ganador;
	}
	
	public synchronized String nuevaJugada(int jugador, int suNumero) {
		String cad="";
		
		if(!seAcabo()) {
			if(suNumero>numero) {
				cad="N�mero demasiado grande";
			}
			if(suNumero<numero) {
				cad="N�mero demasaido peque�o";
			}
			if(suNumero==numero) {
				cad="Jugador "+jugador+" gana. Adivin� el n�mero: "+numero;
				acabo=true;
				ganador=jugador;
			}
		}else {
			cad="Juagdor "+ganador+" adivin� el n�mero: "+numero;
		}
		return cad;
	}

}
