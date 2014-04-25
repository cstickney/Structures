package Main;


public class Character{
	public int HP;
	public String name;
	public Move[] moves = new Move[30];
	public int MaxHP;
	public int movesno;
	
	
	public Character() {
		name = "uninitialized";		
	}
}