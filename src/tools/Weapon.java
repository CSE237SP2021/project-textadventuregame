package tools;

import character.Guard;
import character.Monster;
import character.Player;

public class Weapon implements Tool {
	
	private String name;
	private int damage;

	Weapon(String name, int damage){
		this.setName(name);
		this.damage = damage;
	}
	
	Weapon(){}

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

	@Override
	public void visit(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Monster monster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Guard guard) {
		// TODO Auto-generated method stub
		
	}
}
