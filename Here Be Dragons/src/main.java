
import logic.mapa;
import logic.hero;


public class main {

	public static void main(String[] args) {

		mapa mapaObject = new mapa();
		mapaObject.ColocaElementos();
		game gameObject = new game();
		
		while (true) {
		mapaObject.printMap();
		if(hero.win==1) {System.out.print("\nGanhou sabe?\n");break;}
		gameObject.Iteracao();
		if(hero.win==-1) {mapaObject.printMap();System.out.print("\nPerdeu sabe?\n");break;}
		
		
		}
	}
}
