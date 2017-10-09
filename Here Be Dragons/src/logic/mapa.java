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

	public void ColocaElementos() {
		hero heroObject = new hero();
		heroObject.ColocaHeroi();

		dragon dragonObject = new dragon();
		dragonObject.ColocaDragao();

		exit exitObject = new exit();
		exitObject.ColocaSaida();

		sord sordObject = new sord();
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
}
