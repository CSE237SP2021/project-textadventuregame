package TextGame;

public class Enemy extends Role{

	private String name;
	
	public Enemy(String name, int hp, int atk, int def) {
		super(hp, atk, def);
		this.name = name;
	}
	
	public Enemy(String name) {
		this.name = name;
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
