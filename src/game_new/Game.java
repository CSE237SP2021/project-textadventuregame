package game_new;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextArea;

import game_new.extendClass.ChoiceHandler;
import game_new.extendClass.VisibilityManager;

public class Game {
	
	ChoiceHandler cHandler = new ChoiceHandler(this);
	UI ui = new UI();
	public VisibilityManager vm = new VisibilityManager(ui);
	public Story story = new Story(this, ui, vm);
	
	public String nextPosition1;
	public String nextPosition2;
	public String nextPosition3;
	public String nextPosition4;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		ui.createUI(cHandler);
		story.defaultSetup();
		vm.showTitleScreen();
	}
	
}



