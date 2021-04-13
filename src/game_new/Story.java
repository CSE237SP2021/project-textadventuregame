package game_new;

import game_new.character.Monster;
import game_new.character.Player;

import game_new.extendClass.VisibilityManager;
import game_new.weapon.Weapon_Knife;

public class Story {

	private Game game;
	private UI ui;
	private VisibilityManager vm;
	private Player player;
	private Monster monster;
	private int silverRing;
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player = Player.getInstance();
	 	player.setHitPoint(10);
		ui.hpLabelNumber.setText("" + player.getHitPoint());
		
		player.setCurrentWeapon(new Weapon_Knife("Bowie", 5));
		ui.weaponLabelName.setText(player.getCurrentWeapon().getName());
		silverRing = 0;
		//System.out.println("asd;lkf");
		
	}
	
	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
			case "townGate": 
				townGate(); 
				break;
			case "talkGuard":
				talkGuard(); 
				break;
			case "attackGuard": 
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
	
	public void townGate() {
		ui.mainTextArea.setText("You are at the gate of the Town. You see a guard.");
		ui.choice1.setText("talk to guard");
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		game.setNextPosition1("talkGuard");
		game.setNextPosition2("attackGuard");
		game.setNextPosition3("crossRoad");
		game.setNextPosition4("");		
	}
	
	public void talkGuard() {
		if (silverRing == 0) {
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
	
	
}
