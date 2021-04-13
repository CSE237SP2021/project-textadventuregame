package game_new.weapon;

public class Weapon {
	
	private String name;
	private int damage;

	Weapon(String name, int damage){
		this.setName(name);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}