package logic;

public class movimento {
	
	
	public void movement(int l, int c) {
		
		mapa.heroObject.MoveHeroi(l, c);
	
		if(hero.found_it!=1 && hero.win!=-1)
		mapa.dragonObject.MoveDragao();
		
	}
}
