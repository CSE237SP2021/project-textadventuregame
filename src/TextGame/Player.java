package TextGame;

public class Player extends Role{

	//Singleton pattern, we only need one player in the game
	private static Player instance;
	private String name;
	
	private Player() {}

	public static Player getInstance() {
		if(instance == null) {
			instance = new Player();
		}
		return instance;
	}
	
	public void battel(Enemy enemy) {
		enemy.setHitPoint(enemy.getHitPoint() - this.getAttack() + enemy.getDefense());
		this.setHitPoint(this.getHitPoint() - enemy.getAttack() + this.getDefense());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void accept(Tool visitor) {
		visitor.visit(this);
	}	
	

}
