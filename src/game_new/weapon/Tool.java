package game_new.weapon;

import game_new.character.Guard;
import game_new.character.Monster;
import game_new.character.Player;

public interface Tool {
	void visit(Player p);
	void visit(Monster monster);
	void visit(Guard guard);
}
