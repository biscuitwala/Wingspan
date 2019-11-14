package optionsClass;

import java.util.ArrayList;


public class player {
	private String Name;
	private ArrayList<birdClass> birds;
	private int actionCubeCount = 8;
	private String actionCubeColor = "";
	
	public int getActionCubeCount() {
		return actionCubeCount;
	}

	public void setActionCubeCount(int actionCubeCount) {
		this.actionCubeCount = actionCubeCount;
	}

	public String getActionCubeColor() {
		return actionCubeColor;
	}

	public void setActionCubeColor(String actionCubeColor) {
		this.actionCubeColor = actionCubeColor;
	}

	public player() {}; 
	
	public player(String name) {
		Name = name;
	}
	
	public String getName() {
		return Name;
	}
	
	public void addBirdCard(birdClass _bird) {
		birds.add(_bird);
	}
	
	public String getBirdNameByIndex(int _index) {
		return birds.get(_index).getBirdName();
	}
	
	public int numOfBirdCards() {
		return birds.size();
	}
	
	
	
}