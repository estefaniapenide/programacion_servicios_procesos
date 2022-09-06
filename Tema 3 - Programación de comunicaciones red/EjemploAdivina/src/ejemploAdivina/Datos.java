package ejemploAdivina;

import java.io.Serializable;

public class Datos implements Serializable{
	String cadena;//cadena que se intercambia con el servidor
	int intentos;//intentos que lleva el jugador, hasta 5
	int identificador;//id del juagador
	boolean gana;//true si el jugador adivina el número
	boolean juega;//true si el jugador juega, false juego finalizado
	
	public Datos(String cadena, int intentos, int identificador) {
		this.cadena=cadena;
		this.intentos=intentos;
		this.identificador=identificador;
		this.gana=false;
		this.juega=true;
		
	}
	
	public Datos() {
		super();
	}
	
	public String getCadena() {
		return this.cadena;
	}
	
	public void setCadena(String cadena) {
		this.cadena=cadena;
	}
	
	public int getIntentos() {
		return this.intentos;
	}
	
	public void setIntentos(int intentos) {
		this.intentos=intentos;
	}
	
	public int getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador=identificador;
	}
	
	public boolean getGana() {
		return this.gana;
	}
	
	public void setGana(boolean gana) {
		this.gana=gana;
	}
	
	public boolean getJuega() {
		return this.juega;
	}
	
	public void setJuega(boolean juega) {
		this.juega=juega;
	}

}
