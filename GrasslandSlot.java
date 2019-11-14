package model;

public class GrasslandSlot {
	BirdCard birdCard;
	
	public void performAction(Player _player, int number_of_eggs){
		_player.addEggs(number_of_eggs);
	}
	public void performBonusOption(Player _player, FoodType _foodType) {
		_player.addEggs(1);
		_player.spendFoodToken(_foodType);
	}
}
