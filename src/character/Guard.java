package character;

import tools.Tool;

public class Guard extends Role{
	
	private String name;
	
	public Guard(String name, int hp, int atk, int def) {
		super(hp, atk, def);
		this.name = name;
	}
	
	public Guard(String name) {
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
