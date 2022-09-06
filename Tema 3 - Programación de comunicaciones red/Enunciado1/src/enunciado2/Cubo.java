package enunciado2;

import java.io.Serializable;

public class Cubo implements Serializable {
	
	private int num;
	private int cuadrado;
	public int getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(int cuadrado) {
		this.cuadrado = cuadrado;
	}

	private int cubo;
	
	public Cubo(int num) {
		this.num=num;
	}
	
	public Cubo(int num,int cuadrado, int cubo) {
		this.num=num;
		this.cuadrado=cuadrado;
		this.cubo=cubo;
		
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCubo() {
		return cubo;
	}

	public void setCubo(int cubo) {
		this.cubo = cubo;
	}

	
	
	
	
	
}
