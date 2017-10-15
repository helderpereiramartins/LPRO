
import logic.Mapa;

public class Main {

	public static void main(String[] args) {

		Mapa mapaObject = Mapa.getInstance();

			mapaObject.ColocaElementos();
			Game gameObject = new Game();

			while (true) {
				mapaObject.printMap();
				
				if (mapaObject.getHeroObject().getWin() == 1) {
					System.out.print("\nGanhou sabe?\n");
					break;
				}
				
				gameObject.Iteracao();
				
				if (mapaObject.getHeroObject().getWin() == -1) {
					mapaObject.printMap();
					System.out.print("\nPerdeu sabe?\n");
					break;
				}
			}

	}

}
