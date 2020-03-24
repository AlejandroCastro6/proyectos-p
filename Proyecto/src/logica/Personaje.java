package logica;

public class Personaje {

	private int idPersonaje;
	private int colorPersonaje;
	private String vozPersonaje;
	private String uniformePersonaje;
	private String banderaPersonaje;
	private String logoPersonaje;
	private Jugador jugadorPersonaje;

	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	public Personaje(int idPersonaje, int colorPersonaje, String vozPersonaje,
			String uniformePersonaje, String banderaPersonaje,
			String logoPersonaje, Jugador jugadorPersonaje) {
		this.setIdPersonaje(idPersonaje);
		this.setColorPersonaje(colorPersonaje);
		this.setVozPersonaje(vozPersonaje);
		this.setUniformePersonaje(uniformePersonaje);
		this.setBanderaPersonaje(banderaPersonaje);
		this.setLogoPersonaje(logoPersonaje);
		this.setJugadorPersonaje(jugadorPersonaje);

	}

	public int getColorPersonaje() {
		return colorPersonaje;
	}

	public void setColorPersonaje(int colorPersonaje) {
		this.colorPersonaje = colorPersonaje;
	}

	public String getVozPersonaje() {
		return vozPersonaje;
	}

	public void setVozPersonaje(String vozPersonaje) {
		this.vozPersonaje = vozPersonaje;
	}

	public String getUniformePersonaje() {
		return uniformePersonaje;
	}

	public void setUniformePersonaje(String uniformePersonaje) {
		this.uniformePersonaje = uniformePersonaje;
	}

	public String getBanderaPersonaje() {
		return banderaPersonaje;
	}

	public void setBanderaPersonaje(String banderaPersonaje) {
		this.banderaPersonaje = banderaPersonaje;
	}

	public String getLogoPersonaje() {
		return logoPersonaje;
	}

	public void setLogoPersonaje(String logoPersonaje) {
		this.logoPersonaje = logoPersonaje;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public Jugador getJugadorPersonaje() {
		return jugadorPersonaje;
	}

	public void setJugadorPersonaje(Jugador jugadorPersonaje) {
		this.jugadorPersonaje = jugadorPersonaje;
	}

}
