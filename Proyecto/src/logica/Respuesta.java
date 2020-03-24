package logica;

public class Respuesta {

	private int idRespuesta;
	private char tipoRespuesta;
	private String contenidoRespuesta;

	public Respuesta() {
		// TODO Auto-generated constructor stub
	}

	public Respuesta(int idRespuesta, char tipoRespuesta,
			String contenidoRespuesta) {
		this.setIdRespuesta(idRespuesta);
		this.setTipoRespuesta(tipoRespuesta);
		this.setContenidoRespuesta(contenidoRespuesta);
	}

	public char getTipoRespuesta() {
		return tipoRespuesta;
	}

	public void setTipoRespuesta(char tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	public String getContenidoRespuesta() {
		return contenidoRespuesta;
	}

	public void setContenidoRespuesta(String contenidoRespuesta) {
		this.contenidoRespuesta = contenidoRespuesta;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

}
