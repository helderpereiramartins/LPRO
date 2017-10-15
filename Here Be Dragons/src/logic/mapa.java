package logic;

public class mapa {
	public static String[][] mapa = { { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
			{ "X", " ", " ", " ", " ", " ", " ", " ", " ", "X" }, 
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" }, 
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
			{ "X", " ", " ", " ", " ", " ", " ", "X", " ", "X" }, 
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
			{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" }, 
			{ "X", " ", "X", "X", " ", " ", " ", " ", " ", "X" },
			{ "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" } };

	
	public static hero heroObject = new hero();
	static dragon dragonObject = new dragon();
	exit exitObject = new exit();
	sord sordObject = new sord();
	
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

	public static hero getHeroObject() {
		return heroObject;
	}
}
