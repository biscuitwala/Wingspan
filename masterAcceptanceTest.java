package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class masterAcceptanceTest {
	
	Player testPlayer = new Player("_testPlayer");
	ForestSlot forestSlotTest = new ForestSlot();
	GrasslandSlot grasslandSlotTest = new GrasslandSlot();
	WetlandSlot wetlandSlotTest = new WetlandSlot();
	BonusCard testBonusCard = new BonusCard();
	
	@Test
	void testMatSlots() {
		for (int i = 0; i < 50; i++) {
			testPlayer.addFoodToken(FoodType.fish);
		}
		testPlayer.addEggs(50);
		for (int i = 0; i < 5; i++ ) {
			testPlayer.addBonusCard(testBonusCard);
		}
		
		forestSlotTest.performAction(testPlayer, FoodType.fish);
		forestSlotTest.performBonusOption(testPlayer, 4, FoodType.fish);
		
		grasslandSlotTest.performAction(testPlayer, 1);
		grasslandSlotTest.performBonusOption(testPlayer, FoodType.fish);
		
		wetlandSlotTest.performAction(testPlayer, testBonusCard);
		wetlandSlotTest.performBonusOption(testPlayer, testBonusCard);
		
		assertEquals(51,testPlayer.getNumberOfFoodTokens(FoodType.fish));
		assertEquals(51,testPlayer.getNumberOfEggs());
		assertEquals(6,testPlayer.getNumberOfBonusCards());
	}
	
	void testBirdCards() {
		
		BirdCard newBird = new BirdCard();
		newBird.addHabitat(HabitatType.forest);
		newBird.addFoodCost(FoodType.fish);
		
		assertEquals(HabitatType.forest, newBird.getHabitatType());
		assertEquals(FoodType.fish, newBird.getFoodType());	
	}
	
	
}
