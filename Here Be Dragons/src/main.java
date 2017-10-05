
import logic.mapa;
import logic.movimento;

public class main {

	public static void main(String[] args) {

		mapa mapaObject = new mapa();
		mapaObject.ColocaElementos();
		game gameObject = new game();
		
		while (true) {
		mapaObject.printMap();
		gameObject.Iteracao();
		
		
		}
	}
}
