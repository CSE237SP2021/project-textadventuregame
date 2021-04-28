package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import character.Monster;
import character.Player;

class PlayerTest {

	@Test
	void testPlayerAttributes() {
		Player p = Player.getInstance();
		p.setName("WashU");
		p.setHitPoint(10);
		p.setAttack(20);
		p.setDefense(30);
		
		assertTrue("The name of player is wrong", p.getName() == "WashU");
		assertTrue("The hp of player is wrong", p.getHitPoint() == 10);
		assertTrue("The attack of player is wrong", p.getAttack() == 20);
		assertTrue("The defense of player is wrong", p.getDefense() == 30);
	}
	
	@Test
	void testBattel() {
		Player p = Player.getInstance();
		p.setName("WashU");
		p.setHitPoint(50);
		p.setAttack(20);
		p.setDefense(10);
		
		Monster enemy = new Monster("Jiaqi", 100, 20, 5);
		p.battel(enemy);
		assertTrue("The hp of player is wrong", p.getHitPoint() == 40);
		assertTrue("The hp of enemy is wrong", enemy.getHitPoint() == 85);
	}
}
