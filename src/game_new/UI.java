package game_new;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import game_new.extendClass.ChoiceHandler;

//import ChoiceHandler;

import java.awt.Font;

public class UI {
	
	JFrame window;
	public JPanel titleP = new JPanel();
	public JPanel startBtnP = new JPanel();
	public JPanel mainP = new JPanel();
	public JPanel choiceBtnP = new JPanel();
	public JPanel playerP = new JPanel();
	JPanel imageP = new JPanel();
	JLabel titleNameLabel = new JLabel("ADVENTURE"),
		   hpLabel = new JLabel("HP:"), hpLabelNumber = new JLabel(),
		   moneyLabel = new JLabel("Gold: "), moneyLabelNumber = new JLabel(),
		   weaponLabel = new JLabel("Weapon:"), weaponLabelName = new JLabel(),
		   imageLabel;
	JButton startButton1 = new JButton("Let's go(easy mode)"),
			startButton2 = new JButton("try it!(hard mode)"),
			choice1 = new JButton(), choice2 = new JButton(),
			choice3 = new JButton(), choice4 = new JButton();
	JTextArea mainTextArea = new JTextArea("This is the main text are.");
	Font big = new Font("Times New Roman", Font.PLAIN, 72);
	Font small = new Font("Times New Roman", Font.PLAIN, 24);
	
	public void createUI(ChoiceHandler cHandler) {
		
		setupWindow();
		
		//set up titlePanel
		setupPanel(titleP, new int[] {100, 100, 600, 150});
		setupLabel(titleNameLabel, big, titleP);
		setupPanel(startBtnP, new int[] {100, 350, 600, 200});
		setupButton(startButton1, cHandler, "start1", startBtnP);		
		setupButton(startButton2, cHandler, "start2", startBtnP);
		
		//set up mainPanel
		setupPanel(mainP, new int[] {100, 100, 600, 250});
		setupMainTextArea();
		
		//set up choicePanel
		setupPanel(choiceBtnP, new int[] {100, 350, 600, 200});
		choiceBtnP.setLayout(new GridLayout(2,2));
		JButton[] choices = {choice1, choice2, choice3, choice4};
		String[] choiceac = {"c1", "c2", "c3", "c4"};
		for(int i = 0; i < choices.length; i++) {
			setupButton(choices[i], cHandler, choiceac[i], choiceBtnP);
		}
		
		//set up playerPanel
		setupPanel(playerP, new int[] {100, 15, 600, 50});
		playerP.setLayout(new GridLayout(1, 4));
		JLabel[] ppLabel = {hpLabel, hpLabelNumber, moneyLabel, moneyLabelNumber ,weaponLabel, weaponLabelName};
		for(int i = 0; i < 6; i++) {
			setupLabel(ppLabel[i], small, playerP);
		}
		weaponLabel.setBackground(Color.red);
		
	}

	private void setupWindow() {
		//Initial the game window
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
	}
	
	private void setupPanel(JPanel p, int[] b) {
		//set up JPanel with given bounds and set background color to black
		p.setBounds(b[0], b[1], b[2], b[3]);
		p.setBackground(Color.black);
		window.add(p);
	}
	
	private void setupLabel(JLabel l, Font f, JPanel p) {
		//set up JLabel with given font
		l.setForeground(Color.white);
		l.setFont(f);
		p.add(l);
	}
	
	private void setupButton(JButton b, ChoiceHandler cHandler, String ac, JPanel p) {
		//set up JButton with given actioncommand and add it to the given JPanel
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		b.setFont(small);
		b.addActionListener(cHandler);
		b.setActionCommand(ac);
		b.setFocusPainted(false);
		p.add(b);
	}
	
	private void setupMainTextArea() {
		//set up mainTextArea
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(small);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextArea.setWrapStyleWord(true);
		mainP.add(mainTextArea);
	}

}
