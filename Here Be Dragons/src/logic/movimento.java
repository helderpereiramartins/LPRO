package logic;

public class movimento {
	
	dragon drogoObject = new dragon();
	hero heroObject = new hero();
	public void movement(int l, int c) {
		
		heroObject.MoveHeroi(l, c);
	
		
		dragon.MoveDragao();
		
	}
}
