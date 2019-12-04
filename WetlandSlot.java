package model;

public class WetlandSlot {
	BirdCard birdCard;
	
	public void performAction(Player _player, BonusCard _bonusCard){
		_player.addBonusCard(_bonusCard);
	}
	public void performBonusOption(Player _player, BonusCard _bonusCard) {
		_player.subtractEggs(1);
		_player.addBonusCard(_bonusCard);
	}
}
