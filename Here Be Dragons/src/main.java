import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner comand = new Scanner(System.in);
		int key = 0, hero = 0, dragon = 0, exit = 0, l = 0, c = 0, found_it = 0, candle = 0;

		int[] hero_vector;
		hero_vector = new int[2];

		String[][] mapa = { { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" },
				{ "X", " ", " ", " ", " ", " ", " ", " ", " ", "X" },
				{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
				{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
				{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
				{ "X", " ", " ", " ", " ", " ", " ", "X", " ", "X" },
				{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
				{ "X", " ", "X", "X", " ", "X", " ", "X", " ", "X" },
				{ "X", " ", "X", "X", " ", " ", " ", " ", " ", "X" },
				{ "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" } };

		while (key != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa[random_l][random_c] == " ") {
				mapa[random_l][random_c] = "K";
				key = 1;
			}
		}
		while (hero != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa[random_l][random_c] == " ") {
				mapa[random_l][random_c] = "H";
				hero_vector[0] = random_l;
				hero_vector[1] = random_c;
				hero = 1;
			}
		}
		while (dragon != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa[random_l][random_c] == " " && mapa[random_l + 1][random_c] != "H"
					&& mapa[random_l - 1][random_c] != "H" && mapa[random_l][random_c + 1] != "H"
					&& mapa[random_l][random_c - 1] != "H") {
				mapa[random_l][random_c] = "D";
				dragon = 1;
			}
		}
		while (exit != 1) {
			int random_l = 0 + (int) (Math.random() * 9);
			int random_c = 0 + (int) (Math.random() * 9);
			if ((random_l - random_c) == 0 || (random_l - random_c) == 9 || (random_l - random_c) == -9)
				continue;
			// ficar nos cantos

			if (random_c == 0 || random_c == 9) {
				mapa[random_l][random_c] = "E";
				exit = 1;
			} else if (random_l == 0 || (random_l == 9 && (random_c != 2 && random_c != 3))) {
				mapa[random_l][random_c] = "E";
				exit = 1;
			}
			// ficar so nas arestas
		}
		while (true) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(mapa[i][j] + " ");
				}
				System.out.println();
			}
			l = 0;
			c = 0;

			String comando = comand.nextLine();

			switch (comando) {
			case "u":
				l = -1;
				break;

			case "d":
				l = 1;
				break;

			case "r":
				c = 1;
				break;

			case "l":
				c = -1;
				break;
			}

			if (mapa[hero_vector[0] + l][hero_vector[1] + c] != "X") {

				if (mapa[hero_vector[0] + l][hero_vector[1] + c] == "K")
					found_it = 1;
				if (mapa[hero_vector[0] + l][hero_vector[1] + c] == "E" && found_it == 1)
					break;
				else if (mapa[hero_vector[0] + l][hero_vector[1] + c] == "E")
					continue;
				mapa[hero_vector[0]][hero_vector[1]] = " ";
				hero_vector[0] = hero_vector[0] + l;
				hero_vector[1] = hero_vector[1] + c;

				if (mapa[hero_vector[0] + 1][hero_vector[1]] == "D" || mapa[hero_vector[0] - 1][hero_vector[1]] == "D"
						|| mapa[hero_vector[0]][hero_vector[1] + 1] == "D"
						|| mapa[hero_vector[0]][hero_vector[1] - 1] == "D") {
					candle = 1;
					break;
				}

				mapa[hero_vector[0]][hero_vector[1]] = "H";
			}

		}
		if (candle == 1)
			System.out.println("\nAPRENDA A JOGAR ISTO, NÃO SEJA PARVO\n");
		else
			System.out.println("\nVÁ\n...\nLÁ CONSEGUIU SAIR DISTO\n");
		comand.close();
	}

}
