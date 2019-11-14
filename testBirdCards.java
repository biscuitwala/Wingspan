package optionsClass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testBirdCards {

	
	ArrayList<birdClass> cards = new ArrayList<birdClass>();
	

	// Tester that test different attributes of the cards which will make it easier for use to 
	// determine how to play each card accordingly.
	 @Test
	 
	void birdCards() {
		
		birdClass newBird0 = new birdClass();
		newBird0.setBirdHabitat("forest");
		birdClass newBird1 = new birdClass();
		newBird1.setBirdFood("insects");;
		birdClass newBird2 = new birdClass();
		newBird2.setBirdNest("colorful");
		
		cards.add(newBird0);
		cards.add(newBird1);
		cards.add(newBird2);
		
		assertEquals("forest", cards.get(0).getBirdHabitat());
		assertEquals("insects", cards.get(1).getBirdFood());
		assertEquals("colorful",cards.get(2).getBirdNest());
		
		
	}
	
	
	
}
