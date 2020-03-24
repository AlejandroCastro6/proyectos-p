package logica;

public class Pregunta {

	private int idPregunta;
	private String areaPregunta;
	private char dificultadPregunta;
	private double tiempoPregunta;
	private String contenidoPregunta;

	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	public Pregunta(int idPregunta, String areaPregunta,
			char dificultadPregunta, double tiempoPregunta,
			String contenidoPregunta) {
		this.setIdPregunta(idPregunta);
		this.setAreaPregunta(areaPregunta);
		this.setDificultadPregunta(dificultadPregunta);
		this.setTiempoPregunta(tiempoPregunta);
		this.setContenidoPregunta(contenidoPregunta);
	}

	public String getAreaPregunta() {
		return areaPregunta;
	}

	public void setAreaPregunta(String areaPregunta) {
		this.areaPregunta = areaPregunta;
	}

	public String getContenidoPregunta() {
		return contenidoPregunta;
	}

	public void setContenidoPregunta(String contenidoPregunta) {
		this.contenidoPregunta = contenidoPregunta;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public double getTiempoPregunta() {
		return tiempoPregunta;
	}

	public void setTiempoPregunta(double tiempoPregunta) {
		this.tiempoPregunta = tiempoPregunta;
	}

	public char getDificultadPregunta() {
		return dificultadPregunta;
	}

	public void setDificultadPregunta(char dificultadPregunta) {
		this.dificultadPregunta = dificultadPregunta;
	}

}
