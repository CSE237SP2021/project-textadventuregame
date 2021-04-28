package tools;

import character.Guard;
import character.Monster;
import character.Player;

public class Key implements Tool{

	private int value = 5;
	@Override
	public void visit(Player p) {
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
