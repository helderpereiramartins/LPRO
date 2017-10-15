package logic;

/**
 * @author hmartins
 *
 */
public final class Mapa {

	private String[][] mapa = 
		  { { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "X", " ", " ", " ", " ", " ", " ", " ", " ", "X" }, 
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" }, 
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
			{ "X", " ", " ", " ", " ", " ", " ", "X", " ", "X" }, 
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" }, 
			{ "X", " ", "X", "X", " ", " ", " ", " ", " ", "X" },
			{ "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" } };

	private Hero heroObject = new Hero();
	private Dragon dragonObject = new Dragon();
	private Exit exitObject = new Exit();
	private Sord sordObject = new Sord();

	/**
	 * Singleton para garantir que chamamos sempre o mesmo objeto Mapa
	 */
	private static final Mapa INSTANCE = new Mapa();

	private Mapa() {

	}

	public static Mapa getInstance() {
		return INSTANCE;
	}

	public String[][] getMapa() {
		return this.mapa;
	}


	public void ColocaElementos() {

		heroObject.ColocaHeroi();

		dragonObject.ColocaDragao();

		exitObject.ColocaSaida();

		sordObject.ColocaEspada();
	}

	public void printMap() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(mapa[i][j] + " ");
			}
			System.out.println();

		}

	}

	public Hero getHeroObject() {
		return this.heroObject;
	}

	public void setMapa(String[][] mapa) {
		this.mapa = mapa;
	}

	public Dragon getDragonObject() {
		return dragonObject;
	}

	public void setDragonObject(Dragon dragonObject) {
		this.dragonObject = dragonObject;
	}

	public void setHeroObject(Hero heroObject) {
		this.heroObject = heroObject;
	}
	
}
