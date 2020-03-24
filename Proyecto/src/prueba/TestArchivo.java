package prueba;

import persistencia.Archivo;

//import javax.swing.JOptionPane;

public class TestArchivo {
	
	public static void main(String[] args) {
		Archivo archivo = new Archivo("D:/Zooey/Preguntas.txt");
		
		// proceso de escribir el archivo		
		/*
		archivo.abrir('w');
		archivo.escribirArchivo();
		archivo.cerrar();
		 */
		archivo.abrir('r');
		archivo.vectorArchivo();
		archivo.cerrar();
//		archivo.mostrarVectorArchivo();
		archivo.preguntaAleatoria();
						
	}
	
}
