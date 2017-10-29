package befaster.solutions;

import java.util.HashMap;

class GroupDiscountResult {
	
	final private int price;
	final private HashMap<Character, Integer> quantities;

	GroupDiscountResult(HashMap<Character, Integer> quantities, int price) {
		this.quantities = quantities;
		this.price = price;
	}

	int getPrice() {
		return price;
	}

	HashMap<Character, Integer> getQuantities() {
		return quantities;
	}

}
