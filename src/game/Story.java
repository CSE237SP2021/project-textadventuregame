package game;

import character.Guard;
import character.Monster;
import character.Monster_Djinn;
import character.Player;
import character.Role;
import tools.Weapon_Knife;
import util.VisibilityManager;

public class Story {

	private Game game;
	private UI ui;
	private VisibilityManager vm;
	private Player player;
	private Guard guard;
	private Monster_Djinn djinn;
	
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
		
		guard = new Guard("Peppa", 20, 10, 0);
		guard.setGold(10);
		
		djinn = new Monster_Djinn("Kela", 45, 15, 5);
		djinn.setGold(25);
	}
	
	public void setOptions(String option1, String option2, String option3, String option4) {
		ui.choice1.setText(option1);
		ui.choice2.setText(option2);
		ui.choice3.setText(option3);
		ui.choice4.setText(option4);
		if (option4 == "") {
			ui.choice4.setText("Exit");
		}
	}
	
	public void setNextSteps(String option1, String option2, String option3, String option4) {
		game.setNextPosition1(option1);
		game.setNextPosition2(option2);
		game.setNextPosition3(option3);
		game.setNextPosition4(option4);
		if (option4 == "") {
			game.setNextPosition4("exit");
		}
			
	}
	
	public void interaction(Role role) {
		System.out.println("begin interaction");
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
			case "goToFerry":
				goToFerry();
				break;
			case "crossBridge": 
				break;
			case "fightDjinnWithSword":
				fightDjinnWithSword();
				break;
			case "fightDjinnWithBow":
				fightDjinnWithBow();
				break;
			case "recoverHealth":
				recoverHealth();
				break;
			case "giveUpAllMoney":
				giveUpAllMoney();
				break;
			case "sellBoat": 
				sellBoat();
				break;
			case "theEnd":
				theEnd();
				break;
			case "takeBoat":
				takeBoat();
				break;
			case "swim":
				swim();
				break;
			case "rowAcrossRiver":
				rowAcrossRiver();
				break;
			case "exit":
				System.exit(0);
		}
	}
	
	public void mysteryGate() {
		ui.mainTextArea.setText("You are at the gate of the mystery maze. You see a guard."
				+ "  Even though it is cute, you have to be careful!");

		setOptions("Talk to the guard.", "Attack the guard.", "", "");
		setNextSteps("talkToGuard", "attackGuardOnce", "", "");	
	}
	
	public void talkToGuard() {
		if (player.getGold() == 0) {
			ui.mainTextArea.setText("Guard: Good Morning! How are you?");
			setOptions("Back", "", "", "");
			setNextSteps("mysteryGate", "", "", "");	
		}
	}
	
	public void attackGaurdOnce() {

		System.out.println(this.guard.getHitPoint());

		interaction(guard);
		if(guard.getHitPoint() < 0) {
			player.setGold(guard.getGold());
			ui.moneyLabelNumber.setText("" + player.getGold());
			ui.mainTextArea.setText("The guard is dead. You got 10 pieces of gold from his pocket.");
			
			setOptions("Check his room for supplies.", "Go to the ferry.", "", "");
			setNextSteps("recoverHealth", "goToFerry", "", "Exit");
			
		}else {
			ui.mainTextArea.setText("The guard is still alive.");		
			setOptions("Continue the attack", "Back", "", "");
			setNextSteps("attackGuardOnce", "mysteryGate", "", "");
		}
	}
	
	public void recoverHealth() {
		player.setHitPoint(player.getHitPoint() + 10); 
		ui.hpLabelNumber.setText(""+player.getHitPoint());
		ui.mainTextArea.setText("You find a medical kit. You got 10 extra HP! You also pick up a sword and a crossbow.");
		player.setCurrentWeapon(new Weapon_Knife("Sword", 10));
		ui.weaponLabelName.setText(player.getCurrentWeapon().getName());

		setOptions("Go to the ferry.", "", "", "");
		setNextSteps("goToFerry", "", "", "");
	}
	
	public void goToFerry() {
		ui.mainTextArea.setText("You are now at the ferry. You want to cross the river.");
		setOptions("Swim.", "Take the boat (Pay 5 Gold).", "", "");
		setNextSteps("swim", "takeBoat", "", "");
	}


	public void swim() {
		ui.mainTextArea.setText("You jumped into the river and found that the water is freezing. After swiming for 2 minutes, you feel that you cannot hold any longer.");
		setOptions("Swim back to the ferry.", "", "", "");
		setNextSteps("goToFerry", "", "", "");
	}
	
	public void takeBoat() {
		player.setGold(player.getGold() - 5);
		ui.moneyLabelNumber.setText("" + player.getGold());
		ui.mainTextArea.setText("After getting your payment, the boatman invites you onto his boat and rows to the middle of the river. Suddenly, he reveals his true identity. He turns out to be a powerful djinn. He pulls out a sword at you and said,\"Give me all your money or die!\"");
		setOptions("Give him all your gold.", "Fight him!", "", "");
		setNextSteps("giveUpAllMoney", "fightDjinnWithSword", "", "");
	}

	public void giveUpAllMoney() {
		player.setGold(0);
		ui.moneyLabelNumber.setText("" + 0);
		ui.mainTextArea.setText("You gave up all of your gold to the Djinn. Yet he sneered and said,\"You don't actually think that gold will save your life, do you?\" He came towards you.");
		setOptions("Fight him!", "", "", "");
		setNextSteps("fightDjinnWithSword", "", "", "");
	}
	
	public void fightDjinnWithSword() {
		player.setCurrentWeapon(new Weapon_Knife("Sword", 10));
		ui.weaponLabelName.setText(player.getCurrentWeapon().getName());
		interaction(djinn);
		
		if(player.getHitPoint() < 0) {
			ui.mainTextArea.setText("The djinn wins. Game Over!");
			
			setOptions("", "", "", "");
			setNextSteps("", "", "", "");
		}
		else {
		
			if(djinn.getHitPoint() < 0) {
				player.setGold(djinn.getGold());
				ui.moneyLabelNumber.setText("" + player.getGold());
				ui.mainTextArea.setText("The djinn is dead. You got 15 pieces of gold from his pocket.");
				
				setOptions("Row the boat across the river", "", "", "");
				setNextSteps("rowAcrossRiver", "", "", "");
				
			}else {
				ui.mainTextArea.setText("The djinn is still alive.");		
				setOptions("Use sword", "Use crossbow", "", "");
				setNextSteps("fightDjinnWithSword", "fightDjinnWithBow", "", "");
			}
		}
	}
	
	public void fightDjinnWithBow() {
		player.setCurrentWeapon(new Weapon_Knife("Crossbow", 20));
		ui.weaponLabelName.setText(player.getCurrentWeapon().getName());
		interaction(djinn);
		
		if(player.getHitPoint() < 0) {
			ui.mainTextArea.setText("The djinn wins. Game Over!");
			
			setOptions("", "", "", "");
			setNextSteps("", "", "", "");
		}
		else {
		
			if(djinn.getHitPoint() < 0) {
				player.setGold(djinn.getGold());
				ui.moneyLabelNumber.setText("" + player.getGold());
				ui.mainTextArea.setText("The djinn is dead. You got 15 pieces of gold from his pocket.");
				
				setOptions("Row the boat across the river", "", "", "");
				setNextSteps("rowAcrossRiver", "", "", "");
				
			}else {
				ui.mainTextArea.setText("The djinn is still alive.");		
				setOptions("Use sword", "Use crossbow", "", "");
				setNextSteps("fightDjinnWithSword", "fightDjinnWithBow", "", "");
			}
		}
	}
	
	public void rowAcrossRiver() {
		ui.mainTextArea.setText("The water is turbid, and you are new to boating. Nevertheless, you make it across the river.");		
		setOptions("Sell the boat.", "Hide the boat and proceed.", "", "");
		setNextSteps("sellBoat", "theEnd", "", "");
	}
	
	public void sellBoat() {
		player.setGold(player.getGold() + 10);
		ui.moneyLabelNumber.setText("" + player.getGold());
		ui.mainTextArea.setText("You earn 10 gold from selling the boat!");
		setOptions("Proceed.", "", "", "");
		setNextSteps("theEnd", "", "", "");
	}

	public void theEnd() {
		ui.mainTextArea.setText("Congratulations! You have finished Part I of the adventure! The rest of the game will be available very soon! Thank you for your support!");
		setOptions("", "", "", "");
		setNextSteps("", "", "", "");
	}
}
