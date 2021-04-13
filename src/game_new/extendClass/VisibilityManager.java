package game_new.extendClass;

import game_new.UI;

public class VisibilityManager {
	
	private UI ui;
	
	public VisibilityManager(UI userInterface) {
		ui = userInterface;
	}
	
	public void titleToTown() {
		//Hide the title screen
		ui.titleP.setVisible(false);
		ui.startBtnP.setVisible(false);
		//ui.startBtnP1.setVisible(false);
		//show the game screen
		ui.mainP.setVisible(true);
		ui.choiceBtnP.setVisible(true);
		ui.playerP.setVisible(true);
	}
	
	public void showTitleScreen() {
		//show the title screen
		ui.titleP.setVisible(true);
		//ui.startBtnP1.setVisible(true);
		ui.startBtnP.setVisible(true);
		//Hide the game screen
		ui.mainP.setVisible(false);
		ui.choiceBtnP.setVisible(false);
		ui.playerP.setVisible(false);
	}
}
