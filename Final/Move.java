package Main;


public class Move{
	public String name;
	public int damage;
	public int userMovement;
	public int enemyMovement;
	public int superGainUse;
	public int superGainHit;
	
	public boolean hitsGround;
	public boolean isAir;
	public boolean hitsAir;
	public boolean armored;
	public boolean armorBreak;
	public boolean isProjectile;
	public boolean projectileImmune;
	public boolean isThrow;
	public int startup;
	public int range;
	
	public Move(){
		name = "null";
		damage = 0;
		userMovement = 0;
		enemyMovement = 0;
		superGainUse = 0;
		superGainHit = 0;
		hitsGround = false;
		isAir = false;
		hitsAir = false;
		armored = false;
		armorBreak = false;
		isProjectile = false;
		projectileImmune = false;
		isThrow = false;
		startup = 0;
		range = 0;
		
	}
	
	
	
	
	
	
	
}