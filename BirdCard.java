package model;

import java.util.ArrayList;

public class BirdCard {
	
	BirdCard(){}
	
	String layName, scientificName;
	ArrayList<HabitatType> habitat = new ArrayList<HabitatType>();
	ArrayList<FoodType> foodCost = new ArrayList<FoodType>();
	int points, eggCost, eggs;
	
	BirdCard(String _layName, String _scientificName){
		layName = _layName;
		scientificName = _scientificName;
	}
	public void addHabitat(HabitatType _habitat){ habitat.add(_habitat);}
	public HabitatType getHabitatType() {
		return habitat.get(0);
	}
	public void addFoodCost(FoodType _foodCost){ foodCost.add(_foodCost);}
	public FoodType getFoodType() {
		return foodCost.get(0);
	}
	public void setPoints(int _points) { points = _points;}
	public void setEggCost(int _eggCost) { eggCost = _eggCost; }
	
	
}
