package fruitShop;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// main
		Shop shop = new Shop();
		// Process the list of products from CSV
		Map<String, Double> stock = shop.processInput("resources/products.csv");
		// Process the purchase from CSV
		Map<String, Double> purchase = shop.processInput("resources/purchase.csv");
		// Get the total price and products purchased
		Receipt receipt = shop.buy(stock, purchase);
		System.out.println("Products purchased: " + receipt.getFruits());
		System.out.println("Total price: " + receipt.getCost());
	}

}
