package logic;

public class dragon {
	public void ColocaDragao() {
		int dragon = 0;
		while (dragon != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa.mapa[random_l][random_c] == " " && mapa.mapa[random_l + 1][random_c] != "H"
					&& mapa.mapa[random_l - 1][random_c] != "H" && mapa.mapa[random_l][random_c + 1] != "H"
					&& mapa.mapa[random_l][random_c - 1] != "H") {
				mapa.mapa[random_l][random_c] = "D";
				dragon = 1;
			}
		}
	}
}