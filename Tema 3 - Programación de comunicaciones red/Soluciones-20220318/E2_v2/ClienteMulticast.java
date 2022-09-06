package EjerciciosGarceta.E2_v2;

import java.awt.Color;
import java.awt.EventQueue;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Ejercicio3.ClienteMulticast;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ClienteMulticast extends JFrame {

	private static final long serialVersionUID = 1L;
	static MulticastSocket ms = null;	
	static InetAddress grupo = null;
	static int Puerto = 12344;// Puerto multicast

	String nombre;

	JScrollPane scrollPane = new JScrollPane();
	static JTextArea textArea = new JTextArea();

	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");

		if (nombre.trim().length() == 0) {
			System.out.println("El nombre está vacío....");
			System.exit(0);
		}

		try {
			///////////////////////////////////////[...]
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteMulticast frame = new ClienteMulticast();
					frame.setVisible(true);
					frame.setTitle("CLIENTE MULTICAST EJERCICIO 2 - " + nombre);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		byte[] buf;
		DatagramPacket paquete;

		try {
			while (true) {				
				///////////////////////////////////////[...]
				System.out.println("Recibo cliente: " + msg.trim());
				textArea.append("Recibiendo >> ");
				textArea.append(msg.trim());
				textArea.append("\n");

			} // while

		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

	}// main

	/**
	 * Create the frame.
	 */
	public ClienteMulticast() {
		setTitle("CLIENTE MULTICAST");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 384, 240);
		contentPane.add(scrollPane);

		// JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setForeground(Color.RED);

		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					///////////////////////////////////////[...]
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.exit(0);
				}
				///////////////////////////////////////[...]
				System.out.println("Socket CLIENTE MULTICAST cerrado...");
				System.exit(0);
			}
		});
		Salir.setBounds(413, 96, 77, 23);
		contentPane.add(Salir);
	}
}
