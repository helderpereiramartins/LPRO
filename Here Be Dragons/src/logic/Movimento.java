package logic;

public class Movimento {
	
	Mapa mapaObject = Mapa.getInstance();
	
	
	public void movement(int l, int c) {
		mapaObject.getHeroObject().MoveHeroi(l, c);
		Hero mapaHero = mapaObject.getHeroObject();
	
		if(!mapaHero.isFoundIt() && mapaHero.getWin() !=-1)
			mapaObject.getDragonObject().MoveDragao();
		
	}
}
