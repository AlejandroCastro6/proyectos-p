package interfaz;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;

public class VentanaPrinicipalMejorada extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	private static JFrame ventanaMapa;
	private static final int ANCHO=800;
	private static final int ALTO=600;
	private static final String NOMBRE_VENTANA_MAPA="El Triviador";
	private static int ms=0;
	private static int fps=0;
	private static Thread hiloMapa;
	private static volatile boolean hiloMapaEnFuncionamiento = false;
	
	public VentanaPrinicipalMejorada() {
		setPreferredSize(new Dimension(ANCHO,ALTO));
		VentanaPrinicipalMejorada.setVentanaMapa(new JFrame());
		VentanaPrinicipalMejorada.getVentanaMapa().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		VentanaPrinicipalMejorada.getVentanaMapa().setResizable(false);
		VentanaPrinicipalMejorada.getVentanaMapa().setLayout(new BorderLayout());
		VentanaPrinicipalMejorada.getVentanaMapa().add(this, BorderLayout.CENTER);
		VentanaPrinicipalMejorada.getVentanaMapa().pack();
		centreWindow(VentanaPrinicipalMejorada.getVentanaMapa());
		VentanaPrinicipalMejorada.getVentanaMapa().setVisible(true);	
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	public synchronized void iniciarThreadMapa() {
		VentanaPrinicipalMejorada.setHiloMapaEnFuncionamiento(true);
		
		VentanaPrinicipalMejorada.setHiloMapa(new Thread(this, "Gráficos Mapa"));
		VentanaPrinicipalMejorada.getHiloMapa().start();
		
	}
	
	public synchronized void detenerThreadMapa() {
		VentanaPrinicipalMejorada.setHiloMapaEnFuncionamiento(false);
		
		try {
			VentanaPrinicipalMejorada.getHiloMapa().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar () {
		ms++;
	}
	
	public void mostrar () {
		fps++;
	}
	
	public void run() {
		final int NS_POR_SEGUNDO=1000000000;
		final byte MS_OBJETIVO=60;
		final double NS_POR_ACTUALIZACION= NS_POR_SEGUNDO/MS_OBJETIVO;
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		double tiempoTranscurrido;
		double delta=0;
		
		while (VentanaPrinicipalMejorada.isHiloMapaEnFuncionamiento()) {
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido=inicioBucle-referenciaActualizacion;
			referenciaActualizacion=inicioBucle;
			delta+=tiempoTranscurrido/NS_POR_ACTUALIZACION;
			
			while(delta>=1) {
				this.actualizar();
				delta--;
			}
			this.mostrar();
			if (System.nanoTime() - referenciaContador> NS_POR_SEGUNDO) {
				VentanaPrinicipalMejorada.getVentanaMapa().setTitle(NOMBRE_VENTANA_MAPA+ " || ms: " +ms+ " fps: "+ fps);
				ms=0;
				fps=0;
				referenciaContador= System.nanoTime();
			}
			
		}
	}

	public static JFrame getVentanaMapa() {
		return ventanaMapa;
	}

	public static void setVentanaMapa(JFrame ventanaMapa) {
		VentanaPrinicipalMejorada.ventanaMapa = ventanaMapa;
	}

	public static Thread getHiloMapa() {
		return hiloMapa;
	}
	
	public static void setHiloMapa(Thread hiloMapa) {
		VentanaPrinicipalMejorada.hiloMapa = hiloMapa;
	}
	
	public static boolean isHiloMapaEnFuncionamiento() {
		return hiloMapaEnFuncionamiento;
	}

	public static void setHiloMapaEnFuncionamiento(boolean hiloMapaEnFuncionamiento) {
		VentanaPrinicipalMejorada.hiloMapaEnFuncionamiento = hiloMapaEnFuncionamiento;
	}
	
	public static void main(String[] args) {	
		VentanaPrinicipalMejorada mapa = new VentanaPrinicipalMejorada();
		mapa.iniciarThreadMapa();
	}



	
}
