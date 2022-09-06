package actividad3_10_ejemplo;

public class ObjetoCompartido {

	private int numero;// numero a adivinar
	private boolean acabado;// true cuando haya terminado el juego
	private int ganador;// jugador ganador

	public ObjetoCompartido() {
	}

	public ObjetoCompartido(int numero) {
		this.numero = numero;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAcabado() {
		return acabado;
	}

	public void setAcabado(boolean acabo) {
		this.acabado = acabo;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public synchronized String nuevaJugada(int jugador, int suNumero) {

		String cad = "";
		if (!isAcabado()) {
			if (suNumero > numero) {
				cad = "Numero demasiado grande";
			}

			if (suNumero < numero) {
				cad = "Numero demasiado pequeño";
			}

			if (suNumero == numero) {
				cad = "Jugador " + jugador + " gana, adivinó el número: " + numero;
				acabado = true;
				ganador = jugador;
			}
		} else {
			cad = "Jugador " + ganador + " gana, adivinó el número: " + numero;
		}

		return cad;
	}

}
