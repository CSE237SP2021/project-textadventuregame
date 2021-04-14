package tools;

import character.Guard;
import character.Monster;
import character.Player;

public class Armor implements Tool {
	
	private String name;
	private int defense;
	
	Armor(String name, int defense){
		this.setName(name);
		this.setDefense(defense);
	}

	Armor(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
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
