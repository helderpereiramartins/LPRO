package logic;

public class hero {
	public static int[] hero_vector;

	public static String hero_s = "H";
	public static int found_it = 0;

	public int armed = 0;;
	public static int win = 0;
	public int continue1 = 0;
	
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
	public void MoveHeroi(int l, int c) {
		


		continue1 = 0;

		if (mapa.mapa[hero_vector[0] + l][hero_vector[1] + c] != "X") {

			if (mapa.mapa[hero_vector[0] + l][hero_vector[1] + c] == "S") {
				armed = 1;
				hero.hero_s = "A";
			}

			if (mapa.mapa[hero_vector[0] + l][hero_vector[1] + c] == "E" && found_it == 1)
				win = 1;
			else if (mapa.mapa[hero_vector[0] + l][hero_vector[1] + c] == "E")
				continue1 = 1;

			if(continue1!=1 && win!=1) {
			mapa.mapa[hero_vector[0]][hero_vector[1]] = " ";
			hero_vector[0] = hero_vector[0] + l;
			hero_vector[1] = hero_vector[1] + c;

			if (hero_s != "A" && (mapa.mapa[hero_vector[0] + 1][hero_vector[1]] == "D"
					|| mapa.mapa[hero_vector[0] - 1][hero_vector[1]] == "D"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] + 1] == "D"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] - 1] == "D"
					|| mapa.mapa[hero_vector[0] + 1][hero_vector[1]] == "F"
					|| mapa.mapa[hero_vector[0] - 1][hero_vector[1]] == "F"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] + 1] == "F"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] - 1] == "F")) 
				win = -1;
			
			else if(hero_s == "A" && (mapa.mapa[hero_vector[0] + 1][hero_vector[1]] == "D"
					|| mapa.mapa[hero_vector[0] - 1][hero_vector[1]] == "D"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] + 1] == "D"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] - 1] == "D"
					|| mapa.mapa[hero_vector[0] + 1][hero_vector[1]] == "F"
					|| mapa.mapa[hero_vector[0] - 1][hero_vector[1]] == "F"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] + 1] == "F"
					|| mapa.mapa[hero_vector[0]][hero_vector[1] - 1] == "F")) 
				found_it=1;			
			
			}
			mapa.mapa[hero_vector[0]][hero_vector[1]] = hero_s;
		}
	
	}

}