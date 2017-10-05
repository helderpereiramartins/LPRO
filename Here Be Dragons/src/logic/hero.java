package logic;

public class hero {
	public static int[] hero_vector;
	

	public void ColocaHeroi() {
		hero_vector = new int[2];
		int hero = 0;

		while (hero != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa.mapa[random_l][random_c] == " ") {
				mapa.mapa[random_l][random_c] = "H";
				hero_vector[0] = random_l;
				hero_vector[1] = random_c;
				hero = 1;
			}
		}
	}

}