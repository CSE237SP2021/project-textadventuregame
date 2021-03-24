package TextGame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Game {

	JFrame gameWindow;
	Container con;
	
	
	public Game() {
		
		gameWindow = new JFrame();
		gameWindow.setSize(800, 600);
		//be able to close the window
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.getContentPane().setBackground(Color.black);
		//set default layout
		gameWindow.setLayout(null);
		//make window appear on the screen
		gameWindow.setVisible(true);
		con = gameWindow.getContentPane();
	}
	
	public static void main(String[] args) {
	
		new Game();
	}

}
