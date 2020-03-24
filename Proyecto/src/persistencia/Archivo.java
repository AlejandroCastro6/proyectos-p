package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Archivo {
	public final static int TAM = 100;

	private String[] vectorP;
	private int  posPregunta;

	File f;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw = null;
	BufferedReader br = null;

	public Archivo(String nameFile) {
		vectorP = new String[TAM];
		f = new File(nameFile);
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

	public void mostrarVectorArchivo() {
		for (int i = 0; i < vectorP.length; i++) {
			System.out.println(vectorP[i]);
		}
	}
	
	

	public int preguntaAleatoria() {
		int respuesta=0;
		posPregunta = (int) (Math.random() * 100) + 1;
		System.out.println(posPregunta);
		System.out.println(vectorP[posPregunta]);
		if (posPregunta < 50){ 
			respuesta = 1;
			System.out.println(respuesta);
		}else{
			System.out.println(respuesta);
			respuesta=0;
		}
		return respuesta;
	}
	
}