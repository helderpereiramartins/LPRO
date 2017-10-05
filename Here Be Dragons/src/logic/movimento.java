package logic;

public class movimento {
	public int candle = 0, found_it = 0;
	public static int break1 = 0;
	public int continue1 = 0;

	public void movement(int l, int c) {

		break1=0;
		continue1=0;
		
		if (mapa.mapa[hero.hero_vector[0] + l][hero.hero_vector[1] + c] != "X") {

			// if (mapa.mapa[hero.hero_vector[0] + l][hero.hero_vector[1] + c] == "K")
			// found_it = 1;
			if (mapa.mapa[hero.hero_vector[0] + l][hero.hero_vector[1] + c] == "E" && found_it == 1)
				break1=1;
			else if (mapa.mapa[hero.hero_vector[0] + l][hero.hero_vector[1] + c] == "E")
				continue1=1;

			mapa.mapa[hero.hero_vector[0]][hero.hero_vector[1]] = " ";
			hero.hero_vector[0] = hero.hero_vector[0] + l;
			hero.hero_vector[1] = hero.hero_vector[1] + c;

			if (mapa.mapa[hero.hero_vector[0] + 1][hero.hero_vector[1]] == "D"
					|| mapa.mapa[hero.hero_vector[0] - 1][hero.hero_vector[1]] == "D"
					|| mapa.mapa[hero.hero_vector[0]][hero.hero_vector[1] + 1] == "D"
					|| mapa.mapa[hero.hero_vector[0]][hero.hero_vector[1] - 1] == "D") {
				candle = 1;
				break1=1;
			}

			mapa.mapa[hero.hero_vector[0]][hero.hero_vector[1]] = "H";
		}
	}
}
