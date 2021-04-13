package game_new.extendClass;

import game_new.UI;

public class VisibilityManager {
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
	}
	
	public void titleToTown() {
		ui.titleP.setVisible(false);
		ui.startBtnP.setVisible(false);
		ui.mainP.setVisible(true);
		ui.choiceBtnP.setVisible(true);
		ui.playerP.setVisible(true);
	}
	
	public void showTitleScreen() {
		ui.titleP.setVisible(true);
		ui.startBtnP.setVisible(true);
		ui.mainP.setVisible(false);
		ui.choiceBtnP.setVisible(false);
		ui.playerP.setVisible(false);
	}
}
