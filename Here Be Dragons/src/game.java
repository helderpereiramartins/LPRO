import java.util.Scanner;

import logic.mapa;
import logic.movimento;


public class game {
	public static int l = 0, c = 0;
	static Scanner comand = new Scanner(System.in);
	movimento movimentoObject = new movimento();
	
	public void Iteracao() {
		while (true) {

			l = 0;
			c = 0;

			String comando = comand.nextLine();

			switch (comando) {
			case "w":
				l = -1;
				break;

			case "s":
				l = 1;
				break;

			case "d":
				c = 1;
				break;

			case "a":
				c = -1;
				break;
			}
			
			
			
			break;
		}
		movimentoObject.movement(l, c);

	}
}
