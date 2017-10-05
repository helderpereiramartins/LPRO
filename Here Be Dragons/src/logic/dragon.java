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

	public void MoveDragao() {
		
		int dragon_moved = 0;
		while (dragon_moved != 1) {
			int random_l = -1 + (int) (Math.random() * 1);
			int random_c = -1 + (int) (Math.random() * 1);
//////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			if (mapa.mapa[dragon_vector[0]+random_l][dragon_vector[1]+random_c] == " ") {
				mapa.mapa[dragon_vector[0]][dragon_vector[1]] = " ";
				dragon_vector[0] = dragon_vector[0]+random_l;
				dragon_vector[1] = dragon_vector[1]+random_c;
				mapa.mapa[dragon_vector[0]][dragon_vector[1]] = "D";
				
				dragon_moved = 1;
		
	}}}
	
}