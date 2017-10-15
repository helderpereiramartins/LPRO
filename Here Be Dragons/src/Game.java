import java.util.Scanner;

import logic.Movimento;

public class Game {
	private static int l = 0, c = 0;
	static Scanner comand = new Scanner(System.in);
	
	private static final String KEY_UP = "w";
	private static final String KEY_DOWN = "s";
	private static final String KEY_RIGHT = "d";
	private static final String KEY_LEFT = "a";
			
	
	Movimento movimentoObject = new Movimento();
	
	public void Iteracao() {
		while (true) {

			l = 0;
			c = 0;

			String comando = comand.nextLine();

			switch (comando) {
			case KEY_UP:
				l = -1;
				break;

			case KEY_DOWN:
				l = 1;
				break;

			case KEY_RIGHT:
				c = 1;
				break;

			case KEY_LEFT:
				c = -1;
				break;
			}
			
			
			
			break;
		}
		movimentoObject.movement(l, c);


	}
}
