package optionsClass;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class birdClass {
	 // Array List and variables that hold the values of each bird 
	 ArrayList<birdClass> cardList = new ArrayList<birdClass>();
	 Integer birdPoints;
	 String birdName;
	 String birdHabitat;
	 String birdFood;
	 String birdNestType;
	 Integer birdEggLimit;
	 String cardColor;
	 String birdType;
	 String birdPower;
	 Integer birdCardCount = 0;
	 File textFile;
	 Scanner input;
	 String cards;
	 
	 //class constructor that takes in a text file and it reads its contents and initializes an 
	 //array list that later on you can use the arrayList as to each index holds a different bird card
	 public birdClass(String file) throws FileNotFoundException {
		 textFile = new File(file);
		 initializeBirdList(textFile);
		 
	 }
	 
	 //constructor to create objects of the birds
	 public birdClass() {
		 
	 }
	
	 //functions that reads in the information we are obtaining from the text file and initializing 
	 //the cards "birds" abilities.
	void setBirdPower(String bt, String c, String act) {
		if(bt == "skull") {
			birdType = "Predator";
		}else if(bt == "bird"){
			birdType = "Bird Tucking:";
		}else {
			birdType = "normal";
		}
			
		if(c == "Brown") {
			cardColor = "When Activated";
		}else if(c == "Pink") {
			cardColor = "Once Beetween Turns";
		}else {
			cardColor = "When Played:";
		}
		
		birdPower = cardColor + " " + birdType + " " + act;
	 }  

	//setters that set the values of each card accordingly
	 void setBirdPoints(Integer p) {
		 birdPoints = p;
	 }
	 void setBirdName(String n) {
		 birdName = n;
	 }
	 void setBirdHabitat(String h) {
		 birdHabitat = h;
	 }
	 void setBirdFood(String f) {
		 birdFood = f;
	 }
	 void setBirdNest(String bn) {
		 birdNestType = bn;
	 }
	 void setBirdEgg(Integer eg) {
		 birdEggLimit = eg;
	 }
	 //getters that allows us to extract specific values of the cards
	 Integer getBirdPoints() {
		 return birdPoints;
	 }
	 public String getBirdName() {
		 return birdName;
	 }
	 String getBirdHabitat() {
		 return birdHabitat;
	 }
	 String getBirdFood() {
		 return birdFood;
	 }
	 String getBirdNest() {
		 return birdNestType;
	 }
	 Integer getBirdEggLimit() {
		 return birdEggLimit;
	 }
	 String getBirdPower() {
		 return birdPower;
	 }
	 
	 //function that reads the text file and initializes each card with its correct values and puts them into
	 //an Array List to be able to used as playing or drawing cards from a stack 
	void initializeBirdList(File textfile) throws FileNotFoundException {
		try {
			input = new Scanner(textFile);
			String temp;
			String color;
			String activity;
			
			while(input.hasNext()) {
				birdClass newCard = new birdClass();
				temp = input.nextLine();
				newCard.setBirdName(temp);
				temp = input.nextLine();
				newCard.setBirdHabitat(temp);
				temp = input.nextLine();
				newCard.setBirdFood(temp);
				temp = input.nextLine();
				newCard.setBirdPoints(Integer.parseInt(temp));
				temp = input.nextLine();
				newCard.setBirdNest(temp);
				temp = input.nextLine();
				newCard.setBirdEgg(Integer.parseInt(temp));
				temp = input.nextLine();
				color = input.nextLine();
				activity = input.nextLine();
				newCard.setBirdPower(temp, color, activity);
				cardList.add(newCard);
				birdCardCount ++;
				if(input.nextLine() == " ") {
					continue;
				}
				
			}
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//function that allows the player to select a given card from his hand to play, it will display all of the
	//cards attributes.
	public void SelectCardToPlay(Integer select) {
		
		birdClass selCard = new birdClass();
		selCard = cardList.get(select);
		System.out.println("Card selected: ");
		System.out.println("Card Name: " + selCard.getBirdName());
		System.out.println("Habitat: " + selCard.getBirdHabitat());
		System.out.println("Food: " + selCard.getBirdFood());
		System.out.println("Points: " + selCard.getBirdPoints());
		System.out.println("Nest: "+ selCard.getBirdNest());
		System.out.println("Egg Limit: " + selCard.getBirdEggLimit());
		System.out.println("Ability: "+ selCard.getBirdPower());
		System.out.println();
		
		
		
	}
	
	
	public ArrayList<birdClass> drawCards() {
		//Temporarily returning cardlist to access in main, so that we can deplete food. 
		//Preferably, this method would be moved to Player to accommodate for each player's tokens and cubes
		birdClass getCard = new birdClass();
		
		for(int a=0; a < cardList.size(); a++) {
			getCard = cardList.get(a);
			System.out.println("Card Number: " + a);
			System.out.println("Card Name: " + getCard.getBirdName());
			System.out.println("Habitat: " + getCard.getBirdHabitat());
			System.out.println("Food: " + getCard.getBirdFood());
			System.out.println("Points: " + getCard.getBirdPoints());
			System.out.println("Nest: "+ getCard.getBirdNest());
			System.out.println("Egg Limit: " + getCard.getBirdEggLimit());
			System.out.println("Ability: "+ getCard.getBirdPower());
			System.out.println();
		}
		System.out.println("Cards in ArrayList: " + birdCardCount);
		return this.cardList;
	}
	
}
