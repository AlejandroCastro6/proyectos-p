package interfaz;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;


public class VentanaInicio {

	private JFrame frmElTriviador;
	private PanelFondoInicio panelFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio();
					window.frmElTriviador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {
		initialize();
	}
	
	/**
	 * Center frame.
	 */
//	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElTriviador = new JFrame();
		frmElTriviador.setResizable(false);
		frmElTriviador.setTitle("El Triviador");
		frmElTriviador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElTriviador.setBounds(100, 100, 800, 600);
		frmElTriviador.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/img/ventanaInicio/iconoJuego1.png")));		
		centreWindow(frmElTriviador);
		panelFondo = new PanelFondoInicio();
		panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmElTriviador.setContentPane(panelFondo);
		panelFondo.setLayout(null);
		
		JButton btnJugar = new JButton("");
		btnJugar.setToolTipText("JUGAR!!!!");
		btnJugar.setSize(new Dimension(96, 96));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJugar.setRolloverIcon(new ImageIcon(VentanaInicio.class.getResource("/img/ventanaInicio/play1.png")));
		btnJugar.setPressedIcon(new ImageIcon(VentanaInicio.class.getResource("/img/ventanaInicio/play3.png")));
		btnJugar.setIcon(new ImageIcon(VentanaInicio.class.getResource("/img/ventanaInicio/play2.png")));
		btnJugar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnJugar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnJugar.setIconTextGap(-3);
		btnJugar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBorderPainted(false);
		btnJugar.setBorder(null);
		btnJugar.setBounds(30, 466, 89, 85);
		panelFondo.add(btnJugar);
	}
}
