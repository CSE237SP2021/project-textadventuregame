package TextGame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {

	JFrame gameWindow;
	Container con;
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel;
	JButton startButton;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	
	public Game() {
		
		/*****************************************************
		********* create game window *************************
		******************************************************/			
		gameWindow = new JFrame();
		gameWindow.setSize(800, 600);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //be able to close the window
		gameWindow.getContentPane().setBackground(Color.black);		
		gameWindow.setLayout(null); //set default layout
		gameWindow.setVisible(true); //make window appear on the screen
		con = gameWindow.getContentPane();
	
		/****************************************************
		 ******** create game title panel with label ********
		 *****************************************************/		
		// create panel for title
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.pink);
		// create label on panel
		titleNameLabel = new JLabel("Adventure");
		titleNameLabel.setForeground(Color.white); // text color
		titleNameLabel.setFont(titleFont); // set text font
		// add the label and panel to the game board
		titleNamePanel.add(titleNameLabel); // add the label
		con.add(titleNamePanel);

		/*****************************************************
		********* create game button panel with label ********
		******************************************************/	
		// create button panel
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.blue);
		// create button
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		// add button and panel to game board
		startButtonPanel.add(startButton);
		con.add(startButtonPanel);
		
	} 
	
	public static void main(String[] args) {
		
		// if the title does not show up, just resize the window and it will show up.
		// no idea why it happens and why it could be solved by resizing the window.
		
		new Game();
	}
 
}
