package actividad3_10_ejemplo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread {

	Socket socket = null;
	ObjetoCompartido objeto = null;
	int identificador;
	int intentos = 0;
	ObjectOutputStream fsalida = null;
	ObjectInputStream fentrada = null;

	public HiloServidor(Socket socket, ObjetoCompartido objeto, int identificador) {
		this.socket = socket;
		this.objeto = objeto;
		this.identificador = identificador;
		try {
			fsalida = new ObjectOutputStream(socket.getOutputStream());
			fentrada = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		System.out.println("=> Cliente conectado: " + identificador);

		// PREPARAR PRIMER ENVIO AL CLIENTE
		Datos datos = new Datos("ADIVINA UN NÚMERO ENTRE 1 Y 25", intentos, identificador);

		if (objeto.isAcabado()) {
			datos.setCadena("EL JUEGO HA TERMINADO. HAN ADIVINADO EL NÚMERO");
		}

		try {
			fsalida.reset();
			fsalida.writeObject(datos);
		} catch (IOException e) {
			System.out.println("Error en el Hilo al realizar el primer envío al jugador: " + identificador);
			return;
		}

		while (!objeto.isAcabado() || !(datos.getIntentos() == 5)) {
			int numCli = 0;
			try {
				Datos d = (Datos) fentrada.readObject();
				numCli = Integer.parseInt(d.getCadena());
			} catch (IOException e) {
				System.out.println("Error en el hilo al leer al jugador: " + identificador);
				break;
			} catch (NumberFormatException e) {
				System.out.println("El jugador " + identificador + " se ha desconectado.");
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}

			// JUGAR EL NÚMERO
			String cad = objeto.nuevaJugada(identificador, numCli);
			intentos++;

			datos = new Datos(cad, intentos, identificador);

			if (objeto.isAcabado()) {
				datos.setJuega(false);
				if (identificador == objeto.getGanador()) {
					datos.setGana(true);
				}
			}

			try {
				// ENVÍA DATOS AL CLIENTE
				fsalida.reset();
				fsalida.writeObject(datos);
			} catch (IOException e) {
				System.out.println("Error escribiendo el flujode salida del jugador " + identificador);
				break;
			} catch (NullPointerException e) {
				System.out.println("El jugador " + identificador + " se ha desconectado");
				break;
			}
		}

		if (objeto.isAcabado()) {
			System.out.println("EL JUEGO SE HA ACABADO....");
			System.out.println("\t==>DESCONECTA: " + identificador);
		}

		try {
			fsalida.close();
			fentrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
