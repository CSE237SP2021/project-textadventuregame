package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tools.Store;
import tools.Tool;

class StoreTest {

	@Test
	void createPillTest() {
		Tool t = Store.getTool("Pill");
		String s = t.getClass().getName();
		assertTrue("The store creates wrong thing, not pill", s == "tools.Pill");
	}
	
	@Test
	void createWeaponTest() {
		Tool t = Store.getTool("Weapon");
		String s = t.getClass().getName();
		assertTrue("The store creates wrong thing, not weapon", s == "tools.Weapon");
	}
	
	@Test
	void createPoissonTest() {
		Tool t = Store.getTool("poisson");
		String s = t.getClass().getName();
		assertTrue("The store creates wrong thing, not pill", s == "tools.Poisson");
	}
	
	@Test
	void createArmorTest() {
		Tool t = Store.getTool("armor");
		String s = t.getClass().getName();
		assertTrue("The store creates wrong thing, not pill", s == "tools.Armor");
	}
	
	@Test
	void createkeyTest() {
		Tool t = Store.getTool("Key");
		String s = t.getClass().getName();
		assertTrue("The store creates wrong thing, not pill", s == "tools.Key");
	}
}
