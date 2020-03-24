package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

//import logica.Jugador;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int TAM = 101;
	private PanelJugadores panelJugadores;
	private PanelJuego panelJuego;
//	private Jugador jugador;
//	private ImageIcon puntoAzul;
//	private ImageIcon puntoRojo;
	private String[] vectorP;

	File f;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw = null;
	BufferedReader br = null;

	public VentanaPrincipal(String nameFile) {
		setLayout(new BorderLayout());
		f = new File(nameFile);
		vectorP = new String[TAM];
//		puntoRojo = new ImageIcon("H:/img/calaveraRoja.jpg/");
//		puntoAzul = new ImageIcon("H:/calaveraAzul.jpg/");
		setTitle("El Triviador");
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jugador = new Jugador();
		panelJuego = new PanelJuego(this);
		panelJugadores = new PanelJugadores(this);
		add(panelJuego, BorderLayout.NORTH);
		add(panelJugadores, BorderLayout.SOUTH);
	}

	public void abrir(char modo) {
		try {
			// modo escritura "w" crea el archivo
			if (modo == 'w') {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
			} else {
				// modo lectura "r" abre el archivo
				fr = new FileReader(f);
				br = new BufferedReader(fr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Almacena la cadena ingresada por parametro
	public void grabar(String cad) {
		if (bw != null) {
			try {
				bw.write(cad);
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Lee una linea del archivo
	public String leer() {
		String cad = "";
		try {
			cad = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cad;
	}

	// cierra archivo modo R/W
	public void cerrar() {
		try {
			if (br != null)
				br.close();
			if (bw != null)
				bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escribirArchivo() {
		for (int i = 0; i <= 100; i++) {
			if (i < 50) {
				this.grabar("gato");
			} else {
				this.grabar("perro");
			}
		}
	}

	public void vectorArchivo() {
		for (int i = 0; i < vectorP.length; i++) {
			vectorP[i] = (this.leer());
		}
	}
	
	public int btAtacar() {
		int posPregunta1 = 0;
		int posPregunta2 = 0;
		int respuesta1 = 0;
		int respuesta2 = 0;
		int resJugador1 = 0;
		int resJugador2 = 0;
		boolean bienJ1 = true;
		boolean bienJ2 = true;
		int respuestaGanador = 0;

		posPregunta1 = (int) (Math.random() * 100) + 1;
		int miRespuesta = JOptionPane.showOptionDialog(null,
				vectorP[posPregunta1], "Pregunntaaa",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Yes", "No" }, null);

		if (posPregunta1 < 50) {
			respuesta1 = 0;
		} else {
			respuesta1 = 1;
		}
		if (miRespuesta != -1) {
			if (miRespuesta == 0) {
				resJugador1 = 0;
				if (resJugador1 == respuesta1) {
					JOptionPane.showMessageDialog(null, "Correcto");
					bienJ1 = true;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrecto");
					bienJ1 = false;
				}
			} else if (miRespuesta == 1) {
				resJugador1 = 1;
				if (resJugador1 == respuesta1) {
					JOptionPane.showMessageDialog(null, "Correcto");
					bienJ1 = true;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrecto");
					bienJ1 = false;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Turno del jugador dos !!");
		posPregunta2 = (int) (Math.random() * 100) + 1;
		int miRespuesta2 = JOptionPane.showOptionDialog(null,
				vectorP[posPregunta2], "Pregunntaaa",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Yes", "No" }, null);
		if (posPregunta2 < 50) {
			respuesta2 = 0;
		} else {
			respuesta2 = 1;
		}
		if (miRespuesta2 != -1) {
			if (miRespuesta2 == 0) {
				resJugador2 = 0;
				if (resJugador2 == respuesta2) {
					JOptionPane.showMessageDialog(null, "Correcto");
					bienJ2 = true;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrecto");
					bienJ2 = false;
				}
			} else if (miRespuesta2 == 1) {
				resJugador2 = 1;
				if (resJugador2 == respuesta2) {
					JOptionPane.showMessageDialog(null, "Correcto");
					bienJ2 = true;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrecto");
					bienJ2 = false;
				}
			}
		}
		if ((bienJ1) && (!bienJ2)) {
			JOptionPane.showMessageDialog(this, panelJugadores.lbJugador1);
			JOptionPane.showMessageDialog(null, "Gana");
			panelJuego.pintarBotonA();
			respuestaGanador = 1;
		}
		if ((!bienJ1) && (bienJ2)) {
			JOptionPane.showMessageDialog(this, panelJugadores.lbJugador2);
			JOptionPane.showMessageDialog(null, "Gana");
			panelJuego.pintarBotonR();
			respuestaGanador = 2;
		}
		if ((bienJ1) && (bienJ2) || (!bienJ1) && (!bienJ2)) {
			JOptionPane.showMessageDialog(this, "EMPATE");
		}
		return respuestaGanador;
	}

	public static void main(String[] args) {
		VentanaPrincipal juego = new VentanaPrincipal("D:/Zooey/Preguntas.txt");
		juego.abrir('r');
		juego.vectorArchivo();
		juego.cerrar();
		juego.setVisible(true);
		
	}

}
