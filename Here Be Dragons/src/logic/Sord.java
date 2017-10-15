package logic;

public class Sord {
	public void ColocaEspada() {
		
	    Mapa mapaObject = Mapa.getInstance();
		String[][] mapaVector = mapaObject.getMapa() ;
		
		int espada = 0;
		while (espada != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapaVector[random_l][random_c] == Variables.PIN_HALL && mapaVector[random_l][random_c] !=Variables.PIN_HERO
					&& mapaVector[random_l][random_c] != Variables.PIN_DRAG) {
				mapaVector[random_l][random_c] = Variables.PIN_SWRD;
				mapaObject.setMapa(mapaVector);
				espada = 1;
			}
		}
	}
}