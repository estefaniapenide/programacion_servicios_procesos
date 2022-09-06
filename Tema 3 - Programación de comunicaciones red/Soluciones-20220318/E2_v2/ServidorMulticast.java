package EjerciciosGarceta.E2_v2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.awt.event.ActionEvent;

public class ServidorMulticast extends JFrame {

	private static final long serialVersionUID = 1L;
	static MulticastSocket ms = null;
	static InetAddress grupo = null;
	static int Puerto = 12344;// Puerto multicast

	private JPanel contentPane;
	private JTextField mensaje;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			///////////////////////////////////////[...]
		} catch (IOException e) {
			System.out.println("ERROR AL CREAR EL SOCKET : " + e.getMessage());
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorMulticast frame = new ServidorMulticast();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// fin de main

	/**
	 * Create the frame.
	 */
	public ServidorMulticast() {
		setTitle("SERVIDOR MULTICAST - EJERCICIO 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mensaje = new JTextField();
		mensaje.setBounds(10, 11, 356, 20);
		contentPane.add(mensaje);
		mensaje.setColumns(10);

		textArea = new JTextArea();
		textArea.setBackground(Color.lightGray);
		textArea.setForeground(Color.BLUE);

		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 52, 346, 199);
		contentPane.add(scrollPane);

		JButton Enviar = new JButton("Enviar");
		Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = mensaje.getText();
				if (texto.length() > 0) {
					textArea.append("Enviando>> ");
					textArea.append(mensaje.getText() + "\n");
					mensaje.setText("");
					try {
						// ENVIANDO AL GRUPO
						///////////////////////////////////////[...]
					} catch (IOException e1) {
						e1.printStackTrace();
						textArea.append("Error al Enviar ...... ");
					}
				}

			}
		});
		Enviar.setBounds(389, 10, 89, 23);
		contentPane.add(Enviar);

		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				///////////////////////////////////////[...]
				System.out.println("Servidor multicast cerrado...");
				System.exit(0);
			}
		});
		Salir.setBounds(389, 44, 89, 23);
		contentPane.add(Salir);

	}
}
