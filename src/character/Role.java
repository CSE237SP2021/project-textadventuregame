package character;

import tools.Tool;

public abstract class Role {
	private int hitPoint;
	private int attack;
	private int defense;
	private int gold;
	
	public Role() {}
	
	public Role(int hp, int atk, int def) {
		this.hitPoint = hp;
		this.attack = atk;
		this.defense = def;
	}
	
	public abstract void accept(Tool visitor);

	public int getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(int hitPoint) {
		this.hitPoint = hitPoint;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
}
