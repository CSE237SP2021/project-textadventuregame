package game_new.character;

import game_new.weapon.Tool;
import game_new.weapon.Weapon;

public class Player extends Role{
	
	//Singleton pattern, we only need one player in the game
	private static Player instance;
	private String name;
	private Weapon currentWeapon = null;
	
	private Player() {}

	public static Player getInstance() {
		if(instance == null) {
			instance = new Player();
		}
		return instance;
	}
	
	public void battel(Monster enemy) {
		enemy.setHitPoint(enemy.getHitPoint() - this.getAttack() + enemy.getDefense());
		this.setHitPoint(this.getHitPoint() - enemy.getAttack() + this.getDefense());
	}
	
	@Override
	public void accept(Tool visitor) {
		visitor.visit(this);
	}

	public int getAttack() {
		if(currentWeapon == null) {
			return super.getAttack();
		}else {
			return super.getAttack() + currentWeapon.getDamage();
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}	
}
