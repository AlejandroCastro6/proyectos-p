package interfaz;

public final class Sprite {
	private final int lado;
	private int x;
	private int y;
	private HojaSprites hoja;
	public int[] pixeles;

	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		this.pixeles = new int[lado * lado];

		this.setX(columna * lado);
		this.setY(fila * lado);

		this.setHoja(hoja);

		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				this.pixeles[x + y * lado] = this.getHoja().pixeles[(x + this. getX())
						+ (y + this.getY()) * this.getHoja().getAncho()];

			}
		}
	}

	public int getLado() {
		return lado;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public HojaSprites getHoja() {
		return hoja;
	}

	public void setHoja(HojaSprites hoja) {
		this.hoja = hoja;
	}
}
