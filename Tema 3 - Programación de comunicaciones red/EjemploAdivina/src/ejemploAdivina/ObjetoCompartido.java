package ejemploAdivina;

public class ObjetoCompartido {
	private int numero; //número a adivinar
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
				cad="Número demasiado grande";
			}
			if(suNumero<numero) {
				cad="Número demasaido pequeño";
			}
			if(suNumero==numero) {
				cad="Jugador "+jugador+" gana. Adivinó el número: "+numero;
				acabo=true;
				ganador=jugador;
			}
		}else {
			cad="Juagdor "+ganador+" adivinó el número: "+numero;
		}
		return cad;
	}

}
