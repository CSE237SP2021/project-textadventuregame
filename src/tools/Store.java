package tools;

public class Store {

	public Tool getTool(String toolType) {
		if(toolType == null) {
			return null;
		}
		if(toolType.equalsIgnoreCase("WEAPON")) {
			return new Weapon();
		}else if(toolType.equalsIgnoreCase("ARMOR")) {
			return new Armor();
		}else if(toolType.equalsIgnoreCase("POISSON")) {
			return new Poisson();
		}
		return null;
	}
}
