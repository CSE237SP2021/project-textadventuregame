package tools;

import character.Guard;
import character.Monster;
import character.Player;

public class Pill implements Tool{

	private int value = 10;
	
	@Override
	public void visit(Player p) {
		p.setHitPoint(p.getHitPoint() + 60);
		p.setAttack(p.getAttack() + 10);
	}

	@Override
	public void visit(Monster monster) {
	
	}

	@Override
	public void visit(Guard guard) {

	}

	@Override
	public int getValue() {
		return value;
	}

}
