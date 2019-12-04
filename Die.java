package model;
import java.util.Random;

public class Die {
	
	public FoodType roll() {
		Random random = new Random();
		FoodType sideUp = null;
		int randomInteger = Math.abs((random.nextInt()%6)+1);
		
		switch(randomInteger) {
		case 1:
			sideUp = FoodType.invertebrate;
			break;
		case 2:
			sideUp = FoodType.seed;
			break;
		case 3:
			sideUp = FoodType.fish;
			break;
		case 4:
			sideUp = FoodType.fruit;
			break;
		case 5:
			sideUp = FoodType.rodent;
			break;
		case 6:
			sideUp = FoodType.any;
			break;
		}
		return sideUp;
	}
	
}
