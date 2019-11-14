package optionsClass;

//for this class you are implementing the number of rounds that each player has and keeping track of the number of action cubes
//we are also keeping track of each of the rounds.
public class actionCube extends birdFeeder{
	int actionCubes = 8;
	int round = 4;
	
	int getActionCubes() {
		return actionCubes;
	}
	int getRounds() {
		return round;
	}
	
	void playedActionCube() {
		if(round > 0) {
			actionCubes = actionCubes - 1;
			if(actionCubes == 0) {
				round = round -1;
				if(round == 3) {
					actionCubes = 7;
				}
				if(round == 2) {
					actionCubes = 6;
				}
				if(round == 1) {
					actionCubes = 5;
				}
			}
		}
		else {
			System.out.println("You have ran out of rounds the game is over for you:\n");
		}
	}

}



	

