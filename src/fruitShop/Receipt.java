package fruitShop;

import java.util.ArrayList;

public class Receipt {
	private double cost;
	private ArrayList<String> fruits;
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ArrayList<String> getFruits() {
		return fruits;
	}
	public void setFruits(ArrayList<String> fruits) {
		this.fruits = fruits;
	}
}
