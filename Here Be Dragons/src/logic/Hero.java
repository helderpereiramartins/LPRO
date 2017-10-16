package logic;

import java.util.ArrayList;

public class Hero {
	private int[] heroVector;

	private String heroState = Variables.PIN_HERO;
	private int foundIt=0;

	private boolean armed = false;
	private int win = 0;
	private boolean continueAux = false;
	
	
	public void ColocaHeroi() {
	 Mapa mapaObject = Mapa.getInstance();
	 
		
		String[][] mapaVector = mapaObject.getMapa();
		heroVector = new int[2];

		int hero = 0;

		while (hero != 1) {
			int random_l = 1 + (int) (Math.random() * 8);
			int random_c = 1 + (int) (Math.random() * 8);

			if (mapaVector[random_l][random_c] == Variables.PIN_HALL) {
				
				mapaVector[random_l][random_c] = Variables.PIN_HERO;
				mapaObject.setMapa(mapaVector);
				
				heroVector[0] = random_l;
				heroVector[1] = random_c;
				hero = 1;
			}
		}
	}
	public void MoveHeroi(int l, int c) {
		Mapa mapaObject = Mapa.getInstance();
		String[][] mapaVector = mapaObject.getMapa();
		ArrayList<Dragon> list = mapaObject.getList();
		//Dragon mapaDragon = mapaObject.getDragonObject();


		continueAux = false;

		if (mapaVector[heroVector[0] + l][heroVector[1] + c] != Variables.PIN_WALL) {
			
		 /************************************ HEROI ************************************************/
			
			if (mapaVector[heroVector[0] + l][heroVector[1] + c] == Variables.PIN_SWRD) {
				armed = true;
				heroState = Variables.PIN_HERO_ARM;
			}
			if (mapaVector[heroVector[0] + l][heroVector[1] + c] == Variables.PIN_EXIT && foundIt==0) {
				win = 1;
			}
			
			else if ( (mapaVector[heroVector[0] + l][heroVector[1] + c] == Variables.PIN_EXIT) || 
					   (mapaVector[heroVector[0] + l][heroVector[1] + c] == Variables.PIN_DRAG_SLEEP)) {
				continueAux = true;
			}

			if(!continueAux && win!=1) {
			mapaVector[heroVector[0]][heroVector[1]] = Variables.PIN_HALL;
			
			heroVector[0] = heroVector[0] + l;
			heroVector[1] = heroVector[1] + c;

			
		/************************************ DRAGÃO ************************************************/

			
			
			if (heroState != Variables.PIN_HERO_ARM && (mapaVector[heroVector[0] + 1][heroVector[1]] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0] - 1][heroVector[1]] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0]][heroVector[1] + 1] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0]][heroVector[1] - 1] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0] + 1][heroVector[1]] == Variables.PIN_DRAG_SWRD
					|| mapaVector[heroVector[0] - 1][heroVector[1]] == Variables.PIN_DRAG_SWRD
					|| mapaVector[heroVector[0]][heroVector[1] + 1] == Variables.PIN_DRAG_SWRD
					|| mapaVector[heroVector[0]][heroVector[1] - 1] == Variables.PIN_DRAG_SWRD)) {
				win = -1;
				heroState = Variables.PIN_HERO_DEAD;
						
			}
			

			
			
			// Verificar qualquer fragão, a dormir ou acordado. Usado o .toUpperCase() para por sempre o pin do dragão a "D"
			else if(heroState == Variables.PIN_HERO_ARM && 
					 ( mapaVector[heroVector[0] + 1][heroVector[1]] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0] - 1][heroVector[1]] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0]][heroVector[1] + 1] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0]][heroVector[1] - 1] == Variables.PIN_DRAG
					|| mapaVector[heroVector[0] + 1][heroVector[1]] == Variables.PIN_DRAG_SLEEP
					|| mapaVector[heroVector[0] - 1][heroVector[1]] == Variables.PIN_DRAG_SLEEP
					|| mapaVector[heroVector[0]][heroVector[1] + 1] == Variables.PIN_DRAG_SLEEP
					|| mapaVector[heroVector[0]][heroVector[1] - 1] == Variables.PIN_DRAG_SLEEP
							 
							 ) ) {
				foundIt--;		
				
				// Dragaoo é morto
				/*faz todas as hipoteses de periferia do heroi e verifica se coincide com
				 * qualquer um dos drag�es, coordenadas sao comparadas individualmente
				 * mas tem de ser simultaneas &&*/
				for(int i=0; i<list.size(); i++) {
					if(
							(( (heroVector[0] + 1) == list.get(i).getDragonVector()[0]) 
							&& ( (heroVector[1]) == list.get(i).getDragonVector()[1]))
							
							|| (( (heroVector[0] - 1) == list.get(i).getDragonVector()[0]) 
							&& ( (heroVector[1]) == list.get(i).getDragonVector()[1]))
							
							|| (( (heroVector[0]) == list.get(i).getDragonVector()[0]) 
							&& ( (heroVector[1] + 1) == list.get(i).getDragonVector()[1]))
							
							|| (( (heroVector[0]) == list.get(i).getDragonVector()[0]) 
							&& ( (heroVector[1] - 1) == list.get(i).getDragonVector()[1]))){
						
						
						/*se se verificar a condi��o no mapa mete " " na posi��o do drag�o 'i'
						 * e remove esse drag�o da lista (supostamente)*/
						mapaVector[list.get(i).getDragonVector()[0]][list.get(i).getDragonVector()[1]] = Variables.PIN_HALL ;
						list.remove(i);
					}
				}
								
				}	
			
			}
			mapaVector[heroVector[0]][heroVector[1]] = heroState;
		}
	
		mapaObject.setMapa(mapaVector);
		
	}
	public int getWin() {
		return win;
	}
	public int[] getHeroVector() {
		return heroVector;
	}
	public void setHeroVector(int[] heroVector) {
		this.heroVector = heroVector;
	}
	public boolean isArmed() {
		return armed;
	}
	public void setArmed(boolean armed) {
		this.armed = armed;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int isFoundIt() {
		return foundIt;
	}
	public void setFoundIt(int foundIt) {
		this.foundIt=this.foundIt-foundIt;
	}

}