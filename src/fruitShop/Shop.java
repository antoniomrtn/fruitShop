package fruitShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shop {

	public HashMap <String, Double> processInput (String path) {
		HashMap <String, Double> map = new HashMap <String, Double> ();
		String line = "";  
		String splitBy = ",";  
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(path));  
			while ((line = br.readLine()) != null){  
				String[] record = line.split(splitBy);// use comma as separator
				// If the value is a number, put into the map
				if(isParsable(record[1])){
					map.put(record[0], Double.parseDouble(record[1]));
				}
			}  
		}   
		catch (IOException e){  
			e.printStackTrace();  
		}  
		return map;
	}

	private boolean isParsable(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (final NumberFormatException e) {
			return false;
		}
	}
	
	public Receipt buy(Map<String, Double> stock, Map<String, Double> purchase){
		double total = 0;
		ArrayList<String> productsPurchased = new ArrayList<String>();
		// For each product in the purchase, add it cost for each unit bought
		for (Map.Entry<String,Double> entry : purchase.entrySet()){
			total += stock.get(entry.getKey()) * entry.getValue();
			productsPurchased.add(entry.getKey());
		}
		// Create and return the receipt, which contains the total cost and the products purchased
		Receipt receipt = new Receipt();
		receipt.setCost(total);
		receipt.setFruits(productsPurchased);
		return receipt;
		
	}
}
