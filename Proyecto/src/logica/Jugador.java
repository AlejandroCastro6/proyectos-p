package logica;

public class Jugador {

	private int idJugador;
	private String nombreJugador;
	private char generoJugador;
	private String emailJugador;
	private int respuesta1;
	private int respuesta2;
	private int posPregunta1 = 0;
	private int posPregunta2 = 2;

	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(int idJugador, String nombreJugador, char generoJugador,
			String emailJugador, Personaje personajeJugador) {
		this.idJugador=idJugador;
		this.nombreJugador=nombreJugador;
		this.generoJugador=generoJugador;
		this.emailJugador=emailJugador;
	}

	public int getPosPregunta1() {
		return posPregunta1;
	}

	public void setPosPregunta1(int posPregunta1) {
		this.posPregunta1 = posPregunta1;
	}

	public int getPosPregunta2() {
		return posPregunta2;
	}

	public void setPosPregunta2(int posPregunta2) {
		this.posPregunta2 = posPregunta2;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public char getGeneroJugador() {
		return generoJugador;
	}

	public void setGeneroJugador(char generoJugador) {
		this.generoJugador = generoJugador;
	}

	public String getEmailJugador() {
		return emailJugador;
	}

	public void setEmailJugador(String emailJugador) {
		this.emailJugador = emailJugador;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	
	public int buscaRespuesta1() {
		setPosPregunta1((int) (Math.random() * 100) + 1);
		if (getPosPregunta1() < 50) {
			respuesta1 = 0;
		} else {
			respuesta1 = 1;
		}
		return respuesta1;
	}

	public int buscaRespuesta2() {
		posPregunta2 = ((int) (Math.random() * 100) + 1);
		if (getPosPregunta2() < 50) {
			respuesta2 = 0;
		} else {
			respuesta2 = 1;
		}
		return respuesta2;
	}

}