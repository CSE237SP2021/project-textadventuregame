package TextGame;

public class poisson implements Tool{

	@Override
	public void visit(Player p) {
		p.setHitPoint(p.getHitPoint() - 10);
		
	}

	@Override
	public void visit(Enemy enemy) {
		enemy.setHitPoint(enemy.getHitPoint() - 100);	
	}
	
}
