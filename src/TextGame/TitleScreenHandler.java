package TextGame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TitleScreenHandler implements ActionListener {
	
	private Game game;
	
	public TitleScreenHandler(Game ourGame) {
        this.game = ourGame;
   }
	
	public void createGameScreen() {
		
		//This screen will show up once we start the game.
		//The title and startButton will disappear.
		game.gameWindow.getContentPane().setBackground(Color.gray);
		game.titleNamePanel.setVisible(false);
		game.startButtonPanel.setVisible(false);
		
		//Set main Text Panel
		game.mainTextPanel = new JPanel();
		game.mainTextPanel.setBounds(100, 100, 600, 250);
		game.mainTextPanel.setBackground(Color.gray);
		game.con.add(game.mainTextPanel);
		
		//Set main Text Area, black
		game.mainTextArea = new JTextArea("Main Text Area.");
		game.mainTextArea.setBounds(100, 100, 600, 250);
		game.mainTextArea.setBackground(Color.DARK_GRAY);
		game.mainTextArea.setForeground(Color.white);
		game.mainTextArea.setFont(game.normalFont);
		game.mainTextArea.setLineWrap(true);
		game.mainTextPanel.add(game.mainTextArea);
		
		//Add panel for option buttons
		game.optionButtonPanel = new JPanel();
		game.optionButtonPanel.setBounds(100, 350, 600, 150);
		game.optionButtonPanel.setBackground(Color.DARK_GRAY);
		//Set Buttons Layout
		game.optionButtonPanel.setLayout(new GridLayout(4, 1));
		game.con.add(game.optionButtonPanel);
		
		//Add Option Buttons
		game.option1 = new JButton("Option 1");
		game.option1.setBackground(Color.black);
		game.option1.setForeground(Color.white);
		game.option1.setFont(game.normalFont);
		game.optionButtonPanel.add(game.option1);
		game.option2 = new JButton("Option 2");
		game.option2.setBackground(Color.black);
		game.option2.setForeground(Color.white);
		game.option2.setFont(game.normalFont);
		game.optionButtonPanel.add(game.option2);
		game.option3 = new JButton("Option 3");
		game.option3.setBackground(Color.black);
		game.option3.setForeground(Color.white);
		game.option3.setFont(game.normalFont);
		game.optionButtonPanel.add(game.option3);
		game.option4 = new JButton("Option 4");
		game.option4.setBackground(Color.black);
		game.option4.setForeground(Color.white);
		game.option4.setFont(game.normalFont);
		game.optionButtonPanel.add(game.option4);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		createGameScreen();
	}	
}