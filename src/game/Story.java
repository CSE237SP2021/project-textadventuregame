package game;

import character.Guard;
import character.Monster;
import character.Player;
import character.Role;
import tools.Weapon_Knife;
import util.VisibilityManager;

public class Story {

	private Game game;
	private UI ui;
	private VisibilityManager vm;
	private Player player;
	private Monster monster;
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void Setup(int health, String WeaponName, int weaponDamage) {
		
		player = Player.getInstance();
	 	player.setHitPoint(health);
	 	player.setAttack(10);
	 	player.setDefense(2);
	 	player.setGold(0);
		ui.hpLabelNumber.setText("" + player.getHitPoint());
		ui.moneyLabelNumber.setText("" + player.getGold());
		player.setCurrentWeapon(new Weapon_Knife(WeaponName, weaponDamage));
		ui.weaponLabelName.setText(player.getCurrentWeapon().getName());
	}
	
	public void interaction(Role role) {
		player.battel(role);
		ui.hpLabelNumber.setText("" + player.getHitPoint());
		ui.weaponLabelName.setText(player.getCurrentWeapon().getName());
	}
	

	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
			case "mysteryGate": 
				mysteryGate(); 
				break;
			case "talkToGuard":
				talkToGuard(); 
				break;
			case "attackGuardOnce": 
				attackGaurdOnce();
				break;
			case "crossRoad": 
				break;
			case "monsterAttack":
				break;
			case "win": 
				break;
			case "lose": 
				break;
		}
	}
	
	public void mysteryGate() {
		ui.mainTextArea.setText("You are at the gate of the mystery maze. You see a guard."
				+ "  Even though it is cute, you have to be careful!");
		ui.choice1.setText("talk to guard");
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		game.setNextPosition1("talkToGuard");
		game.setNextPosition2("attackGuardOnce");
		game.setNextPosition3("crossRoad");
		game.setNextPosition4("attackGuard");		
	}
	
	public void talkToGuard() {
		if (player.getGold() == 0) {
			ui.mainTextArea.setText("to be done");
			ui.choice1.setText("");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.setNextPosition1("");
			game.setNextPosition2("");
			game.setNextPosition3("");
			game.setNextPosition4("");	
		}
	}
	
	public void attackGaurdOnce() {
		Guard guard = new Guard("Peppa", 10, 10, 0);
		guard.setGold(1);
		interaction(guard);
		if(guard.getHitPoint() < 0) {
			player.setGold(guard.getGold());
			ui.moneyLabelNumber.setText("" + player.getGold());
			ui.mainTextArea.setText("The guard is dead");
			ui.choice1.setText("crossRoad");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.setNextPosition1("");
			game.setNextPosition2("loot");
			game.setNextPosition3("");
			game.setNextPosition4("");
		}else {
			ui.mainTextArea.setText("The guard is still alive");
			ui.choice1.setText("give him candy");
			ui.choice2.setText("run");
			ui.choice3.setText("continue attack");
			ui.choice4.setText("");
		}
	}
	
}
