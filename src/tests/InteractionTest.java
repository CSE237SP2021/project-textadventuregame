package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import character.Monster;
import character.Player;
import tools.Armor;
import tools.Pill;
import tools.Poisson;
import tools.Tool;

class InteractionTest {

	@Test
	void eatPillTest() {
		Player p = Player.getInstance();
		p.setName("WashU");
		p.setHitPoint(10);
		p.setAttack(20);
		p.setDefense(30);
		
		Tool pill = new Pill();
		p.accept(pill);
		assertTrue("The functionality of pill is wrong", p.getHitPoint() == 70);
		assertTrue("The functionality of pill is wrong", p.getAttack() == 30);
	}
	
	
	@Test
	void wearArmorTest() {
		Player p = Player.getInstance();
		p.setName("WashU");
		p.setHitPoint(10);
		p.setAttack(20);
		p.setDefense(30);
		
		Armor armor = new Armor("T-shirt", 10);
		p.accept(armor);
		
		assertTrue("The functionality of armor is wrong", p.getDefense() == 40);
	}
	
	@Test
	void poissonTest() {
		Monster enemy = new Monster("Jiaqi", 101, 10, 10);
		
		Tool poisson = new Poisson();
		enemy.accept(poisson);
		
		assertTrue("The functionality of poisson is wrong", enemy.getHitPoint() == 1);
	}
}
