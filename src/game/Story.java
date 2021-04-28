package game;

import java.util.ArrayList;

import character.Guard;
import character.Monster;
import character.Monster_Djinn;
import character.Player;
import character.Role;
import tools.Store;
import tools.Tool;
import tools.Weapon_Knife;
import util.VisibilityManager;

public class Story {

	private Game game;
	private UI ui;
	private VisibilityManager vm;
	private Player player;
	private Guard guard;
	private Monster_Djinn djinn;
	private Monster boss;
	
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
		
		boss = new Monster("bee", 100, 30, 25);
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
			case "store":
				store();
				break;
			case "buy":
				buy();
				break;
			case "sell":
				sell();
				break;
			case "buy1":
				buy1();
				break;
			case "buy2":
				buy2();
				break;
			case "buy3":
				buy3();
				break;
			case "sell1":
				sell1();
				break;
			case "sell2":
				sell2();
				break;
			case "meetBoss":
				meetBoss();
				break;
			case "fightBoss":
				fightBoss();
				break;
			case "poissonBoss":
				poissonBoss();
				break;
			case "eatPill":
				eatPill();
				break;
			case "vault":
				vault();
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
		setNextSteps("sellBoat", "store", "", "");
	}
	
	public void sellBoat() {
		player.setGold(player.getGold() + 10);
		ui.moneyLabelNumber.setText("" + player.getGold());
		ui.mainTextArea.setText("You earn 10 gold from selling the boat!");
		setOptions("Proceed.", "", "", "");
		setNextSteps("store", "", "", "");
	}

	public void store() {
		ui.mainTextArea.setText("There is a magic store in front of you, you might buy some useful tools to help you. Or you can sell something in your backpack");
		setOptions("buy! buy! buy!", "sell some items", "leave", "");
		setNextSteps("buy", "sell", "meetBoss", "");
	}
	
	public void buy() {
		ui.mainTextArea.setText("Please choose the item you would like to buy.");
		setOptions("PILL", "POISSON", "KEY", "back");
		setNextSteps("buy1", "buy2", "buy3", "store");	
	}
	
	public void buy1() {
		Tool tool = Store.getTool(ui.choice1.getText());
		buyHelper(tool);
	}
	
	public void buy2() {
		Tool tool = Store.getTool(ui.choice2.getText());
		buyHelper(tool);
	}
	
	public void buy3() {
		Tool tool = Store.getTool(ui.choice3.getText());
		buyHelper(tool);
	}
	
	private void buyHelper(Tool tool) {
		if(player.getGold() >= tool.getValue()) {
			ArrayList<Tool> backp = player.getBackpack();
			backp.add(tool);
			player.setGold(player.getGold() - tool.getValue());
			ui.moneyLabelNumber.setText("" + player.getGold());
			ui.mainTextArea.setText("Greate deal! Would you like buy more?");	
		}else {
			ui.mainTextArea.setText("You don't have enough money, you may go back and sell something first");	
		}
		setOptions("PILL", "POISSON", "KEY", "back");
		setNextSteps("buy1", "buy2", "buy3", "store");
	}
	
	@SuppressWarnings("unused")
	public void sell() {
		ui.mainTextArea.setText("Please choose the item you would like to sell.");
		int itemSize = player.getBackpack().size();
		if(itemSize != 0) {
			Tool tool1 = player.getBackpack().get((int) (Math.random() * itemSize));
			String item1 = tool1.getClass().getName();
			Tool tool2 = player.getBackpack().get((int) (Math.random() * itemSize));
			String item2 = tool2.getClass().getName();
			//System.out.println(Math.random() * itemSize);
			if(tool1 != null && tool2 != null) {
				setOptions(item1, item2, "refresh your backpack", "back");
				setNextSteps("sell1", "sell2", "sell", "store");
			}else{
				if(tool1 == null) {
					setOptions(item2, item2, "refresh your backpack", "back");
					setNextSteps("sell1", "sell2", "sell", "store");
				}
				if(tool2 == null) {
					setOptions(item1, item1, "refresh your backpack", "back");
					setNextSteps("sell1", "sell2", "sell", "store");
				}
			}
		}else {
			setOptions("Nothing to sell", "Nothing to sell", "refresh your backpack", "back");
			setNextSteps("", "", "sell", "store");
		}
	}
	
	public void sell1() {
		String s = ui.choice1.getText();
		sellHelper(s);
	}
	
	public void sell2() {
		String s = ui.choice2.getText();
		sellHelper(s);
	}
	
	private void sellHelper(String s) {
		for(Tool t : player.getBackpack()) {
			if(t.getClass().getName() == s) {
				player.getBackpack().remove(t);
				player.setGold(player.getGold() + t.getValue());
				ui.moneyLabelNumber.setText("" + player.getGold());
				ui.mainTextArea.setText("Great deal! Would you like sell more?");
				setOptions("sell more", "", "", "back");
				setNextSteps("sell", "", "", "store");
				return;
			}
		}
	}
	
	public void meetBoss() {
		ui.mainTextArea.setText("You find a giant gold vault but a scary boss get in your way. It looks like having high defense and hp. Be wise! Be wise! be wise!");
		setOptions("Attack the Boss!", "Give him a possion", "take the pill and fight", "back to store");
		setNextSteps("fightBoss", "poissonBoss", "eatPill", "store");
	}
	
	public void fightBoss() {
		interaction(boss);
		fightHelper();
	}
	
	public void poissonBoss() {
		for(Tool t: player.getBackpack()) {
			if(t.getClass().getName() == "tools.Poisson") {
				boss.accept(t);
				fightHelper();
				return;
			}
		}
		ui.mainTextArea.setText("you don't have poisson, you may buy one in the store");
		setOptions("fight the boss anyway", "take a pill and fight", "back to store", "");
		setNextSteps("fightBoss", "eatPill", "store", "");
	}
	
	public void eatPill() {
		for(Tool t: player.getBackpack()) {
			if(t.getClass().getName() == "tools.Pill") {
				player.accept(t);
				fightHelper();
				return;
			}
		}
		ui.mainTextArea.setText("you don't have a pill, you may buy one in the store");
		setOptions("fight the boss anyway", "use a poisson", "back to store", "");
		setNextSteps("fightBoss", "poissonBoss", "store", "");
	}
	
	private void fightHelper() {
		if(player.getHitPoint() <= 0) {
			ui.mainTextArea.setText("He is so strong, now you find out if you attack he, his hp will be " + boss.getHitPoint() + " but his attack is "+
		                        boss.getAttack() + " and his defense is "+ boss.getDefense() + " you will be be killed anyway! stop attack and think some strategies");
			player.setHitPoint(player.getHitPoint() + boss.getAttack() - player.getDefense());
			ui.hpLabelNumber.setText("" + player.getHitPoint());
			setOptions("take the pill", "Give him a possion", "back to store", "");
			setNextSteps("eatPill", "poissonBoss", "store", "");
		}else{
			ui.hpLabelNumber.setText("" + player.getHitPoint());
			if(boss.getHitPoint() <= 0) {
				ui.mainTextArea.setText("The boss is dead. Now you can go to the vault");
				
				setOptions("Go to the splendid gold vault", "", "", "");
				setNextSteps("vault", "", "", "");
				
			}else {
				ui.mainTextArea.setText("The boss is still alive.");		
				setOptions("Attack the Boss", "Give hime a possion", "take the pill", "back to store");
				setNextSteps("fightBoss", "poissonBoss", "eatPill", "store");
			}
		}
	}
	
	public void vault() {
		ui.mainTextArea.setText("wow, there are so much gold in the vault!");
		setOptions("take all of them and leave", "", "", "");
		setNextSteps("theEnd", "", "", "");
	}
	
	public void theEnd() {
		ui.mainTextArea.setText("Congratulations! You have finished Part I of the adventure! The rest of the game will be available very soon! Thank you for your support!");
		setOptions("", "", "", "");
		setNextSteps("", "", "", "");
	}
}
