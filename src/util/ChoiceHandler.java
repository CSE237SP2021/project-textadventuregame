package util;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.Story;


public class ChoiceHandler implements ActionListener{
 
	private Game game;
	private VisibilityManager vm;
	private Story story;
	
	public ChoiceHandler(Game game, VisibilityManager vm, Story story) {
		this.game = game;
		this.vm = vm;
		this.story = story;
	}
 
	public void actionPerformed(ActionEvent event){
  
		String yourChoice = event.getActionCommand();
  
		switch(yourChoice){
			case "start1": 
				story.Setup(100, "Bowie", 5);
				vm.titleToTown();
				story.mysteryGate();
				break;
			case "start2": 
				story.Setup(50,"Bowie", 5);
				vm.titleToTown();
				story.mysteryGate();
				break;
			case "c1": 
				story.selectPosition(game.getNextPosition1());
				break;
			case "c2": 
				story.selectPosition(game.getNextPosition2());
				break;
			case "c3": 
				story.selectPosition(game.getNextPosition3());
				break;
			case "c4":
				story.selectPosition(game.getNextPosition4());
				break;
		}
	}
}
