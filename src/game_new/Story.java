package game_new;

import game_new.extendClass.VisibilityManager;
import game_new.monster.SuperMonster;
import game_new.weapon.Weapon_Knife;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster;
	int silverRing;
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
	 	player.hp = 10;
		ui.hpLabelNumber.setText("" + player.hp);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		silverRing = 0;
		System.out.println("asd;lkf");
		
	}
	
	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
		case "townGate": townGate(); break;
		case "talkGuard": talkGuard(); break;
		case "attackGuard": break;
		case "crossRoad": break;
		case "monsterAttack": break;
		case "win": break;
		case "lose": break;
		
		}
	}
	
	public void townGate() {
		ui.mainTextArea.setText("You are at the gate of the Town. You see a guard.");
		ui.choice1.setText("talk to guard");
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		game.nextPosition1 = "talkGuard";
		game.nextPosition2 = "attackGuard";
		game.nextPosition3 = "crossRoad";
		game.nextPosition4 = "";		
	}
	
	public void talkGuard() {
		if (silverRing == 0) {
			ui.mainTextArea.setText("to be done");
			ui.choice1.setText("");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";	
		}
	}
	
	
}
