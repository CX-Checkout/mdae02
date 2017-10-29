package befaster.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Bill {

	Map<Character, Integer> quantities = new HashMap<>();
	
	public Bill(String items) {
		for (int i = 0; i < items.length(); i++) {
			char item = items.charAt(i);
			quantities.put(item, quantities.getOrDefault(item, 0)+1);
		}
	}

	int getQuantity(char item) {
		return quantities.getOrDefault(item, 0);
	}

	int value(Map<Character, SKU> skus, GroupDiscount groupDiscount) {
		int result = 0;
		
		GroupDiscountResult groupDiscountResult = groupDiscount.apply(quantities, skus, this);
		result += groupDiscountResult.getPrice();
		HashMap<Character, Integer> discountedQuantities = groupDiscountResult.getQuantities();
		
		for (Entry<Character, Integer> quantity : quantities.entrySet()) {
			if (skus.containsKey(quantity.getKey())) {
				Integer number = quantity.getValue() - discountedQuantities.getOrDefault(quantity.getKey(), 0);
				result += skus.get(quantity.getKey()).valueOf(number, this);
			}else {
				return -1;
			}
		}
		return result;
	}

}
