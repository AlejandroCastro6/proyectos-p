package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.applet.AudioClip;
//import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;


public class PanelFondoInicio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	private ArrayList<String> rutaGifSonFondo;
	private AudioClip sonidoFondo;
	private Dimension tamanio;
	private ImageIcon imagenFondo;

	public PanelFondoInicio() {
		this.setRutaGifSonFondo(this.inicioAleatorio());
		this.setSonidoFondo(java.applet.Applet.newAudioClip(getClass().getResource(this.getRutaGifSonFondo().get(1))));
//		System.out.println(this.getSonidoFondo().getClass().getName());
		this.getSonidoFondo().play();
		this.setSize(400, 280);
	}

	public Dimension getTamanio() {
		return tamanio;
	}

	public void setTamanio(Dimension tamanio) {
		this.tamanio = tamanio;
	}

	public ImageIcon getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(ImageIcon imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	public ArrayList<String> llenarListaRutasImagen() {
		ArrayList<String> listaRutas = new ArrayList<String>();
		listaRutas.add("/img/ventanaInicio/benjenDany.gif");
		listaRutas.add("/img/ventanaInicio/branWhite.gif");
		listaRutas.add("/img/ventanaInicio/daneJon.gif");
		listaRutas.add("/img/ventanaInicio/daneWhite.gif");
		listaRutas.add("/img/ventanaInicio/freys.gif");
		listaRutas.add("/img/ventanaInicio/gifOfThrones.gif");
		listaRutas.add("/img/ventanaInicio/gotTv.gif");
		listaRutas.add("/img/ventanaInicio/samuelT.gif");
		listaRutas.add("/img/ventanaInicio/thahund.gif");
		listaRutas.add("/img/ventanaInicio/violinWhite.gif");
		return listaRutas;

	}
	
	public ArrayList<String> llenarListaRutasSonido() {
		ArrayList<String> listaRutas = new ArrayList<String>();
		listaRutas.add("/son/ventanaInicio/benjenDany.wav");
		listaRutas.add("/son/ventanaInicio/branWhite.wav");
		listaRutas.add("/son/ventanaInicio/daneJon.wav");
		listaRutas.add("/son/ventanaInicio/daneWhite.wav");
		listaRutas.add("/son/ventanaInicio/freys.wav");
		listaRutas.add("/son/ventanaInicio/inicioGot.wav");
		listaRutas.add("/son/ventanaInicio/GotTv.wav");
		listaRutas.add("/son/ventanaInicio/samuelT.wav");
		listaRutas.add("/son/ventanaInicio/thahund.wav");
		listaRutas.add("/son/ventanaInicio/violinWhite.wav");
		return listaRutas;
	}

	public ArrayList<String> inicioAleatorio() {
		ArrayList<String> listaRutasImagen = this.llenarListaRutasImagen();
		ArrayList<String> listaRutasSonido = this.llenarListaRutasSonido();
		int numeroGif = ((int) (Math.random() * listaRutasImagen.size()) + 1);
//		int numeroGif = 7;
		ArrayList<String> rutaGifSon = new ArrayList<String>();
		for (int i = 0; i < listaRutasImagen.size(); i++) {
			if (numeroGif - 1 == i) {
				rutaGifSon.add(listaRutasImagen.get(i).toString());
				rutaGifSon.add(listaRutasSonido.get(i).toString());
				break;
			}
		}
		System.out.println(numeroGif - 1);
		return rutaGifSon;
	}

	@Override
	public void paintComponent(Graphics g) {
		this.setTamanio(getSize());
		this.setImagenFondo(new ImageIcon(getClass().getResource(
				this.getRutaGifSonFondo().get(0))));
		g.drawImage(this.getImagenFondo().getImage(), 0, 0,
				this.getTamanio().width, this.getTamanio().height, this);
		setOpaque(false);
		super.paintComponent(g);
	}



	public AudioClip getSonidoFondo() {
		return sonidoFondo;
	}

	public void setSonidoFondo(AudioClip sonidoFondo) {
		this.sonidoFondo = sonidoFondo;
	}

	public ArrayList<String> getRutaGifSonFondo() {
		return rutaGifSonFondo;
	}

	public void setRutaGifSonFondo(ArrayList<String> rutaGifSonFondo) {
		this.rutaGifSonFondo = rutaGifSonFondo;
	}

}
