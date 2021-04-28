package tools;

import character.Guard;
import character.Monster;
import character.Player;

public interface Tool {
	void visit(Player p);
	void visit(Monster monster);
	void visit(Guard guard);
	public int getValue();
}
