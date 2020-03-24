package logica;

public class RespuestaPregunta {
	private Pregunta pregunta;
	private Respuesta respuesta;
	
	public RespuestaPregunta() {
		// TODO Auto-generated constructor stub
	}
	
	public RespuestaPregunta(Pregunta pregunta, Respuesta respuesta) {
		this.setPregunta(pregunta);
		this.setRespuesta(respuesta);
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
	

}
