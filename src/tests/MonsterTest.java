package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import character.Monster;

class MonsterTest {

	@Test
	void testEnemyAttributes() {
		Monster enemy = new Monster("Jiaqi", 10, 10, 10);
		Monster enemy2 = new Monster("Fake");
		enemy2.setHitPoint(20);
		enemy2.setAttack(20);
		enemy2.setDefense(20);
		//check first player
		assertTrue("The name of enemy is wrong", enemy.getName() == "Jiaqi");
		assertTrue("The hp of enemy is wrong", enemy.getHitPoint() == 10);
		assertTrue("The attack of enemy is wrong", enemy.getAttack() == 10);
		assertTrue("The defense of enemy is wrong", enemy.getDefense() == 10);
		//check second player
		assertTrue("The hp of enemy is wrong", enemy2.getHitPoint() == 20);
		assertTrue("The attack of enemy is wrong", enemy2.getAttack() == 20);
		assertTrue("The defense of enemy is wrong", enemy2.getDefense() == 20);
	}

}
