package model;

public class ForestSlot {
	BirdCard birdCard;
	
	public void performAction(Player _player, FoodType _foodType){
		_player.addFoodToken(_foodType);
	}
	public void performBonusOption(Player _player, int index, FoodType _foodType) {
		_player.removeBonusCard(index);
		_player.addFoodToken(_foodType);
	}
	
}
