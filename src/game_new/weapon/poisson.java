package game_new.weapon;

import game_new.character.Monster;
import game_new.character.Player;

public class poisson implements Tool {

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
	
	

}
