package optionsClass;

import java.util.ArrayList;
import java.util.Random;
//This class will generate the food supply  dice that we can choose for one of the option when we are gaining food
//it will generate a random number of food that the player can then choose from and gain food tokens accordingly
public class birdFeeder {
	
	ArrayList<birdFeeder> foodSupply = new ArrayList<birdFeeder>();
	ArrayList<birdFeeder> foodTokens = new ArrayList<birdFeeder>();
	Random foodDice = new Random();
	int food;
	String foodType;
	String foodToken;
	boolean checkifrolled = false;
	boolean checkrolledfeeder = false;
	//Getters and setters to be implemented with the ArrayList
	
	void setFoodToken(String s){
		foodToken = s;
	}
	String getFoodToken() {
		return foodToken;
	}
	void setFoodType(String s) {
		foodType = s;
	}
	String getFoodType() {
		return foodType;
	}
	
	public void rollFoodFeeder() {
		if(checkifrolled == false) {
			for(int i=0; i<6; i++) {
			
				food = 1 + foodDice.nextInt(6);
				switcher(food);
			}
			checkifrolled = true;
		}else {
			checkBirdFeeder();
		}
	}
	
	//switcher will implement the action of assigning the correct values according to the dice roll
	public void switcher(int food) {
		birdFeeder newFood = new birdFeeder();
		switch (food) {
		case 1: newFood.setFoodType("Invertebrate");
			foodSupply.add(newFood);
			break;
		case 2:	newFood.setFoodType("Seed");
			foodSupply.add(newFood);
			break;
		case 3:	newFood.setFoodType("Fish");
			foodSupply.add(newFood);
			break;
		case 4:	newFood.setFoodType("Fruit");
			foodSupply.add(newFood);
			break;
		case 5:	newFood.setFoodType("Rodent");
			foodSupply.add(newFood);
			break;
		case 6:	newFood.setFoodType("Invertebrate/Seed");
			foodSupply.add(newFood);
			break;
		}
	}
	//function to display the birdFeeder food dice
	public void displayFood() {
		birdFeeder getFoodDice = new birdFeeder();
		
		for(int i = 0; i < foodSupply.size(); i++) {
			getFoodDice = foodSupply.get(i);
			System.out.println("\nFood Dice # " + i + " is: " + getFoodDice.getFoodType());
		}
		System.out.println("cards in array: " + foodSupply.size());
	}
	
	//function that will allow you to select a given food and and add it to your food token supply
	public void selectFoodDice(int dice) {
		birdFeeder selectFood = new birdFeeder();
		birdFeeder addFoodToken = new birdFeeder();
		selectFood = foodSupply.get(dice);
		addFoodToken = foodSupply.get(dice);
		System.out.println("You have selected to gain a food token of: " + selectFood.getFoodType());
		addFoodToken.setFoodToken(selectFood.getFoodType());
		foodTokens.add(addFoodToken);
		foodSupply.remove(dice);
	}

	//function to reset the food Feeder supply and re roll the dice again 
	public void reFreshFoodFeeder() {
		for(int i=0; i< foodSupply.size(); i++) {
			foodSupply.remove(i);
		}
		checkifrolled = false;
		checkrolledfeeder = false;
		rollFoodFeeder();
	}
	
	//function will display all of the food tokens you currently have.
	public void displayFoodTokens() {
		birdFeeder fToken = new birdFeeder();
		for(int i=0; i < foodTokens.size(); i++) {
			fToken = foodTokens.get(i);
			System.out.println("Food Token # " + i + " is: " + fToken.getFoodToken());
		}
		System.out.println("Total food Tokens: " + foodTokens.size());
	}
	
	//function that will allow the player to select the food token they wish to pay
	public void payFoodToken(int n) {
		birdFeeder pToken = new birdFeeder();
		pToken = foodTokens.get(n);
		System.out.println("You are paying a food token of: " + pToken.getFoodToken());
		foodTokens.remove(n);
	}
	
	public void checkBirdFeeder() {
		if(checkifrolled == true) {
			displayFood();
		}
		if(foodSupply.size() == 0) {
			reFreshFoodFeeder();
		}
		else {
			return;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
