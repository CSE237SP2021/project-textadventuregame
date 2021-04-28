package tools;

import character.Guard;
import character.Monster;
import character.Player;

public class Poisson implements Tool {

	private int value = 20;
	
	@Override
	public void visit(Player p) {
		// TODO Auto-generated method stub
		p.setHitPoint(p.getHitPoint() - 10);
	}

	@Override
	public void visit(Monster monster) {
		// TODO Auto-generated method stub
		monster.setHitPoint(monster.getHitPoint() - 100);	
	}

	@Override
	public void visit(Guard guard) {
		// TODO Auto-generated method stub
		guard.setHitPoint(guard.getHitPoint() + 10);	
	}

	@Override
	public int getValue() {
		return value;
	}
	
	

}
