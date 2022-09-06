package actividad2_10;

public class Produc_Consum {
	public static void main(String[] args) {
		Cola cola = new Cola();

		Productor p = new Productor(cola, 1);
		Consumidor c = new Consumidor(cola, 1);
		Consumidor c2 = new Consumidor(cola, 2);

		p.start();
		c.start();
		c2.start();

	}

}