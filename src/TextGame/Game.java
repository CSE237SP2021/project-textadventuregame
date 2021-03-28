package TextGame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame gameWindow;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, optionButtonPanel;
	JLabel titleNameLabel;
	JButton startButton, option1, option2, option3, option4;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JTextArea mainTextArea;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	
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
		// Add EventListener to Button
		startButton.addActionListener(tsHandler);
		
		// add button and panel to game board
		startButtonPanel.add(startButton);
		con.add(startButtonPanel);
		
	} 
	
	public void createGameScreen() {
		
		//This screen will show up once we start the game.
		//The title and startButton will disappear.
		gameWindow.getContentPane().setBackground(Color.gray);
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		//Set main Text Panel
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.gray);
		con.add(mainTextPanel);
		
		//Set main Text Area, black
		mainTextArea = new JTextArea("Main Text Area.");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.DARK_GRAY);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		//Add panel for option buttons
		optionButtonPanel = new JPanel();
		optionButtonPanel.setBounds(100, 350, 600, 150);
		optionButtonPanel.setBackground(Color.DARK_GRAY);
		//Set Buttons Layout
		optionButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(optionButtonPanel);
		
		//Add Option Buttons
		option1 = new JButton("Option 1");
		option1.setBackground(Color.black);
		option1.setForeground(Color.white);
		option1.setFont(normalFont);
		optionButtonPanel.add(option1);
		option2 = new JButton("Option 2");
		option2.setBackground(Color.black);
		option2.setForeground(Color.white);
		option2.setFont(normalFont);
		optionButtonPanel.add(option2);
		option3 = new JButton("Option 3");
		option3.setBackground(Color.black);
		option3.setForeground(Color.white);
		option3.setFont(normalFont);
		optionButtonPanel.add(option3);
		option4 = new JButton("Option 4");
		option4.setBackground(Color.black);
		option4.setForeground(Color.white);
		option4.setFont(normalFont);
		optionButtonPanel.add(option4);
		
		
	}
	
	// Title Screen Handler
	public class TitleScreenHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			createGameScreen();
		}	
	}
	
	public static void main(String[] args) {
		
		// if the title does not show up, just resize the window and it will show up.
		// I have no idea why it happens and why it could be solved by resizing the window.
		
		new Game();
	}
 
}
