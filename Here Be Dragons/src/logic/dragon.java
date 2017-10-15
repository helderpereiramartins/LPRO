package logic;

public class dragon {

	public static int[] dragon_vector;

	public void ColocaDragao() {
		dragon_vector = new int[2];
		int dragon = 0;
		while (dragon != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa.mapa[random_l][random_c] == " " && mapa.mapa[random_l + 1][random_c] != "H"
					&& mapa.mapa[random_l - 1][random_c] != "H" && mapa.mapa[random_l][random_c + 1] != "H"
					&& mapa.mapa[random_l][random_c - 1] != "H") {
				mapa.mapa[random_l][random_c] = "D";
				dragon_vector[0] = random_l;
				dragon_vector[1] = random_c;
				dragon = 1;
			}
		}
	}

	public static int[] getDragon_vector() {
		return dragon_vector;
	}

	public static void setDragon_vector(int[] dragon_vector) {
		dragon.dragon_vector = dragon_vector;
	}

	public void MoveDragao() {

		int dragon_moved = 0;
		while (dragon_moved != 1) {
			int random_l = (1 + (int) (Math.random() * 3)) - 2;
			int random_c = (1 + (int) (Math.random() * 3)) - 2;
			//////////////////////////////////////////////////////////////////////////////////////////////////////

			if (random_l - random_c != 1 && random_l - random_c != -1)
				continue;

			if (mapa.mapa[dragon_vector[0] + random_l][dragon_vector[1] + random_c] == " ") {

				if (mapa.mapa[dragon_vector[0]][dragon_vector[1]] == "F")
					mapa.mapa[dragon_vector[0]][dragon_vector[1]] = "S";
				else
					mapa.mapa[dragon_vector[0]][dragon_vector[1]] = " ";

				dragon_vector[0] = dragon_vector[0] + random_l;
				dragon_vector[1] = dragon_vector[1] + random_c;
				mapa.mapa[dragon_vector[0]][dragon_vector[1]] = "D";

				dragon_moved = 1;

			} else if (mapa.mapa[dragon_vector[0] + random_l][dragon_vector[1] + random_c] == "S") {

				mapa.mapa[dragon_vector[0]][dragon_vector[1]] = " ";
				dragon_vector[0] = dragon_vector[0] + random_l;
				dragon_vector[1] = dragon_vector[1] + random_c;
				mapa.mapa[dragon_vector[0]][dragon_vector[1]] = "F";

				dragon_moved = 1;
				// \\\\\\\\\\\\\\\\\\\\\\\\\\\adicionar parar isto quando o dragao
				// morre\\\\\\\\\\\\\\
			}
		}
		if ((mapa.mapa[dragon_vector[0] + 1][dragon_vector[1]] == "H"
				|| mapa.mapa[dragon_vector[0] - 1][dragon_vector[1]] == "H"
				|| mapa.mapa[dragon_vector[0]][dragon_vector[1] + 1] == "H"
				|| mapa.mapa[dragon_vector[0]][dragon_vector[1] - 1] == "H")) {
			hero.win = -1;
			mapa.mapa[hero.hero_vector[0]][hero.hero_vector[1]] = "_";
		}

		else if ((mapa.mapa[dragon_vector[0] + 1][dragon_vector[1]] == "A"
				|| mapa.mapa[dragon_vector[0] - 1][dragon_vector[1]] == "A"
				|| mapa.mapa[dragon_vector[0]][dragon_vector[1] + 1] == "A"
				|| mapa.mapa[dragon_vector[0]][dragon_vector[1] - 1] == "A")) {
			hero.found_it = 1;
			mapa.mapa[dragon_vector[0]][dragon_vector[1]] = " ";
		}

	}
}