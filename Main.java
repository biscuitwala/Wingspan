package optionsClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	public static void main(String args[]) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		Integer cardChoice, option, foodOpt;
		birdClass o = new birdClass("birdListCards.txt");
		
		ArrayList<String> food = new ArrayList<String>();
		food.add("Invertabrate");
		food.add("Seed");
		food.add("Fish");
		food.add("Fruit");
		food.add("Rodent");
	
		
		//These come under player attributes, putting in main for demo
		int actionBlockCount = 8;
		String actionBlockColor = "Red";
		
		
		System.out.println("How many players?");
		int playerno = in.nextInt();
		
		player[] p = new player[playerno];
		
		for(int i=0; i<playerno; i++) {
			System.out.println("Enter player " + (i+1) + " name");
			p[i] = new player(in.next());
		}
		
		for(int i = 0; i<playerno; i++) {
			System.out.println("Player " + (i+1) + " name is " + p[i].getName());
		}
		
		int roundCount = 1;
		
		for(int i = 1; i<5; i++) {
			System.out.println("Round " + roundCount);
			System.out.println();
			for(int j = 0; j<playerno; j++) {
				System.out.println(p[j].getName() + "'s turn");
				System.out.println();
				System.out.println("Your action block color is: " + actionBlockColor);
				System.out.println("Your action block count is: " + actionBlockCount);
				System.out.println("Your food is: " + food);
				System.out.println("You have 2 cards to play");
				
				ArrayList<birdClass> cards = o.drawCards();
				System.out.print("Enter a card Number to Play: ");
				cardChoice = in.nextInt();
				System.out.println();
				o.SelectCardToPlay(cardChoice);
				
				System.out.println("Which option would you play?");
				System.out.println("1 - Play a bird from your hand");
				System.out.println("2 - Gain food and Activate Forest Bird Powers");
				birdFeeder gainFood = new birdFeeder();
				option = in.nextInt();
				if(option == 1) {
					actionBlockCount--;
					//Deplete food tokens
					
					String[] words = cards.get(cardChoice).getBirdFood().split("\\s+");
					for(int k = 0; k<words.length; k++) {
						if(food.contains(words[k])) {
							food.remove(words[k]);
						}
					}
					//Remove from birdList for the player
					cards.remove(cardChoice);
				}
				else if(option == 2) {
					actionBlockCount--;
					//Roll Dice and allot the dice face food to the player's food
					//birdFeeder gainFood = new birdFeeder();
					if(gainFood.checkifrolled == true) {
						continue;//gainFood.rollFoodFeeder();
					}else {
						gainFood.rollFoodFeeder();
					}
					System.out.println("Food you can choose to select from Food Feeder:....... ");
					gainFood.displayFood();
					System.out.println("Select what food you choose to gain: ");
					foodOpt = in.nextInt();
					gainFood.selectFoodDice(foodOpt);
					System.out.println("Food left in the Food Feeder is:........");
					gainFood.displayFood();
					System.out.println("Your total food Tokens:....... ");
					gainFood.displayFoodTokens();
					
				}
				

			}

			
			roundCount++;
		}
		
		
		
		
		
		in.close();
		
	}
}