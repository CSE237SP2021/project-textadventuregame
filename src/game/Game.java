package game;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextArea;

import util.ChoiceHandler;
import util.VisibilityManager;

public class Game {
	
	private ChoiceHandler cHandler;
	private UI ui;
	private VisibilityManager vm;
	private Story story;
	
	private String nextPosition1;
	private String nextPosition2;
	private String nextPosition3;
	private String nextPosition4;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.execute();
	}
	
	public Game() {
		
		ui = new UI();
		vm = new VisibilityManager(ui);
		story = new Story(this, ui, vm);
		cHandler = new ChoiceHandler(this, vm, story);
	}
	
	public void execute() {
		System.setProperty("java.awt.headless", "true"); //Disables headless
		//make all UI part
		ui.createUI(cHandler);
//		if(ui.startButton1.isSelected()) {
//			story.easySetup();
//		}
//		if(ui.startButton2.isSelected) {
//			story.hardSetup();
//		}
		//only show title first. So we start with start button in the user interface
		vm.showTitleScreen();
	}

	public String getNextPosition1() {
		return nextPosition1;
	}

	public void setNextPosition1(String nextPosition1) {
		this.nextPosition1 = nextPosition1;
	}

	public String getNextPosition2() {
		return nextPosition2;
	}

	public void setNextPosition2(String nextPosition2) {
		this.nextPosition2 = nextPosition2;
	}

	public String getNextPosition3() {
		return nextPosition3;
	}

	public void setNextPosition3(String nextPosition3) {
		this.nextPosition3 = nextPosition3;
	}

	public String getNextPosition4() {
		return nextPosition4;
	}

	public void setNextPosition4(String nextPosition4) {
		this.nextPosition4 = nextPosition4;
	}
}



