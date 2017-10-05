package logic;

public class sord {
	public void ColocaEspada() {
		int espada = 0;
		while (espada != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapa.mapa[random_l][random_c] == " " && mapa.mapa[random_l][random_c] != "H"
					&& mapa.mapa[random_l][random_c] != "D") {
				mapa.mapa[random_l][random_c] = "S";
				espada = 1;
			}
		}
	}
}